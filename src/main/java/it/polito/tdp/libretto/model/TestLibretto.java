package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	
	Libretto lib;
	
	private void run() {
		lib = new Libretto();
		//1. Inserire voti
		Voto v1= new Voto("Tecniche di programmazione",30, LocalDate.of(2020,06,15));
		Voto v2= new Voto("Analisi II",28, LocalDate.of(2020,06,28));
		lib.add(v1);
		lib.add(v2);
		if(lib.add(new Voto("Economia",24,LocalDate.of(2020,01,24)))==false)
			System.out.println("Errore nell'inserimento di Economia");
		
		System.out.println(this.lib);
		
		System.out.println(this.lib.stampaVotiUguali(28));
		
		System.out.println(this.lib.estraiVotiUguali(28));
		//3. Cerca un esame conoscendo il nome del corso
		String nomeCorso= "Analisi II";
		Voto votoAnalisi = lib.cercaNomeCorso(nomeCorso);
		System.out.println("il voto di "+nomeCorso+" è "+votoAnalisi.getVoto());
		Voto votoMancante = lib.cercaNomeCorso("Fisica I");
		System.out.println("il voto di Fisica I"+" è "+votoMancante);
		
		//4. e 5. Cerca o verifica voti duplicati o in conflitto
		Voto economia2= new Voto("Economia",24,LocalDate.now());
		Voto economia3= new Voto("Economia",21,LocalDate.now());
		System.out.println("Economia con 24 è duplicato: /"+lib.isDuplicato(economia2)+
				"conflitto:"+lib.isConflitto(economia2));
		System.out.println("Economia con 21 è duplicato: /"+lib.isDuplicato(economia3)+
				"conflitto:"+lib.isConflitto(economia3));
		
		
		//6. Migliora il libretto
		Libretto migliorato = lib.creaLibrettoMigliorato();
		System.out.println("Miglioramento del libretto");
		System.out.println(lib);
		System.out.println(migliorato);
		//7.
		Libretto alfabetico = new Libretto(lib);
		alfabetico.ordinaPerCorso();
		System.out.println(alfabetico);
		
		Libretto votiDecrescenti = new Libretto(lib);
	    votiDecrescenti.ordinaPerVoto();
		System.out.println(votiDecrescenti);
		
		//8. Elimina voti inferiori a 24
		lib.add(new Voto("Chimica", 19, LocalDate.now()));
		lib.ordinaPerCorso();
		System.out.println(lib);
		lib.cancellaVotiScarsi();
		System.out.println(lib);
		
		
		
	}

	public static void main(String[] args) {
		TestLibretto test= new TestLibretto();
		test.run();
		//Non si lavora dentro il main
		
	}

}
