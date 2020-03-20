package it.polito.tdp.libretto.model;


import java.time.LocalDate;
/**
 * Classe voto contiene informazioni sull'esame superato
 * @author matty
 *
 */


public class Voto implements Comparable<Voto> {
	
	private String corso;
	private Integer voto;
	private LocalDate data;
	/**
	 * Costruisce un nuovo voto
	 * @param corso nome del corso superato
	 * @param voto  valore del voto acquisito
	 * @param data  data di superamento corso
	 */
	public Voto(String corso, Integer voto, LocalDate data) {
		super();
		this.corso = corso;
		this.voto = voto;
		this.data = data;
	}
	/**
	 * Copy constructor di {@link Voto} crea un nuovo {@link Voto}
	 * @param v il voto da copiare
	 */
	public Voto(Voto v) {
		this.corso = v.corso; // v.getCorso()
		this.voto = v.voto;
		this.data = v.data;
		
	}
	/*
	 * quando ho oggetti immutabili come stringhe e localdate non comportano 
	 * il problema del copiare. 
	 * i tipi primitivi comportano una copia del suo valore
	 * 
	 */
	
	public String getCorso() {
		return corso;
	}
	public void setCorso(String corso) {
		this.corso = corso;
	}
	public Integer getVoto() {
		return voto;
	}
	public void setVoto(Integer voto) {
		this.voto = voto;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return corso + ": " + voto + "(" + data + ")";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		return true;
	}
	/**
	 * Crea un clone dell'oggetto presente, come nuovo oggetto
	 */
	public Voto clone() {
		Voto v = new Voto( this.corso,this.voto,this.data);
		return v;
		
	}
	@Override
	public int compareTo(Voto other) {
		/*
		 * <0 se this è minore di other
		 * ==0 se sono uguali
		 * >0 se this è maggiore di other
		 */
		return this.corso.compareTo(other.getCorso());
	}
	
	
	
	
	
	
	
	

}
