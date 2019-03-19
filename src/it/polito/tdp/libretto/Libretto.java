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
	 * @return {@code true} nel caso normale, {@code false}nel caso non sia riuscito ad aggiungere il voto.
	 */
		
	public boolean add(Voto v) {
		if(!this.esisteGiaVoto(v) && !this.votoConflitto(v)) {
		   voti.add(v);
		   return true;
		}
		else {
			return false;
		}
		
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
		Voto voto = new Voto(0, nomeEsame, null); //costruisco un oggetto voto(falsato) solo per avere un criterio di ricerca.
		int pos = this.voti.indexOf(voto);
		if(pos==-1)
			return null;
		else 
			return this.voti.get(pos);
	}
	/*
	 * data un voto {@link Voto}, determina se esiste già un voto con uguale
	 * corso ed punteggio.
	 * @param v
	 * @return{@code true}, se ha trovato un corso e punteggio uguali
	 *        {@code false}, se non ha trovato il corso, oppure {@code null} se non esiste 
	 */
	public boolean esisteGiaVoto(Voto v) {
		int pos = this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else 
			return (v.getPunti()==this.voti.get(pos).getPunti());
				
		
	}	
	/*
	 * Mi dice se il {@link Voto} {@code v} è in conflitto con uno dei voti esistenti. 
	 * Se il voto è in conflitto restituisce true
	 * se non lo è false
	 */
	
	public boolean votoConflitto(Voto v) {
		int pos = this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else 
			return (v.getPunti()!=this.voti.get(pos).getPunti());
				
		
	}
	
	
	
}

	

