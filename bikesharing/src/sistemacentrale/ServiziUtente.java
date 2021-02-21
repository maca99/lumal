import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import stazione.Stazione;

public class ServiziUtente /* implements *****/  {

    private ServiziUtente istance;
    private Prenotazione prenotazione;
    private Corsa corsa;
    private Abbonamento abbonamento;
    private Utente utente;
    private GestoreStazioni stazioni;
    private Integer Strike;

    public ServiziUtente(Utente utente) {
        this.setUtente(utente);
        prenotazione=null;
        corsa=null;
        stazioni=GestoreStazioni.getIstance();
        //facciamo finta che venga preso da un DB
        abbonamento = new Abbonamento();
    }

    private boolean verificaAbbonamento() {
        return false;

    }

    private boolean iniziaCorsa(String stazione) {
        if(corsa != null) return false;

        if(prenotazione != null) {

        }
        return false;


    }

    public boolean prenotazione(String stazione) {
        if(prenotazione != null)return false;
        prenotazione = new Prenotazione();
        prenotazione.setStazione(stazione);
        stazioni.prenotazione(prenotazione);
        return true;
    }
    
    public List<Stazione> getAllStazioni(){
    	return new LinkedList(stazioni.getStazioni());
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }


}