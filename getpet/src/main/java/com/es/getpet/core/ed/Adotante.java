package com.es.getpet.core.ed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "adotante", catalog = "", schema = "public")
public class Adotante extends Pessoa {
	
	@Column(name = "ja_adotou", nullable = false)
	private Boolean jaAdotou;

	@Column(name = "qte_animais", nullable = false)
	private Integer qteAnimais;

	public Boolean getJaAdotou() {
		return jaAdotou;
	}

	public void setJaAdotou(Boolean jaAdotou) {
		this.jaAdotou = jaAdotou;
	}

	public Integer getQteAnimais() {
		return qteAnimais;
	}

	public void setQteAnimais(Integer qteAnimais) {
		this.qteAnimais = qteAnimais;
	}
}
