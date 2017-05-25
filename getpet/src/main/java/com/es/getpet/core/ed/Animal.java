package com.es.getpet.core.ed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.es.getpet.core.util.ED;

@Entity
@Table(name = "animal", catalog = "", schema = "public")
public class Animal extends ED {

    @Column(nullable = false, length = 200)
	private String nome;

    @Column(nullable = false)
	private Short especie;

    @Column
	private Short sexo;

    @Column
	private Boolean castrado;

    @Column
	private String raca;

    @Column
	private Short idade;

    @Column(nullable = false)
	private Short tamanho;

    @Column
	private Short temperamento;

    @Column
	private String doencasLimitacoes;

    @Column
	private String obs;

    @OneToOne
    private Cuidador cuidador;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Short getEspecie() {
		return especie;
	}

	public void setEspecie(Short especie) {
		this.especie = especie;
	}

	public Short getSexo() {
		return sexo;
	}

	public void setSexo(Short sexo) {
		this.sexo = sexo;
	}

	public Boolean getCastrado() {
		return castrado;
	}

	public void setCastrado(Boolean castrado) {
		this.castrado = castrado;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Short getIdade() {
		return idade;
	}

	public void setIdade(Short idade) {
		this.idade = idade;
	}

	public Short getTamanho() {
		return tamanho;
	}

	public void setTamanho(Short tamanho) {
		this.tamanho = tamanho;
	}

	public Short getTemperamento() {
		return temperamento;
	}

	public void setTemperamento(Short temperamento) {
		this.temperamento = temperamento;
	}

	public String getDoencasLimitacoes() {
		return doencasLimitacoes;
	}

	public void setDoencasLimitacoes(String doencasLimitacoes) {
		this.doencasLimitacoes = doencasLimitacoes;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Cuidador getCuidador() {
		return cuidador;
	}

	public void setCuidador(Cuidador cuidador) {
		this.cuidador = cuidador;
	}

}
