package com.es.getpet.core.rn;

import com.es.getpet.core.bd.AnimalDAO;
import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.util.RN;
import com.es.getpet.core.val.AnimalVal;

public class AnimalRN extends RN<Animal> {

	public AnimalRN() {
		super(new AnimalDAO(), new AnimalVal());
	}

}
