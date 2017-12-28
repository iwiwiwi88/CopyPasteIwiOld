package model;

import java.util.LinkedList;
import java.util.List;

public class SectionTab {

	private String name;
	private List<CopyFrase> frases = new LinkedList<CopyFrase>();
	
	public SectionTab(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addFrase(CopyFrase frase) {
		frases.add(frase);
	}
	
	public void removeFrase(int id) {
		frases.remove(id);
	}
	
	public CopyFrase getFrase(int id) {
		return frases.get(id);
	}

}
