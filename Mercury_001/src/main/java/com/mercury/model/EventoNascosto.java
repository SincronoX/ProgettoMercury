// Fabio Savelli

package com.mercury.model;

import java.util.Calendar;

public class EventoNascosto {
	private int idEvento;
	private int idTipoEvento;
	private int idEnte;	
	private String idComune;
	private String nomeEvento;
	private String descEvento;
	private Calendar dataInizio; 
	private Calendar dataFine;
	private boolean check;

	
	public EventoNascosto() {
		super();
	}

	public int getIdEnte() {
		return idEnte;
	}
	public void setIdEnte(int idEnte) {
		this.idEnte = idEnte;
	}
	public String getIdComune() {
		return idComune;
	}
	public void setIdComune(String idComune) {
		this.idComune = idComune;
	}
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public String getDescEvento() {
		return descEvento;
	}
	public void setDescEvento(String descEvento) {
		this.descEvento = descEvento;
	}
	public int getIdTipoEvento() {
		return idTipoEvento;
	}
	public void setIdTipoEvento(int idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}
	public Calendar getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Calendar dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Calendar getDataFine() {
		return dataFine;
	}
	public void setDataFine(Calendar dataFine) {
		this.dataFine = dataFine;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	
}
