package com.senac.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.senac.api.DTO.BadgeDTO;
import com.senac.api.entity.Badge;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.BadgeRepository;


@Service
public class BadgeService {
	
	@Autowired
	private BadgeRepository badgeRepository;
	
	public BadgeDTO adicionar(BadgeDTO badgeDto) {
		badgeDto.setId(null);
		ModelMapper mapper = new ModelMapper();
		Badge badge = mapper.map(badgeDto, Badge.class);	
		badge = badgeRepository.save(badge);
		badgeDto.setId(badge.getId());
		return badgeDto;
	}
	
	public Badge upload(MultipartFile file, Badge badge) throws Exception {
		   //ModelMapper mapper = new ModelMapper();
	       String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	       
	       try {
	            if(fileName.contains("..")) {
	                throw  new Exception("Filename contains invalid path sequence " + fileName);
	            }

	            return badgeRepository.save(badge);

	       } catch (Exception e) {
	            throw new Exception("Could not save File: " + fileName);
	       }
	}

	public List<Badge> buscar(Badge badge){
		//ModelMapper mapper = new ModelMapper();
		//Badge filter = mapper.map(badge,  Badge.class);
		Example<Badge> example = Example.of(badge, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		return badgeRepository.findAll(example);
	}
	
	
	public List<BadgeDTO> obterTodos(){
		List<Badge> badges = badgeRepository.findAll();
		return badges.stream().map(badge -> new ModelMapper().map(badge, BadgeDTO.class)).collect((Collectors.toList()));
	}
	
	public Optional<BadgeDTO> obterPorId(Long id){
		Optional<Badge> badge = badgeRepository.findById(id);
		
		if(badge.isEmpty()) {
			throw new ObjectnotFoundException("BADGE COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		BadgeDTO dto = new ModelMapper().map(badge.get(), BadgeDTO.class);
		return Optional.of(dto);
	}
	
	public List<BadgeDTO> obterPorNivel(Long id){
		List<Badge> badges = badgeRepository.findByNivel(id);
		
		if(badges.isEmpty()) {
			throw new ObjectnotFoundException("NÍVEL COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		return badges.stream().map(badge -> new ModelMapper().map(badge, BadgeDTO.class)).collect((Collectors.toList()));
	}
	
	
	public void deletar(Long id) {
		Optional<Badge> badge = badgeRepository.findById(id);
		
		if(badge.isEmpty()) {
			throw new ObjectnotFoundException("O ID '" + id +  "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		
		badgeRepository.deleteById(id);
	}
	
	public BadgeDTO atualizar(Long id, BadgeDTO badgeDto) {
		Optional<Badge> badgeId = badgeRepository.findById(id);
		
		if(badgeId.isEmpty()) {
			throw new ObjectnotFoundException("O ID '" + id +  "' INFORMADO NÃO EXISTE NO SISTEMA!");
		}
		badgeDto.setId(id);
		badgeDto.setId(id);
		ModelMapper mapper = new ModelMapper();
		Badge badge = mapper.map(badgeDto, Badge.class);
		badgeRepository.save(badge);
		return badgeDto;
	}
	
}
