package com.es.getpet.core.rn;

import java.util.List;

import com.es.getpet.core.bd.AnimalDAO;
import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.util.PropriedadesLista;
import com.es.getpet.core.val.AnimalVal;

public class AnimalRN {

    private AnimalDAO bd;
    private AnimalVal val;

    public AnimalRN(AnimalDAO bd, AnimalVal val) {
        this.bd = bd;
        this.val = val;
    }

    public Animal salva(Animal ed) {
        val.validaSalva(ed);
        return bd.salva(ed);
    }

    public void remove(Animal ed) {
        val.validaRemove(ed);
        bd.remove(ed);
    }

    public void remove(List<Animal> lista) {
        val.validaRemove(lista);
        bd.remove(lista);
    }

    public void remove(int[] indices, List<Animal> lista) {
        val.validaRemove(indices, lista);
        bd.remove(indices, lista);
    }

    public Animal atualiza(Animal ed) {
        val.validaAtualiza(ed);
        return bd.atualiza(ed);
    }

    public List<Animal> lista(Animal ed, PropriedadesLista pl) {
        val.validaLista(ed);
        return bd.lista(ed, pl);
    }

    public List<Animal> busca(Animal ed, PropriedadesLista pl) {
        val.validaLista(ed);
        return bd.busca(ed, pl);
    }

    public Animal consulta(Animal ed) {
        val.validaConsulta(ed);
        return bd.consulta(ed);
    }


}
