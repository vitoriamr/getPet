package com.es.getpet;

import com.es.getpet.core.bd.AnimalDAO;
import com.es.getpet.core.ed.Animal;

public class App
{
    public static void main( String[] args )
    {
    	Animal animal = new Animal();
    	animal.setNome("Belinha");
    	animal.setSexo((short)0);
    	animal.setCastrado(false);
    	animal.setEspecie((short) 0);
    	animal.setIdade((short) 0);
    	animal.setRaca("Poodle");

    	AnimalDAO animalDAO = new AnimalDAO();
    	animalDAO.salva(animal);

    }
}
