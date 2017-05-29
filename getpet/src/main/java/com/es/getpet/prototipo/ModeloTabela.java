package com.es.getpet.prototipo;

import com.es.getpet.core.util.ED;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public abstract class ModeloTabela<E extends ED> extends AbstractTableModel {

	private static final long serialVersionUID = -4892445090875024973L;
	private List<E> lista;

    public ModeloTabela() {}

    public ModeloTabela(List<E> lista) {
        this.lista = lista;
    }

    public void setLista(List<E> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        if (lista == null)
            return 0;
        else
            return lista.size();
    }

    public E get(int linha) {
        if (linha < 0 || lista == null || lista.isEmpty()) {
            return null;
        } else {
            return lista.get(linha);
        }
    }

    public void set(int linha, E e) {
        lista.set(linha, e);
    }

    public abstract int getRowIndex();

}