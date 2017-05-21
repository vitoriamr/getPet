package com.es.getpet.core.rn;

import com.es.getpet.core.bd.AdotanteDAO;
import com.es.getpet.core.ed.Adotante;
import com.es.getpet.core.util.RN;
import com.es.getpet.core.val.AdotanteVal;

public class AdotanteRN extends RN<Adotante> {

	public AdotanteRN() {
		super(new AdotanteDAO(), new AdotanteVal());
	}

}