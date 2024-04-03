package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ricky Wiggins Jr
 */
public class Reader {
    static Set<Character> excludedChars = new HashSet<>(Arrays.asList('.', 
                ',', '!', ':', ';', '?', '&', '$', '#', '@', '%', '*', 
                '(', ')', '[', ']', '+', '=', '^', '"', '`'));
    
    /**
     * Reads text and splits the text via white space. Returns array.
     * @param str
     * @return Array of words
     */
    public static String[] textStrip(String str){
        String[] words;
        words = str.split("\\s+");
        return words;
    }
    
    /**
     * Uses textStrip method to split text via white space
     * and inserts into an array.
     * Seperates punctuation as its own element in the array.
     * @param str
     * @return ArrayList of words and punctuation
     */
    public static ArrayList<String> textStripPunctuation(String str) {
        String[] words = textStrip(str);
        ArrayList<String> newWords = new ArrayList<>();
        
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                char c = words[i].charAt(j);
                if(j == words[i].length()-1 && excludedChars.contains(c)){
                    String modifiedWord = words[i].replace(String.valueOf(c), "");
                    newWords.add(modifiedWord);
                    newWords.add(String.valueOf(c));
                }
                else if(j == words[i].length()-1){
                    newWords.add(words[i]);
                }
            }
        }       
        return newWords;
    }
}