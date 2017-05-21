package com.es.getpet.core.ed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.es.getpet.core.util.ED;

@Entity
@Table(name = "animal", catalog = "", schema = "public")
public class Animal extends ED {

    @Column(nullable = false, length = 200)
	private String nome;

    @Column(nullable = false)
	private Short especie;

    @Column(name = "sexo")
	private Short sexo;

    @Column(name = "castrado")
	private Boolean castrado;

    @Column(name = "raca")
	private String raca;

    @Column(name = "idade")
	private Short idade;

    @Column(name = "tamanho", nullable = false)
	private Short tamanho;

    @Column(name = "temperamento")
	private Short temperamento;

    @Column(name = "doencasLimitacoes")
	private String doencasLimitacoes;

    @Column(name = "obs")
	private String obs;

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


}
