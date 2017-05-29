package com.es.getpet;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.rn.AnimalRN;
import com.es.getpet.core.util.PropriedadesLista;

@RestController
public class AnimalController {

	@RequestMapping("/api/animais")
	public List<Animal> get() {
		AnimalRN rn = new AnimalRN();
		Animal animal = new Animal();
		PropriedadesLista pl = new PropriedadesLista();
		List<Animal> listaDeAnimais = rn.lista(animal, pl);
		
		System.out.println(listaDeAnimais);
		
		return listaDeAnimais;
	}
}
