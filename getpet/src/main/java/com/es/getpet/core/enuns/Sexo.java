package com.es.getpet.core.enuns;

public enum Sexo {

	MACHO((short) 0, "Macho"),
	FEMEA((short) 1, "Fêmea");

	private short codigoSexo;
	private String descricao;

	Sexo(short codigoSexo, String descricao) {
		this.codigoSexo = codigoSexo;
		this.descricao = descricao;
	}

	public short getCodigoSexo() {
		return codigoSexo;
	}

	public static Sexo parse(Short codigoSexo) {
		Sexo result;
		if (codigoSexo == null) {
			result = null;
		} else if (codigoSexo == 0) {
			result = MACHO;
		} else if (codigoSexo == 1) {
			result = FEMEA;
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
