package com.es.getpet.core.enuns;

public enum Temperamento {

	DOCIL((short) 0, "Dócil"),
	MODERADO((short) 1, "Moderado"),
	BRAVO((short) 2, "Bravo"),
	AGRESSIVO((short) 3, "Agressivo");

	private short codigoTemperamento;
	private String descricao;

	Temperamento(short codigoTemperamento, String descricao) {
		this.codigoTemperamento = codigoTemperamento;
		this.descricao = descricao;
	}

	public short getCodigoTemperamento() {
		return codigoTemperamento;
	}

	public static Temperamento parse(Short codigoTemperamento) {
		Temperamento result;
		if (codigoTemperamento == null) {
			result = null;
		} else if (codigoTemperamento == 0) {
			result = DOCIL;
		} else if (codigoTemperamento == 1) {
			result = MODERADO;
		} else if (codigoTemperamento == 2){
			result = BRAVO;
		} else if (codigoTemperamento == 3){
			result = AGRESSIVO;
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
