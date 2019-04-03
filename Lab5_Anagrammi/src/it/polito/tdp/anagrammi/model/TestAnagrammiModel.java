package it.polito.tdp.anagrammi.model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestAnagrammiModel {
	public static void main(String[] args) {

		AnagrammiModel am = new AnagrammiModel() ;
		
		String s = "canne";
		char[] arr = s.toCharArray();
		System.out.println(arr) ;
		Map <String,Integer> l = new HashMap<String, Integer>();
		for(char c: arr) {
			if(!l.containsKey(String.valueOf(c)))
				l.put(String.valueOf(c), 0);
			else if(l.containsKey(String.valueOf(c))) {
				int i = l.get(String.valueOf(c))+1;
				l.put(String.valueOf(c), i);
			}
		}
		//l.put("n", l.get("n")-1);
		for(String st: l.keySet()) {
			System.out.println(st);
			System.out.println(l.get(st));
		}
	}
}
	
