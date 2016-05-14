package pack;

import java.io.*;
import java.util.*;

public class Dictionary {
	
	Map<String, List<String>> dictionary = new HashMap<String, List<String>>();
	
	public Dictionary(){
		this.dictionary = new HashMap<String, List<String>>();
	}//construct
	
	public Dictionary(String theFile) {
		
		try{
		BufferedReader br = new BufferedReader(new FileReader(theFile));
		StringBuilder define = new StringBuilder();
		br.readLine();
		String line = br.readLine();
		while((line = br.readLine()) != null){
			//System.out.println(line); If we want to print out the dictionary to the console
			
			//In here we want to read in the word and definition
			if(line.charAt(0) == '"'){
				String word = line.substring(1, line.indexOf('"',1));
				do{
					//System.out.println("in the do");
					define.append(line + "\n");
					line = br.readLine();
				}while((line = br.readLine()) != null && line.charAt(0) != '"');
				//while the next is not null & the char at pos 0 is not " 

				//set the word to lower and add both the word and definition
				setDefine(word.toUpperCase(), define.toString());
				//clear the string
				define = new StringBuilder();
			}//if the char at pos 0 is a comma
			
		}//while the line read in from buffered reader is not null
		br.close();
		} catch (Exception e) {
			System.out.println(":(");
			e.printStackTrace();
		}//try & catch
		
	}//parse the dictionary (read in & scan the dictionary)
	
	public List<String> getDefine(String word){
		return dictionary.get(word.toUpperCase());
	}//get the definition for the word
	
	public void setDefine(String word, String def){
		if(dictionary.get(word) == null){
			//System.out.println("set definition method");
			List<String> ls = new LinkedList<String>();
			ls.add(def);
			dictionary.put(word, ls);//O(1) Constant time
		}//if the word is = to null (our word is not in the dictionary
		else{
			dictionary.get(word).add(def);
		}//otherwise our word is in the dictionary and we add the definition to it
	}//set the definition for the word
	

}//END OF CLASS
