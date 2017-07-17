package com.es.getpet.prototipo;

import com.es.getpet.core.ed.Adocao;
import java.util.List;

public class AdocoesModeloTabela extends ModeloTabela<Adocao>{

    private static final long serialVersionUID = 1L;
    public static final int COL_NOME_CANDIDATO = 0;
    public static final int COL_NOME_ANIMAL = 1;
    public static final int COL_ID = 2;

    public AdocoesModeloTabela(List<Adocao> listaAdocoes) {
        super(listaAdocoes);
    }

    @Override
    public String getColumnName(int coluna) {
        String result;
        switch (coluna) {
            case COL_NOME_CANDIDATO:
                result = "Nome Candidato";
                break;
            case COL_NOME_ANIMAL:
                result = "Animal";
                break;
            case COL_ID:
                result = "ID";
                break;
            default:
                throw new IndexOutOfBoundsException("Coluna fora do intervalo");
        }
        return result;
    }
    @Override
    public int getRowIndex() {
        return COL_ID;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Adocao adocao = get(linha);
        Object result;
        switch (coluna) {
            case COL_NOME_CANDIDATO:
                result = adocao.getAdotante().getNome();
                break;
            case COL_NOME_ANIMAL:
                result = adocao.getAnimal().getNome();
                break;
            default:
                throw new IndexOutOfBoundsException("Coluna inválida");
        }
        return result;
    }

    @Override
    public  Class<?> getColumnClass(int coluna) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        return false;
    }

}