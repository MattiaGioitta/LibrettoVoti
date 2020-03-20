package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Memorizza e gestisce un insieme di voti superati.
 * 
 * @author Fulvio
 *
 */
public class Libretto {

	private List<Voto> voti= new ArrayList<>();
	/**
	 * Crea un nuovo {@link Libretto} vuoto
	 */
	public Libretto() {
		super();
	}
	
	/**
	 * Copy Constructor
	 * "Shallow" copia superficiale
	 * 
	 * "Deep" copia profonda
	 */
	public Libretto(Libretto lib) {
		super();
		this.voti.addAll(lib.voti);
		
	}
	
	
	/**
	 * Aggiunge un nuovo voto al parametro libretto
	 * @param v voto da aggiungere
	 * @return {@code true} se lo inserisce, {@code false} se non lo inserisce perchè in conflitto o duplicato
	 */
	public boolean add(Voto v) {
		if(this.isConflitto(v) || this.isDuplicato(v)) {
			//non inserisci il voto
			return false;// segnalo al chiamante che non ha avuto successo
		}
		else {
		    this.voti.add(v);
		    return true;
		}
	}
	/**
	 * Stampa gli esami passati il cui voto e' uguale a quello passato
	 * @param voto voto degli esami che si vogliono stampare
	 * @return elenco di esami con il voto passato
	 */
	
	public String stampaVotiUguali(int voto) {
		String s="";
		for(Voto v: this.voti) {
			if(v.getVoto()==voto) {
			  s+=v.toString()+"\n";
			  }
			}
		return s;
	}
	/**
	 * Genera un nuovo libretto a partire da quello presente che conterra' solo i voti uguali 
	 * alla votazione di quella specificata
	 * @param voto corsi con i voti pari a questo
	 * @return libretto nuovo "ridotto" 
	 */
	
	public Libretto estraiVotiUguali(int voto) {
		Libretto libretto = new Libretto();
		for(Voto v: this.voti) {
			if(v.getVoto()==voto) {
				libretto.add(v);
			}
			
		}
		return libretto;
		
	}
	
	
	public String toString() {
		String s="";
		for(Voto v: this.voti)
			s+=v.toString()+"\n";
		return s;
	}
	/**
	 * Dato il nome di un corso
	 * cerca se quell'esame esiste e in caso affermativo
	 * restiutirà l'oggetto {@link Voto} corrispondente.
	 * Se l'esame non esiste restituisce null
	 * @param nomeCorso il nome dell'esame da cercare
	 * @return {@link Voto} corrispondente oppure {@code null} se non esiste
	 */
	public Voto cercaNomeCorso(String nomeCorso) {
		int pos=this.voti.indexOf(new Voto(nomeCorso, 0, null));
		if(pos!= -1)
			return this.voti.get(pos);
		else
			return null;
	}
	/**
	 * Ritorna {@code true} se il corso specificato da {@code v} esiste nel libretto, con la 
	 * stessa valutazione.
	 * Se non esiste o la valutazione è diversa ritorna false
	 * @param v {@link Voto} da cercare
	 * @return l'esistenza di un duplicato
	 */
	public boolean isDuplicato(Voto v) {
		Voto esiste= this.cercaNomeCorso(v.getCorso());
		if(esiste==null) {
			return false;
		}
		/*if(esiste.getVoto()==v.getVoto()) {
			return true;
		}
		else {
			return false;
		}*/
		return (esiste.getVoto()==v.getVoto());
		
	}
	/**
	 * Determina se esiste un {@link Voto} con valutazione diversa
	 * @param v
	 * @return
	 */
	public boolean isConflitto(Voto v) {
		Voto esiste= this.cercaNomeCorso(v.getCorso());
		if(esiste==null) {
			return false;
		}
		return (esiste.getVoto()!=v.getVoto());
		
	}

	/**
	 * Restituisce un nuovo libretto migliorando 
	 * i voti del libretto attuale
	 * @return
	 */
	public Libretto creaLibrettoMigliorato() {
		Libretto nuovo = new Libretto();
		for(Voto v : this.voti) {
			//Voto v2 = new Voto(v);// problema perchè punto all'oggetto quindi cambio i dati dell'oggetto a cui si punta
			Voto v2= v.clone();
			if(v2.getVoto()>=24) {
				v2.setVoto(v2.getVoto()+2);
				if(v2.getVoto()>30) {
					v2.setVoto(30);
				}
			}
			else if(v2.getVoto()>18) {
				v2.setVoto(v2.getVoto()+1);
			}
			nuovo.add(v2);
		}
		return nuovo;
	}
	/**
	 * riordina un libretto per ordine alfabetico dei corsi
	 * @param lib
	 */
	public void ordinaPerCorso() {
		Collections.sort(this.voti);		
	}
	
	public void ordinaPerVoto() {
		Collections.sort(this.voti, new CoomparatorePerVoti());		
	}
	/**
	 * Elimina dal libretto tutti i voti inferiori a 24
	 */
	public void cancellaVotiScarsi() {
		List<Voto> daTogliere= new ArrayList<Voto>();
		for(Voto v : this.voti) {
			if(v.getVoto()<24) {
				daTogliere.add(v);
			}
		}
		/*for(Voto v : daTogliere) {
			this.voti.remove(v);
		}*/
		this.voti.removeAll(daTogliere);
	}

	
	
	


}
