package com.es.getpet.core.ed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.es.getpet.core.enuns.Especie;
import com.es.getpet.core.enuns.Sexo;
import com.es.getpet.core.enuns.Tamanho;
import com.es.getpet.core.enuns.Temperamento;
import com.es.getpet.core.enuns.Unidade;
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

    @Column
    private Short unidade;

    @Column(nullable = false)
	private Short tamanho;

    @Column
	private Short temperamento;

    @Column
	private String doencasLimitacoes;

    @Column
	private String obs;

    @ManyToOne
    private Cuidador cuidador;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Especie getEspecie() {
		return Especie.parse(especie);
	}

	public void setEspecie(Especie especie) {
		this.especie = especie != null ? especie.getCodigoEspecie() : null;
	}

	public Sexo getSexo() {
		return Sexo.parse(sexo);
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo != null ? sexo.getCodigoSexo() : null;
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

	public Unidade getUnidade() {
		return Unidade.parse(unidade);
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade != null ? unidade.getCodigoUnidade() : null;
	}

	public Tamanho getTamanho() {
		return Tamanho.parse(tamanho);
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho != null ? tamanho.getCodigoTamanho() : null;
	}

	public Temperamento getTemperamento() {
		return Temperamento.parse(temperamento);
	}

	public void setTemperamento(Temperamento temperamento) {
		this.temperamento = temperamento != null ? temperamento.getCodigoTemperamento() : null;
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
