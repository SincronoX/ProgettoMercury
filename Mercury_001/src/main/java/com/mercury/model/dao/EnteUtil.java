package com.mercury.model.dao;

import java.util.ArrayList;

import com.mercury.model.Ente;
import com.mercury.model.EventoPrevisto;

public interface EnteUtil {
	public void inserisciEvento (EventoPrevisto e);
	public void modificaEvento (EventoPrevisto e);
	public ArrayList <EventoPrevisto> getEventiByEnte (String nomeEnte);
	public void addEnte (Ente en);
	public boolean trovaEnte (Ente en);
	public void eliminaEvento(EventoPrevisto e);
	public Ente getEnteById(int id);
	public ArrayList<Ente> getEntiInAttesa();
	public boolean controlloLoginEnte (String email, String psw);
	public Ente getEnteByEmail(String email);

}
