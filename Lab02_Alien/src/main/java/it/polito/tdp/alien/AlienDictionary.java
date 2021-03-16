package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AlienDictionary {
	
	ArrayList<Word> parole ;
	private Map<String, Word> paroleMap;
	
	public AlienDictionary() {
		this.parole = new ArrayList<>();
		this.paroleMap = new HashMap<>();
	}
	
	public void addWord(String alienWord, String translation) {
		Word w = new Word(alienWord, translation);
		if(esisteDuplicato(w) == true) {
			ricercaParola(w.getAlienWord()).setTranslation(translation);
		}else {
			this.parole.add(w);
			this.paroleMap.put(w.getAlienWord(), w);
		}
	}
	
	public Word ricercaParola(String alienWord){
		return this.paroleMap.get(alienWord);
	}
	
	public boolean esisteDuplicato(Word w) {
		Word trovato = this.paroleMap.get(w.getAlienWord());
		if(trovato == null) {
			return false;
		}
		if(trovato.getAlienWord() == w.getAlienWord()) {
		return true;
		}
		else {
			return false;
		}
	}
	
	public String translateWord(String alienWord) {
		if(ricercaParola(alienWord).toString().equals(null)) {
			return null;
		}
		return ricercaParola(alienWord).toString();
	}
	

}
