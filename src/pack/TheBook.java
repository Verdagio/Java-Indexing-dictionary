package pack;

import java.io.*;
import java.util.*;

public class TheBook {
	
	private int pageC=1, lineC=0;
	IgnoreThese ignore = new IgnoreThese("stopwords.txt");
	Dictionary dictionary = new Dictionary("dictionary.csv");
	Map<String, WordDeets> theMap = new HashMap<String, WordDeets>();
	
	public TheBook(){
		this.theMap = new HashMap<String, WordDeets>();
	}
	
 	public TheBook(String theFile) throws Exception{
 		long totalTime, endTime, startTime = System.currentTimeMillis()%1000;
		BufferedReader br;
		String [] words;
		String line;
		WordDeets deets;
		List <String> define; //used on line 56...
		int i;
		
		br = new BufferedReader(new InputStreamReader(new FileInputStream(theFile)));
		
		br.readLine();
		while((line = br.readLine()) != null){
			lineC++;
			if(lineC % 40 == 0){
				pageC++;
			}//If we have 40 lines next page.
			//System.out.println(line); If we want to print out the the book to the console
			//Put all the words in the line into the array & loop through the array
			words = line.split(" ");		
			for(i = 0; i < words.length; i++){

				if(ignore.getIgnored(words[i])){
					continue;
				}//	If ignore has the word skip it
				
				/* containsKey - Returns true if this map contains a mapping for the key - done in O(n)
				 * get - Returns the value to which the specified key is mapped, null if not mapped
				 * If the word is mapped then we add the page number to the index.
				 */
				if (theMap.containsKey(words[i].toUpperCase())){
					deets = theMap.get(words[i].toUpperCase());
					deets.addIndex(pageC);
				}//if
				else {
					/* Otherwise - create a new word detail object (deets), w/ page no,
					 *  set & get the definition then put it into the map.
					 */
					deets = new WordDeets(pageC);
					deets.setDef((define = dictionary.getDefine(words[i])));
					theMap.put(words[i].toUpperCase(), deets);
				}//if else if
			}//for
		}//While
		//close the file
		br.close();
		endTime   = System.currentTimeMillis()%1000;
		totalTime = endTime - startTime;
		System.out.println("Book Parsed: "+ totalTime + "ms");
	}//Parse the book
	
	public String getWord(String wd){
		/* We create a timer so we can see in milliSeconds how long the query takes
		 * coll the get to get the value to which the specified word is mapped
		 * check if it exists in our word detail & return our result.
		 */
		long totalTime, endTime, startTime = System.currentTimeMillis()%1000;
		WordDeets deets = theMap.get(wd.toUpperCase());
		String res;
		
		if(deets != null){
			res =  deets.toString();
		} else {
			res = "Not Found";
		}//if deets has data return it otherwise not found
		endTime   = System.currentTimeMillis()%1000;
		totalTime = endTime - startTime;
		return res +"\n\nQuery Executed in: " + totalTime + "ms";
	}//get key
	
	public WordDeets getValue(String v){
		return theMap.get(v);
	}//get value
	
	public int getPage(){
		return this.pageC;
	}//get page
	
	public int getLine(){
		return this.lineC;
	}//get line	
}//End of Class
