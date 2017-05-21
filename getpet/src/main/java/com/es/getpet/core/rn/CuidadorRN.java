package com.es.getpet.core.rn;

import com.es.getpet.core.bd.CuidadorDAO;
import com.es.getpet.core.ed.Cuidador;
import com.es.getpet.core.util.RN;
import com.es.getpet.core.val.CuidadorVal;

public class CuidadorRN extends RN<Cuidador> {

	public CuidadorRN() {
		super(new CuidadorDAO(), new CuidadorVal());
	}

}