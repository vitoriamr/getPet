package com.es.getpet.core.val;

import java.util.List;

import com.es.getpet.core.ed.Animal;

public class AnimalVal {

    public void validaLista(Animal ed) {
        if (ed == null) {
            throw new IllegalArgumentException("O objeto não pode ser nulo.");
        }
    }

    public void validaBusca(Animal ed) {
        if (ed == null) {
            throw new IllegalArgumentException("O objeto não pode ser nulo.");
        }
    }

    public void validaConsulta(Animal ed) {
        if (ed == null) {
            throw new IllegalArgumentException("O objeto não pode ser nulo.");
        }
    }

    public void validaSalva(Animal ed){
        if (ed == null) {
            throw new IllegalArgumentException("O objeto não pode ser nulo.");
        }
    }

    public void validaRemove(Animal ed) {
        if (ed == null) {
            throw new IllegalArgumentException("O objeto não pode ser nulo.");
        }
    }

    public void validaRemove(List<Animal> lista) {
        if (lista == null) {
            throw new IllegalArgumentException("A lista não pode ser nulo.");
        } else if (lista.isEmpty()) {
            throw new IllegalArgumentException("A lista de objetos não pode ser vazia.");
        }
    }

    public void validaRemove(int[] indices, List<Animal> lista) {
        if (indices == null) {
            throw new IllegalArgumentException("Os indices não podem ser nulo.");
        } else if (lista == null) {
            throw new IllegalArgumentException("A lista de objetos não pode ser nula.");
        } else if (indices.length == 0) {
            throw new IllegalArgumentException("Os indices não podem ser vazios.");
        } else if (lista.isEmpty()) {
            throw new IllegalArgumentException("A lista de objetos não pode ser vazia.");
        }
    }

    public void validaAtualiza(Animal ed) {
        if (ed == null) {
            throw new IllegalArgumentException("O objeto não pode ser nulo.");
        }
    }


}
