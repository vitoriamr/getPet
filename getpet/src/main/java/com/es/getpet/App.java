package com.es.getpet;

import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.rn.AnimalRN;

public class App
{
    public static void main( String[] args )
    {
    	Animal animal = new Animal();
    	animal.setNome("Hanna");
    	animal.setSexo((short)0);
    	animal.setCastrado(false);
    	animal.setEspecie((short) 0);
    	animal.setIdade((short) 6);
    	animal.setRaca("Pitbul");
    	animal.setTamanho((short) 2);

    	AnimalRN animalRN = new AnimalRN();
    	animalRN.salva(animal);
    }
}
