package com.mercury.model.dao;

import java.util.ArrayList;

import com.mercury.model.Evento;

public interface EnteUtil {
	public void inserisciEvento (Evento e);
	public void modificaEvento (Evento e);
	public ArrayList <Evento> getEventiByEnte (String nomeEnte);

}
