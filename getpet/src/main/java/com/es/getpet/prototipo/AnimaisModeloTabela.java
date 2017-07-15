package com.es.getpet.prototipo;

import com.es.getpet.core.ed.Animal;
import java.util.List;

public class AnimaisModeloTabela extends ModeloTabela<Animal> {

    private static final long serialVersionUID = 1L;
    public static final int COL_NOME = 0;
    public static final int COL_ESPECIE = 1;
    public static final int COL_SEXO = 2;
    public static final int COL_RACA = 3;
    public static final int COL_ID = 4;

    public AnimaisModeloTabela(List<Animal> listaAnimais) {
        super(listaAnimais);
    }

    @Override
    public String getColumnName(int coluna) {
        String result;
        switch (coluna) {
            case COL_NOME:
                result = "Nome";
                break;
            case COL_ESPECIE:
                result = "Espécie";
                break;
            case COL_SEXO:
                result = "Sexo";
                break;
            case COL_RACA:
                result = "Raça";
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
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Animal animal = get(linha);
        Object result;
        switch (coluna) {
            case COL_NOME:
                result = animal.getNome();
                break;
            case COL_ESPECIE:
                result = animal.getEspecie();
                break;
            case COL_SEXO:
                result = animal.getSexo();
                break;
            case COL_RACA:
                result = animal.getRaca();
                break;
            case COL_ID:
                result = animal.getId();
                break;
            default:
                throw new java.lang.IndexOutOfBoundsException("Coluna fora do intervalo");
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
