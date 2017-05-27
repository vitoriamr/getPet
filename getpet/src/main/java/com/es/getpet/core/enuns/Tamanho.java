package com.es.getpet.core.enuns;

public enum Tamanho {

	PEQUENO((short) 0, "Pequeno"),
	MEDIO((short) 1, "Médio"),
	GRANDE((short) 2, "Grande");

	private short codigoTamanho;
	private String descricao;

	Tamanho(short codigoTamanho, String descricao) {
		this.codigoTamanho = codigoTamanho;
		this.descricao = descricao;
	}

	public short getCodigoTamanho() {
		return codigoTamanho;
	}

	public static Tamanho parse(Short codigoTamanho) {
		Tamanho result;
		if (codigoTamanho == null) {
			result = null;
		} else if (codigoTamanho == 0) {
			result = PEQUENO;
		} else if (codigoTamanho == 1) {
			result = MEDIO;
		} else if (codigoTamanho == 2){
			result = GRANDE;
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