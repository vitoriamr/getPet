package com.es.getpet.core.enuns;

public enum Sexo {

	MASCULINO((short) 0),
	FEMININO((short) 1);

	private short codigoSexo;

	Sexo(short codigoSexo) {
		this.codigoSexo = codigoSexo;
	}

	public short getCodigoEspecie() {
		return codigoSexo;
	}

	public static Sexo parse(short codigoSexo) {
		Sexo result;
		if (codigoSexo == 0) {
			result = MASCULINO;
		} else if (codigoSexo == 1) {
			result = FEMININO;
		} else {
			result = null;
		}
		return result;
	}

}
