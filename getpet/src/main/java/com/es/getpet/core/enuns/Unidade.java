package com.es.getpet.core.enuns;

public enum Unidade {

	DIAS((short) 0, "Dia(s)"),
	SEMANAS((short) 1, "Semana(s)"),
	MESES((short) 2, "Mês(es)"),
	ANOS((short) 3, "Ano(s)");

	private short codigoUnidade;
	private String descricao;

	Unidade(short codigoTamanho, String descricao) {
		this.codigoUnidade = codigoTamanho;
		this.descricao = descricao;
	}

	public short getCodigoUnidade() {
		return codigoUnidade;
	}

	public static Unidade parse(Short codigoUnidade) {
		Unidade result;
		if (codigoUnidade == null) {
			result = null;
		} else if (codigoUnidade == 0) {
			result = DIAS;
		} else if (codigoUnidade == 1) {
			result = MESES;
		} else if (codigoUnidade == 2){
			result = SEMANAS;
		} else if (codigoUnidade == 3){
			result = ANOS;
		} else {
			result = null;
		}
		return result;
	}

	@Override
	public String toString() {
		return descricao;
	}

}