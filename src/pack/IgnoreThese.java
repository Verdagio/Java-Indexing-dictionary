package pack;

import java.io.*;
import java.util.*;

public class IgnoreThese {
	
	Set<String> words = new TreeSet<String>();
	
	public IgnoreThese(){
		this.words = new TreeSet<String>();
	}//constructor
	
	public IgnoreThese(String theFile) {
		
		//In this we want to scan in the text file	
		try{
			Scanner ignored = new Scanner(new File(theFile));
			while(ignored.hasNext()){	
				//Add method to a treeset for fastest results 
				words.add(ignored.next().toUpperCase());	
			}// while the next line is not null keep reading
			ignored.close();
		}catch(Exception e){
			System.out.println(":(");
			e.printStackTrace();
		}// try & catch
	}//scan the stop words text file
	
	public boolean getIgnored(String ignored){
		return ignored.contains(ignored.toUpperCase());
	}//return the word

}//END OF CLASS
