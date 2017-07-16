package com.es.getpet.core.rn;

import com.es.getpet.core.bd.AdocaoDAO;
import com.es.getpet.core.ed.Adocao;
import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.util.RN;
import com.es.getpet.core.val.AdocaoVal;

public class AdocaoRN extends RN<Adocao> {

	private final AnimalRN animalRN;

	public AdocaoRN() {
		super(new AdocaoDAO(), new AdocaoVal());
		animalRN = new AnimalRN();
	}

	public Adocao salva(Adocao adocao) {
		adocao = super.salva(adocao);
		Animal animal = animalRN.consulta(adocao.getAnimal());
		animal.setAdocao(adocao);
		animalRN.atualiza(animal);
		return adocao;
	}

	public boolean adotaAnimal(Adocao adocao) {
		Adocao adocaoSalva = salva(adocao);
		return adocaoSalva != null;
	}

	public void cancelaAdocao(Adocao adocao) {
		remove(adocao);
	}

	public void reprovaAdocao(Adocao adocao) {
		remove(adocao);
	}

}