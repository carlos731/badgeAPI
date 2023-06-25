package com.senac.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.api.DTO.BadgeNivelDTO;
import com.senac.api.request.BadgeNivelRequest;
import com.senac.api.response.BadgeNivelResponse;
import com.senac.api.service.BadgeNivelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/badge-nivel")
public class BadgeNivelController {
		
	@Autowired
	private BadgeNivelService badgeNivelService;
	
	@PostMapping
	public ResponseEntity<BadgeNivelResponse> adicionar(@Valid @RequestBody BadgeNivelRequest badgeNivelReq){
		ModelMapper mapper = new ModelMapper();
		BadgeNivelDTO badgeNivelDto = mapper.map(badgeNivelReq, BadgeNivelDTO.class);
		badgeNivelDto = badgeNivelService.adicionar(badgeNivelDto);
		return new ResponseEntity<>(mapper.map(badgeNivelDto, BadgeNivelResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<BadgeNivelResponse>> obterTodos(){
		List<BadgeNivelDTO> niveis = badgeNivelService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<BadgeNivelResponse> resposta = niveis.stream().map(nivel -> mapper.map(nivel, BadgeNivelResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<BadgeNivelResponse>> obterPorId(@PathVariable Long id){
		Optional<BadgeNivelDTO> dto = badgeNivelService.obterPorId(id);
		BadgeNivelResponse badge = new ModelMapper().map(dto.get(), BadgeNivelResponse.class);
		return new ResponseEntity<>(Optional.of(badge), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BadgeNivelResponse> atualizar(@Valid @RequestBody BadgeNivelRequest badgeNivelReq,@PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		BadgeNivelDTO badgeNivelDto = mapper.map(badgeNivelReq, BadgeNivelDTO.class);
		badgeNivelDto = badgeNivelService.atualizar(id, badgeNivelDto);
		return new ResponseEntity<>(mapper.map(badgeNivelDto, BadgeNivelResponse.class), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		badgeNivelService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
