package model;

import java.util.LinkedList;
import java.util.List;

public class MainModel {

	private List<SectionTab> tabs = new LinkedList<SectionTab>();
	
	public void addTab(SectionTab tab) {
		tabs.add(tab);
	}
	
	public void removeTab(int id) {
		tabs.remove(id);
	}
	
	public SectionTab getTab(int id) {
		return tabs.get(id);
	}

}
