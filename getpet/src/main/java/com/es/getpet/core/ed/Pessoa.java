package com.es.getpet.core.ed;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.es.getpet.core.util.ED;

@MappedSuperclass
public class Pessoa extends ED {

	@Column(nullable = false, length = 200)
	private String nome;

	@Column(nullable = false, length = 200)
	private String endereco;

	@Column(length = 100)
	private String email;

	@Column
	private Long cpf;

	@Column(length = 15)
	private String telefone;

	@Column
	private String obs;

	@Column(nullable = false, length = 100)
	private String loginName;

	@Column(nullable = false, length = 15)
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}