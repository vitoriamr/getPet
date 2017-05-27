package com.es.getpet.core.val;

import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.util.VAL;

public class AnimalVal extends VAL<Animal> {

	@Override
	public void validaSalva(Animal animal) {
		super.validaSalva(animal);
		if (animal.getNome() == null || animal.getNome().isEmpty()) {
			throw new IllegalArgumentException("O nome do animal não foi especificado.");
		}
		if (animal.getEspecie() == null) {
			throw new IllegalArgumentException("A espécie do animal não foi especificada.");
		}
		if (animal.getTamanho() == null) {
			throw new IllegalArgumentException("O tamanho do animal não foi especificado.");
		}
	}

}
