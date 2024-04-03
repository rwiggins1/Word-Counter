package com.mycompany.mavenproject1;

// Imports
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ricky Wiggins Jr
 */
public class Counter {
    //====================
    // Variables
    //====================
    private int SentenceCounter;
    private String[] words;
    private Set<Character> excludedChars = new HashSet<>(Arrays.asList('.', 
                ',', '!', ':', ';', '?', '&', '$', '#', '@', '%', '*', 
                '(', ')', '+', '=', '^', '"', '`'));
    
    //====================
    // Constructor
    //====================
    public Counter(){
        SentenceCounter = 0;
    }
    
    //====================
    // Word counting method
    //====================
    public int countWords(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        } 
        int wordCount = Reader.textStrip(str).length;
        
        return wordCount;
    }
    
    //==========================
    // Character Counting method
    //==========================
    public int countCharacters(String str){
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return str.length();
    }
    
    public int countCharactersWithoutSpaces(String str){
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int charCount = 0;
        String[] wordsArr = Reader.textStrip(str);
        for(int i = 0; i < wordsArr.length; i++){
            for(int j = 0; j < wordsArr[i].length(); j++){
                charCount++;
            }
        }
        
        return charCount;
    }
    
    //======================
    // Gets most common word
    //======================
    public String getMostCommonWord() {
        String CommonWord = "";
        for(String i : words){
            if(i.length() > CommonWord.length()){
                CommonWord = i;
            }
        }
        return CommonWord;
    }
    
    //=========================
    // Sentence counting method
    //=========================
    public int countSentences(String str){
        SentenceCounter = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '.' || c == '!' || c == '?'){
                SentenceCounter++;
            }
        }
        return SentenceCounter;
    }
    
    //=========================
    // Sentence counting method
    //=========================
    public double getAvgWordLength(){
        
        int charCount = 0;
        int wordCount = 0;
        double avg;
        
        // Counts characters
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if(!excludedChars.contains(c))
                    charCount++;
            }
        //Contains no letters
        if(words[i].matches("[^a-zA-Z]+")) 
            wordCount--;
        else //Contains letters
            wordCount++;
        }
        // gets avg
        avg = (double)charCount/wordCount;
        return avg;
    }
}
