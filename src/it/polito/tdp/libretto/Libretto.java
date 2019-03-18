package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti ;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>() ;
	}
	
	/* Aggiunge un nuovo voto al libretto
	 * 
	 * @param v il {@link Voto} da aggiungere
	 */
		
	public void add(Voto v) {
		voti.add(v);
		
	}
	/* Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * 
	 * @param punti punteggio da ricerca
	 * @return lista di{@link voto} aventi quel punteggio 
	 */
	
	
	public List<Voto> cercaVoti(int punti){
		List<Voto> result = new ArrayList<Voto>();
		
		for(Voto v : this.voti) {
			if(v.getPunti() == punti)
				result.add(v);
		}
		return result;
		
	}
	/*
	 * Ricerca un {@link Voto} corrispondente, oppure null se non trovato
	 */
	
	public Voto cercaEsame(String nomeEsame) {
		for(Voto v : this.voti)
			if(v.getCorso().equals(nomeEsame))
				return v;
		return null;
	}

	
}
