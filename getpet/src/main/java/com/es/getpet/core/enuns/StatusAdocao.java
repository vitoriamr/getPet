package com.es.getpet.core.enuns;

public enum StatusAdocao {

	CANDIDATO_ADOCAO((short) 0, "Candidato a Adoção"),
	ADOCAO_EFETIVADA((short) 1, "Adoção efetivada"),
	ADOCAO_CANCELADA((short) 2, "Adoção cancelada pelo Adotante"),
	ADOCAO_RECUSADA((short) 3, "Adoção recusada pelo Cuidador");

	private final short codStatus;
	private final String descricaoStatus;

	StatusAdocao(short codStatus, String descricaoStatus) {
		this.codStatus = codStatus;
		this.descricaoStatus = descricaoStatus;
	}

	public static StatusAdocao parse(short codStatus) {
		StatusAdocao statusAdocao;
		if (codStatus == 0) {
			statusAdocao = CANDIDATO_ADOCAO;
		} else if (codStatus == 1) {
			statusAdocao = ADOCAO_EFETIVADA;
		} else if (codStatus == 2) {
			statusAdocao = ADOCAO_CANCELADA;
		} else if (codStatus == 3) {
			statusAdocao = ADOCAO_RECUSADA;
		} else {
			throw new IllegalArgumentException("Código de status inválido.");
		}
		return statusAdocao;
	}

	public short getValor() {
		return codStatus;
	}

	public String getDescricao() {
		return descricaoStatus;
	}

}
