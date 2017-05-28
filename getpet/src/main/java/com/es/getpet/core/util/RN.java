package com.es.getpet.core.util;

import java.util.List;

public class RN<E extends ED> {

	protected DAO<E> bd;
	protected VAL<E> val;

	public RN(DAO<E> bd, VAL<E> val) {
		this.bd = bd;
		this.val = val;
	}

    public E salva(E ed) {
        val.validaSalva(ed);
        return bd.salva(ed);
    }

    public void remove(E ed) {
        val.validaRemove(ed);
        bd.remove(ed);
    }

    public void remove(List<E> lista) {
        val.validaRemove(lista);
        bd.remove(lista);
    }

    public E atualiza(E ed) {
        val.validaAtualiza(ed);
        return bd.atualiza(ed);
    }

    public List<E> lista(E ed, PropriedadesLista pl) {
        val.validaLista(ed);
        return bd.lista(ed, pl);
    }

    public List<E> busca(E ed, PropriedadesLista pl) {
        val.validaLista(ed);
        return bd.busca(ed, pl);
    }

    public E consulta(E ed) {
        val.validaConsulta(ed);
        return bd.consulta(ed);
    }

    public final void finaliza() {
    	HibernateUtil.fechaSessao();
    }

}
