package com.es.getpet.core.enuns;

public enum Especie {

	GATO((short) 0),
	CAO((short) 1);

	private short codigoEspecie;

	Especie(short codigoEspecie) {
		this.codigoEspecie = codigoEspecie;
	}

	public short getCodigoEspecie() {
		return codigoEspecie;
	}

	public static Especie parse(short codigoEspecie) {
		Especie result;
		if (codigoEspecie == 0) {
			result = GATO;
		} else if (codigoEspecie == 1) {
			result = CAO;
		} else {
			result = null;
		}
		return result;
	}
}
