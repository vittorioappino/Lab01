package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.parole.model.Parole.OrdinaParole;

public class ParoleLinkedList {
	
	private List<String> parole;
	
	public ParoleLinkedList() {
		this.parole= new LinkedList<>() ;
	}
	
	public void addParola(String p) {
		if(p.matches("((?=.*\\d).{0,})")||p.matches("((?=.*[!?@#]).{0,})")) {
		}else if(p.isEmpty()){
		}else {
			this.parole.add(p);
		}
	}
	
	public class OrdinaParole implements Comparator<String>{
		public int compare (String s1, String s2) {
			return s1.compareTo(s2);
		}
	}
	public List<String> getElenco() {
		Collections.sort(parole, new OrdinaParole());
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}
	
	public String toString() {
		String s = "" ;
		List<String>lista = getElenco();
		for(String v: lista) {
			s = s + v.toString() + "\n" ;
		}
		return s ;
	}

	public void Cancella(String parola) {
		List<String>lista=new LinkedList<String>();
		for(String s: this.parole) {
			if(!s.equals(parola)) {
				lista.add(s);
			}
		}
		this.parole=lista;
	}

}
