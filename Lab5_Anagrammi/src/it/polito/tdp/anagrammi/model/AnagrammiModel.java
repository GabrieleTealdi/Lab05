package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.ParolaDAO;

public class AnagrammiModel {
	
	private List<Anagramma> soluzioni;
	private char [] elencoLettere;
	
	public List<Anagramma> cerca(String parola){
		Anagramma parziale = new Anagramma(parola);
		elencoLettere = parola.toCharArray();
		soluzioni = new ArrayList<Anagramma>();
		this.generaAnagrammi(parziale, 0);
		return soluzioni;
	}
	
	private void generaAnagrammi(Anagramma parziale, int L) {
		if(L==parziale.getLength()) {
			if (!soluzioni.contains(parziale) && !this.controllaCopioni(parziale)) {
				//System.out.println(parziale);
				soluzioni.add(parziale.clone());
			}
			return;
		}
		
		for(char c: elencoLettere) {
			if(!parziale.controllaDoppie(String.valueOf(c))) {
				parziale.addLettera(String.valueOf(c));
				generaAnagrammi(parziale, L+1);
				parziale.remove(String.valueOf(c));
			}
		}
		
	}
	
	public List<Anagramma> cercaSolCorrette(List<Anagramma> soluzioni){
		ParolaDAO dao = new ParolaDAO();
		List<Anagramma> soluzioniEsatte = new ArrayList<Anagramma>(dao.controllaParoleEsatte(soluzioni));
		return soluzioniEsatte;
	}

	public boolean controllaCopioni(Anagramma parziale) {
		for(Anagramma a: soluzioni) {
			if(a.toString().equals(parziale.toString()))
				return true;
		}
		return false;
		
	}
}
