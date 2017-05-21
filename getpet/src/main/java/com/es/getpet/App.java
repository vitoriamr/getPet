package com.es.getpet;

import com.es.getpet.core.ed.Adotante;
import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.ed.Cuidador;
import com.es.getpet.core.rn.AdotanteRN;
import com.es.getpet.core.rn.AnimalRN;
import com.es.getpet.core.rn.CuidadorRN;

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

///////////////////////////////////////////////////////////////////////

    	Cuidador cuidador = new Cuidador();
    	cuidador.setNome("João da Silva");
    	cuidador.setEndereco("Av: Plinio Brasil Milano, 256 Auxiliadora Porto Alegre");
    	cuidador.setLoginName("joaosilva");
    	cuidador.setSenha("joao");

    	CuidadorRN cuidadorRN = new CuidadorRN();
    	cuidadorRN.salva(cuidador);

///////////////////////////////////////////////////////////////////////

    	Adotante adotante = new Adotante();
    	adotante.setNome("Camila Dorneles");
    	adotante.setEndereco("Rua Mario Totta, 588");
    	adotante.setLoginName("camiladorneles");
    	adotante.setJaAdotou(true);
    	adotante.setQteAnimais(0);
    	adotante.setSenha("camila");

    	AdotanteRN adotanteRN = new AdotanteRN();
    	adotanteRN.salva(adotante);

    }
}
