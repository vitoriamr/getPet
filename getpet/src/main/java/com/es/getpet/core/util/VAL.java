package com.es.getpet.core.util;

import java.util.List;

public class VAL<E extends ED> {

    public void validaLista(E ed) {
        if (ed == null) {
            throw new IllegalArgumentException("O objeto não pode ser nulo.");
        }
    }

    public void validaBusca(E ed) {
        if (ed == null) {
            throw new IllegalArgumentException("O objeto não pode ser nulo.");
        }
    }

    public void validaConsulta(E ed) {
        if (ed == null) {
            throw new IllegalArgumentException("O objeto não pode ser nulo.");
        }
    }

    public void validaSalva(E ed){
        if (ed == null) {
            throw new IllegalArgumentException("O objeto não pode ser nulo.");
        }
    }

    public void validaRemove(E ed) {
        if (ed == null) {
            throw new IllegalArgumentException("O objeto não pode ser nulo.");
        }
    }

    public void validaRemove(List<E> lista) {
        if (lista == null) {
            throw new IllegalArgumentException("A lista não pode ser nulo.");
        } else if (lista.isEmpty()) {
            throw new IllegalArgumentException("A lista de objetos não pode ser vazia.");
        }
    }

    public void validaRemove(int[] indices, List<E> lista) {
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

    public void validaAtualiza(E ed) {
        if (ed == null) {
            throw new IllegalArgumentException("O objeto não pode ser nulo.");
        }
    }


}
