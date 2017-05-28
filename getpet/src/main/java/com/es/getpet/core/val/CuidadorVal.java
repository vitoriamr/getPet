package com.es.getpet.core.val;

import com.es.getpet.core.ed.Cuidador;
import com.es.getpet.core.util.VAL;

public class CuidadorVal extends VAL<Cuidador> {

	@Override
	public void validaSalva(Cuidador cuidador) {
		super.validaSalva(cuidador);
		if (cuidador.getNome() == null || cuidador.getNome().trim().isEmpty()) {
			throw new IllegalArgumentException("O nome do Cuidador não pode ser nulo.");
		}
		if (cuidador.getEndereco() == null || cuidador.getEndereco().trim().isEmpty()) {
			throw new IllegalArgumentException("O endereço do Cuidador não pode ser nulo.");
		}
		if (cuidador.getLoginName() == null || cuidador.getLoginName().trim().isEmpty()) {
			throw new IllegalArgumentException("O LoginName do Cuidador não pode ser nulo.");
		}
		if (cuidador.getSenha() == null || cuidador.getSenha().trim().isEmpty()) {
			throw new IllegalArgumentException("A senha do Cuidador não pode ser nula");
		}
	}

}
