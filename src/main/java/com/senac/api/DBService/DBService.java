package com.senac.api.DBService;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.api.entity.BadgeNivel;
import com.senac.api.repository.BadgeNivelRepository;

@Service
public class DBService {
	
	@Autowired
	private BadgeNivelRepository badgeNivelRepository;
	
	public void instanciaDB() {	
		
		//badge_nivel
		BadgeNivel nivel1 = new BadgeNivel(null, "Junior");
		BadgeNivel nivel2 = new BadgeNivel(null, "Pleno");
		BadgeNivel nivel3 = new BadgeNivel(null, "Sênior");
		badgeNivelRepository.saveAll(Arrays.asList(nivel1, nivel2, nivel3));
		
	}
	
}
