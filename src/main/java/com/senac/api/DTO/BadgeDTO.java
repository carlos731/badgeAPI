package com.senac.api.DTO;

import com.senac.api.entity.BadgeNivel;

public class BadgeDTO {

	private Long id;
	private String descricao;
	private byte[] img;
	private Boolean status;
	private BadgeNivel badgeNivelId;

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

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public BadgeNivel getBadgeNivelId() {
		return badgeNivelId;
	}

	public void setBadgeNivelId(BadgeNivel badgeNivelId) {
		this.badgeNivelId = badgeNivelId;
	}


}
