package com.es.getpet.core.ed;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "cuidador", schema = "public",
	uniqueConstraints =
			{
				@UniqueConstraint(columnNames = "loginName", name="UniqueLoginName"),
				@UniqueConstraint(columnNames = "cpf", name="UniqueCpf"),
				@UniqueConstraint(columnNames = "cnpj", name="UniqueCnpj")
			},
	indexes =
			{
				@Index(name = "idx_loginName_senha",  columnList="loginName, senha", unique = true)
			}
)
public class Cuidador extends Pessoa {

	@Column
    private Long cnpj;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="cuidador")
    private List<Animal> listaAnimais;

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public List<Animal> getListaAnimais() {
		return listaAnimais;
	}

	public void setListaAnimais(List<Animal> listaAnimais) {
		this.listaAnimais = listaAnimais;
	}

}