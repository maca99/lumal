package sistemacentrale;

import stazione.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GestoreStazioni {

	// mappa per mantenere lo stato delle prenotazioni
	private Map<Stazione, Integer> statoStazioni;
	// mappa che associa i nomi alle relative stazioni
	private Map<String, Stazione> cercaStazioni;

	// serve per tenere traccia degli utenti che iniziano una nuova corsa prenotata
	private List<Prenotazione> prenotazioni;
	// liste delle corse in corso
	private List<Corsa> corse;
	private static GestoreStazioni instance = new GestoreStazioni();
	
	private GestoreStazioni() {
		// metodo che prende in input le stazioni
<<<<<<< HEAD
=======
		Stazione stazione1 = new Stazione("San Donato", 15);
		Stazione stazione2 = new Stazione("Porta Nuova", 20);
		Stazione stazione3 = new Stazione("Via Roma", 0);
>>>>>>> refs/remotes/origin/main
		statoStazioni = new HashMap<Stazione, Integer>();
		cercaStazioni = new HashMap<String, Stazione>();
<<<<<<< HEAD
		prenotazioni = new LinkedList<Prenotazione>();
=======
		prenotazioni = new LinkedList();
		statoStazioni.put(stazione1, 7);
		cercaStazioni.put(stazione1.getName(), stazione1);
		statoStazioni.put(stazione2, 7);
		cercaStazioni.put(stazione2.getName(), stazione2);
		statoStazioni.put(stazione3, 7);
		cercaStazioni.put(stazione3.getName(), stazione3);
>>>>>>> refs/remotes/origin/main
		corse = new LinkedList<Corsa>();
		prenotazioni = new LinkedList<Prenotazione>();
	}

	/**
	 * 
	 * @param prenotazione
	 */
	public boolean prenotazione(Prenotazione prenotazione) {
		/*
		 * gli viene passata una prenotazione e riserva un posto in una stazione
		 * all'utente della prenotazione
		 */
		Stazione stazione = cercaStazioni.get(prenotazione.getStazione());
		int libere = statoStazioni.get(stazione);
		if (libere > 0) {
			statoStazioni.replace(stazione, libere - 1);
			prenotazioni.add(prenotazione);
			return true;
		}
		return false;
	}

	public boolean cancellaPrenotazione(Prenotazione prenotazione) {

		if (prenotazioni.remove(prenotazione)) {
			Stazione stazione = cercaStazioni.get(prenotazione.getStazione());
			int libere = statoStazioni.get(stazione);
			statoStazioni.replace(stazione, libere + 1);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param corsa
	 */

	public Map<Stazione, Integer> getStatoStazioni() {
		return statoStazioni;
	}

	public List<Stazione> getStazioni() {
		return new LinkedList<Stazione>(cercaStazioni.values());
	}
	
	public static GestoreStazioni getInstance() {
		return instance;
	}

}