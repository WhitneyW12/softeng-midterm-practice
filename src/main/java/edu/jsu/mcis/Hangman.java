package edu.jsu.mcis;

import java.util.*;

public class Hangman {
    public enum Result { WIN, LOSE, NONE };
    private String word;
    private List<Character> usedLetters;
	private int occurs;
	private ArrayList<Character> rightList;
	private ArrayList<Character> wrongList;
    
    public Hangman() {
        word = "";
        usedLetters = new ArrayList<Character>();
		rightList = new ArrayList<Character>();
		wrongList = new ArrayList<Character>();
    }
    
    public void setWord(String word) {
        this.word = word;
    }
    
    public boolean available(char c) {
		if (usedLetters.contains(c) || occurs > 0){
			return false;
		}
		else{
			return true;
		}
    }
    
    public int guess(char c) {
		occurs = 0;
		char[] wordList = word.toCharArray();
		for (char letter:wordList){
			if (letter == c){
				occurs++;
				rightList.add(c);
			}
			else{
				wrongList.add(c);
			}
		}
		usedLetters.add(c);
        return occurs;
    }
    
    public Result getResult() {
		char[] wordList = word.toCharArray();
		
		if (rightList.size() == wordList.length){
			return Result.WIN;
		}
		else if (wrongList.size() >= 6){
			return Result.LOSE;
		}
        return Result.NONE;
    }
    
}












