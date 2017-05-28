package com.es.getpet;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.es.getpet.core.ed.Adotante;
import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.ed.Cuidador;
import com.es.getpet.core.enuns.Especie;
import com.es.getpet.core.enuns.Sexo;
import com.es.getpet.core.enuns.Tamanho;
import com.es.getpet.core.rn.AdotanteRN;
import com.es.getpet.core.rn.AnimalRN;
import com.es.getpet.core.rn.CuidadorRN;
import com.es.getpet.core.util.HibernateUtil;

@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);

    	Animal animal = new Animal();
    	animal.setNome("Hanna");
    	animal.setSexo(Sexo.FEMEA);
    	animal.setCastrado(false);
    	animal.setEspecie(Especie.CAO);
    	animal.setIdade((short) 6);
    	animal.setRaca("Pitbul");
    	animal.setTamanho(Tamanho.MEDIO);

    	AnimalRN animalRN = new AnimalRN();
    	animalRN.salva(animal);

    	Animal animal1 = new Animal();
    	animal1.setNome("Han");
    	List<Animal> lista = animalRN.busca(animal1, null);

    	for (Animal a : lista) {
    		System.out.println(a.getNome()+ " " + a.getEspecie());
    	}

    	Animal animal2 = new Animal();
    	animal2.setId(1l);

    	Animal animal3 = animalRN.consulta(animal2);

    	System.out.println(animal3.getNome());
///////////////////////////////////////////////////////////////////////

    	Cuidador cuidador = new Cuidador();
    	cuidador.setNome("João da Silva");
    	cuidador.setEndereco("Av: Plinio Brasil Milano, 256 Auxiliadora Porto Alegre");
    	cuidador.setLoginName("joaosilva");
    	cuidador.setSenha("joao");
    	List<Animal> listaAnimais = new ArrayList<>();
    	listaAnimais.add(animal);

    	cuidador.setListaAnimais(listaAnimais);

    	CuidadorRN cuidadorRN = new CuidadorRN();
    	cuidadorRN.salva(cuidador);

    	Cuidador cuidador1 = new Cuidador();
    	cuidador1.setNome("Jo");
    	List<Cuidador> listaCuidador = cuidadorRN.busca(cuidador1, null);

    	for (Cuidador a : listaCuidador) {
    		System.out.println(a.getNome());
    	}

    	Cuidador cuidador2 = new Cuidador();
    	cuidador2.setId(1l);

    	Cuidador cuidador3 = cuidadorRN.consulta(cuidador2);

    	System.out.println(cuidador3.getNome());

    	listaCuidador = cuidadorRN.lista(cuidador1, null);

    	for (Cuidador a : listaCuidador) {
    		System.out.println(a.getNome());
    	}


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

    	Adotante adotante1 = new Adotante();
    	adotante1.setNome("am");
    	List<Adotante> listaAdotante = adotanteRN.busca(adotante1, null);

    	for (Adotante a : listaAdotante) {
    		System.out.println(a.getNome());
    	}

    	Adotante adotante2 = new Adotante();
    	adotante2.setId(1l);

    	Adotante adotante3 = adotanteRN.consulta(adotante2);

    	System.out.println(adotante3.getNome());

    	listaAdotante = adotanteRN.lista(adotante1, null);

    	for (Adotante a : listaAdotante) {
    		System.out.println(a.getNome());
    	}

    	HibernateUtil.fechaSessao();


    }
}
