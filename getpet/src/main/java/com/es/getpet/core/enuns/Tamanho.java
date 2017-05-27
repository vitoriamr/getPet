package com.es.getpet.core.enuns;

public enum Tamanho {

	PEQUENO((short) 0),
	MEDIO((short) 1),
	GRANDE((short) 2);

	private short codigoTamanho;

	Tamanho(short codigoTamanho) {
		this.codigoTamanho = codigoTamanho;
	}

	public short getCodigoTamanho() {
		return codigoTamanho;
	}

	public static Tamanho parse(short codigoTamanho) {
		Tamanho result;
		if (codigoTamanho == 0) {
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

}
