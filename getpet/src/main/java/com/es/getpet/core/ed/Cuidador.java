package com.es.getpet.core.ed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "cuidador", catalog = "", schema = "public")
public class Cuidador extends Pessoa {
    @Column
    private Long cnpj;
    
    @Column
    Animal animal;

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