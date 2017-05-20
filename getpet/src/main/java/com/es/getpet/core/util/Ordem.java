package com.es.getpet.core.util;

public final class Ordem {

    private String campo;
    private TipoOrdem tipoOrdem;

    public Ordem() {
    }

    public Ordem(String campo) {
        this(campo, TipoOrdem.Ascendente);
    }

    public Ordem(String campo, TipoOrdem tipoOrdem) {
        setCampo(campo);
        setTipoOrdem(tipoOrdem);
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public TipoOrdem getTipoOrdem() {
        return tipoOrdem;
    }

    public boolean isCrescente() {
        return tipoOrdem == TipoOrdem.Ascendente;
    }

    public void setTipoOrdem(TipoOrdem tipoOrdem) {
        this.tipoOrdem = tipoOrdem;
    }

}