package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Parole {
		
	private List<String> parole;
	
	public Parole() {
		this.parole= new ArrayList<>() ;
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

}
