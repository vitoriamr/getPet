package com.modelos;

public class Adotante extends Usuarios {
	private Boolean jaAdotouAntes;
	private Boolean jaPossuiAnimais;
	private int qtdAnimais;
	
	public Boolean getJaAdotouAntes() {
		return jaAdotouAntes;
	}
	public void setJaAdotouAntes(Boolean jaAdotouAntes) {
		this.jaAdotouAntes = jaAdotouAntes;
	}
	public Boolean getJaPossuiAnimais() {
		return jaPossuiAnimais;
	}
	public void setJaPossuiAnimais(Boolean jaPossuiAnimais) {
		this.jaPossuiAnimais = jaPossuiAnimais;
	}
	public int getQtdAnimais() {
		return qtdAnimais;
	}
	public void setQtdAnimais(int qtdAnimais) {
		this.qtdAnimais = qtdAnimais;
	}	
}
