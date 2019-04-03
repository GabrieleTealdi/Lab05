package it.polito.tdp.anagrammi.model;

import java.util.*;

public class Anagramma {

	private int length;
	private List<String> lettere;
	private char[] tutteLettere;
	Map<String, Integer> l;
	
	public Anagramma() {
		
	}
	
	public Anagramma(String parola) {
		super();
		this.length = parola.length();
		this.lettere = new LinkedList<String>();
		this.tutteLettere = parola.toCharArray();
		l = new HashMap<String, Integer>();
		for(char c: tutteLettere) {
			if(!l.containsKey(String.valueOf(c)))
				l.put(String.valueOf(c), 1);
			else if(l.containsKey(String.valueOf(c))) {
				int i = l.get(String.valueOf(c))+1;
				l.put(String.valueOf(c), i);
			}
		}
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void addLettera(String s) {
		lettere.add(s);
	}
	
	public String getAnagramma() {
		String s = "";
		for(String st: lettere) {
			s+=st;
		}
		return s;
	}

	@Override
	protected Anagramma clone() {
		Anagramma a = new Anagramma();
		a.setLength(this.length);
		a.lettere = new ArrayList<>(this.lettere);
		return a;
	}

	public boolean contains(String s) {
		return lettere.contains(s);
	}

	public void remove(String s) {
		lettere.remove(s);
	}

	@Override
	public String toString() {
		return this.getAnagramma();
	}
	
	public boolean controllaDoppie(String s) {
		
		/*if(l.containsKey(s)) {
			if(l.get(s)==1) {
				l.put(s, l.get(s)-1);
				return false;
			}
			if(l.get(s)==0)
				return true;
			if(l.get(s)>1) {
				l.put(s, l.get(s)-1);
				return false;
			}
		}
		return true;*/
		
		if(!lettere.contains(s) && l.get(s)>=1) {
			l.put(s, l.get(s)-1);
			return false;
		}
		if(lettere.contains(s) && l.get(s)>=1) {
			l.put(s, l.get(s)-1);
			return false;
		}
		if(lettere.contains(s) && l.get(s)==0) 
			return true;
		return true;
	}
	
	
	
}
