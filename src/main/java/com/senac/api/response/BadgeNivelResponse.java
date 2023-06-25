package com.senac.api.response;

import java.util.List;

import com.senac.api.entity.Badge;

public class BadgeNivelResponse {
	
	private Long id;	
	private String descricao;
	private List<Badge> badges;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Badge> getBadges() {
		return badges;
	}

	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}

	
}
