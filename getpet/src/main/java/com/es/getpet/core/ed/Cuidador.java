package com.es.getpet.core.ed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "cuidador", catalog = "", schema = "public")
public class Cuidador extends Pessoa {

	@Column
    private Long cnpj;

	@OneToOne(fetch = FetchType.LAZY, mappedBy="cuidador", optional = true)
    private Animal animal;

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
}