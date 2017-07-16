package com.es.getpet.core.val;

import com.es.getpet.core.ed.Adocao;
import com.es.getpet.core.util.VAL;

public class AdocaoVal extends VAL<Adocao> {

	private static final String ATRIBUTO_INVALIDO = "Adoção inválida. %s nulo ou não identificado.";

	public void validaSalva(Adocao adocao) {
		super.validaSalva(adocao);
		if (adocao.getAdotante() == null || adocao.getAdotante().getId() == null) {
			throw new IllegalArgumentException(String.format(ATRIBUTO_INVALIDO, "Adotante"));
		}
		if (adocao.getCuidador() == null || adocao.getCuidador().getId() == null) {
			throw new IllegalArgumentException(String.format(ATRIBUTO_INVALIDO, "Cuidador"));
		}
		if (adocao.getAnimal() == null || adocao.getAnimal().getId() == null) {
			throw new IllegalArgumentException(String.format(ATRIBUTO_INVALIDO, "Animal"));
		}
		if (adocao.getStatusAdocao() == null) {
			throw new IllegalArgumentException(String.format(ATRIBUTO_INVALIDO, "Status de Adoção"));
		}
	}

}
