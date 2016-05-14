package pack;

import java.util.*;

public class WordDeets {
	
	private List<String> def = new LinkedList<String>();
	private List<Integer> pages = new LinkedList<Integer>();
	
	public WordDeets(){
		//Default constructor, creates 2 listzz	
		this.def = new LinkedList<String>();
		this.pages = new LinkedList<Integer>();
	}//construct
	
	public WordDeets(int pg){
		addIndex(pg);
	}//construct with pages
	
	public void addIndex(int pg){
		this.pages.add(pg);
	}//add index
	
	@Override
	public String toString(){
		int page;
		
		return "Definition: " +getDef()+ "\n" + "Pages: "+getPages();
	}//to string
	
	//GET & SET METHODS
	public List<String> getDef() {
		return def;
	}//get definition

	public void setDef(List<String> def) {
		this.def = def;
	}//set definition

	public List<Integer> getPages() {
		return pages;
	}//get pages

	public void setPages(List<Integer> pages) {
		
			this.pages = pages;
		
		
	}//set pages
	
	
	
	
	
}
