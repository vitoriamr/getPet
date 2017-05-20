package com.es.getpet.core.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felipe
 * @param <Ordem>
 */
public class PropriedadesLista {

    private List<Ordem> listaOrdenacao;
    private int primeiro;
    private int quantidade;

    public PropriedadesLista() {
        this(10);
    }

    public PropriedadesLista(int tamListaOrdenacao) {
        listaOrdenacao = new ArrayList<>(tamListaOrdenacao);
    }

    public void addOrdem(Ordem ordem) {
        listaOrdenacao.add(ordem);
    }

    public List<Ordem> getOrdenacao() {
        return listaOrdenacao;
    }

    public boolean isEmpty() {
        return listaOrdenacao.isEmpty();
    }

    public int getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(int primeiro) {
        this.primeiro = primeiro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}