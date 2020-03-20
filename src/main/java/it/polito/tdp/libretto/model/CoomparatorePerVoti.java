package it.polito.tdp.libretto.model;

import java.util.Comparator;

class CoomparatorePerVoti implements Comparator<Voto> {

	@Override
	public int compare(Voto o1, Voto o2) {
		// TODO Auto-generated method stub
		return o2.getVoto()-o1.getVoto();
	}

}
