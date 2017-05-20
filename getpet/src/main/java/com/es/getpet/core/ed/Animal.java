package com.es.getpet.core.ed;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "animal", catalog = "", schema = "public")
@SequenceGenerator(name = "empresa_id", sequenceName = "animal_id_seq", allocationSize = 1)
public class Animal {

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

    @Basic(optional = false)
    @Column(name = "nome")
	private String nome;

    @Column(name = "especie")
	private Short especie;

    @Column(name = "sexo")
	private Short sexo;

    @Column(name = "castrado")
	private Boolean castrado;

    @Column(name = "raca")
	private String raca;

    @Column(name = "idade")
	private Short idade;

    @Column(name = "tamanho")
	private Short tamanho;

    @Column(name = "temperamento")
	private Short temperamento;

    @Column(name = "doencasLimitacoes")
	private String doencasLimitacoes;

    @Column(name = "obs")
	private String obs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
