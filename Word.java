// Quazi Uzma Nadeem 22D

import java.util.*;
import java.util.regex.*;
public class Word implements Comparable{
	private String word;
	
	public Word(String word) throws IllegalWordsException
	{
		this.word = word;
		if(!Pattern.matches("[a-zA-Z]+",word))
			throw new IllegalWordsException("Invalid Word -"+word+";");
	}
	
	// Set method to set the value of a word  variable
	public void setWord(String word)
	{
		this.word = word;
	}
	
	// get method to get the value of the word
	public String getWord()
	{
		return word;
	}
	
	public String toString()
	{
		return word;
	}
	
	public int compareTo(Word other)
	{
		return this.word.compareTo(other.toString());
	}

	public int compareTo(Object o)
	{
		return this.compareTo((Word)o);
	}
}
