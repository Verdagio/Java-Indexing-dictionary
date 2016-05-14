package pack;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws Exception {
		
		Scanner in = new Scanner(System.in);
		String name = "x",theWord, end = "endprog";
		TheBook book;
		int selection = 0;
		boolean gameOver = false;
		
		//parse the dictionary file, the stop words, & the book!
		//PoblachtNaHEireann.txt, DeBelloGallico.txt, WarAndPeace-LeoTolstoy.txt
		
		do{
			System.out.printf("Please enter your choice: \n1 - War & Peace\n2 - Poblacht NaH Eireann\n3 - De Bello Gallico\n4 - Other\n");	
			selection = in.nextInt();
			switch(selection){
			case 1:
				name = "WarAndPeace-LeoTolstoy.txt";
				break;
			case 2:
				name = "PoblachtNaHEireann.txt";
				break;
			case 3:
				name = "DeBelloGallico.txt";
				break;
			case 4:
				System.out.println("Copy the text file into the java project folder");
				System.out.println("Enter book name including prefix(eg. harrypotter.txt): ");
				name = in.nextLine();
				break;
			}//switch
		}while(selection < 1 || selection > 4);
		/* Once the user has decided what book they want to use.
		 * load the book name into the the book which will then
		 * be read in and parsed by the 'TheBook' class. Then we
		 * can start our search! Happy days!
		 */
		book = new TheBook(name);
		System.out.println("Ready to go.");
		
		do{//do this stuff while the word isn't the kill word
			System.out.println("Please enter the desired word(endprog to end): ");
			theWord = in.nextLine().toUpperCase();
			if(theWord.equalsIgnoreCase(end)){
				gameOver=true;
			}//if
			else{
				System.out.println(book.getWord(theWord));
				
			}//else
		}while(!gameOver);
		
		System.out.println("End");
	}//MAIN

}//END OF CLASS
