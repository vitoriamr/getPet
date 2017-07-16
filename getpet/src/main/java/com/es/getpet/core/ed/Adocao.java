package com.es.getpet.core.ed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.es.getpet.core.enuns.StatusAdocao;
import com.es.getpet.core.util.ED;

@Entity
@Table(name = "adocao", catalog = "", schema = "public")
public class Adocao extends ED {

	@ManyToOne(optional = false)
	//@JoinColumn(name="adotante_id")
	private Adotante adotante;

	@ManyToOne(optional = false)
	//@JoinColumn(name="cuidador_id")
	private Cuidador cuidador;

	@OneToOne(optional = false)
	//@JoinColumn(name="animal_id")
	private Animal animal;

	@Column(nullable = false)
	private Short statusAdocao;

	public Adotante getAdotante() {
		return adotante;
	}

	public void setAdotante(Adotante adotante) {
		this.adotante = adotante;
	}

	public Cuidador getCuidador() {
		return cuidador;
	}

	public void setCuidador(Cuidador cuidador) {
		this.cuidador = cuidador;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public StatusAdocao getStatusAdocao() {
		return StatusAdocao.parse(statusAdocao);
	}

	public void setStatusAdocao(StatusAdocao statusAdocao) {
		this.statusAdocao = statusAdocao.getValor();
	}

}