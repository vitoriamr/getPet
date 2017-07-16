package com.es.getpet.core.rn;

import java.util.List;

import com.es.getpet.core.bd.AnimalDAO;
import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.ed.Cuidador;
import com.es.getpet.core.util.RN;
import com.es.getpet.core.val.AnimalVal;

public class AnimalRN extends RN<Animal> {

	public AnimalRN() {
		super(new AnimalDAO(), new AnimalVal());
	}

	public List<Animal> getListaAnimaisDisponiveis() {
		return getAnimalDAO().getListaAnimaisDisponiveis();
	}

	public List<Animal> getListaAnimaisCuidador(Cuidador cuidador) {
		return getAnimalDAO().getListaAnimaisCuidador(cuidador);
	}

	public void validaSalva(Animal animal) {
		getAnimalVal().validaSalva(animal);
	}

	public AnimalVal getAnimalVal() {
		return (AnimalVal) val;
	}

	public AnimalDAO getAnimalDAO() {
		return (AnimalDAO) bd;
	}

}
