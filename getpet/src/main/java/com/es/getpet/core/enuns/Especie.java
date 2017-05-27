package com.es.getpet.core.enuns;

public enum Especie {

	GATO((short) 0, "Gato"),
	CAO((short) 1, "Cão");

	private short codigoEspecie;
	private String descricao;

	Especie(short codigoEspecie, String descricao) {
		this.codigoEspecie = codigoEspecie;
		this.descricao = descricao;
	}

	public short getCodigoEspecie() {
		return codigoEspecie;
	}

	public static Especie parse(Short codigoEspecie) {
		Especie result;
		if (codigoEspecie == null) {
			result = null;
		} else if (codigoEspecie == 0) {
			result = GATO;
		} else if (codigoEspecie == 1) {
			result = CAO;
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
