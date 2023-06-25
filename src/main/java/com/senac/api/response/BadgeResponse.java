package com.senac.api.response;

import com.senac.api.entity.BadgeNivel;

public class BadgeResponse {

	private Integer id;
	private String descricao;
	private byte[] img;
	private Boolean status;
	private BadgeNivel badgeNivelId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
