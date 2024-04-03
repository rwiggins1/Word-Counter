package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Ricky Wiggins Jr
 */
public class WordSearchEngine {    
    private String SearchedWord = "";
    public String OriginallyText;
    
    public void setOriginallyText(String str){
        OriginallyText = str;
    }
    
    public String getRegexPattern(String str){
        StringBuilder regexPattern = new StringBuilder("(?i)[^");
        for (Character excludedChar : Reader.excludedChars) {
            regexPattern.append(Pattern.quote(String.valueOf(excludedChar)));
        }
        regexPattern.append("]*").append(Pattern.quote(str)).append("[^");
        for (Character excludedChar : Reader.excludedChars) {
            regexPattern.append(Pattern.quote(String.valueOf(excludedChar)));
        }
        regexPattern.append("]*");
        
        return regexPattern.toString();
    }
    
    /**
     * Searches the text for a specified word
     * and converts the word to all caps
     * @param word
     * @param text
     * @return ArrayList
     */
    public String Search(String word, String text){
        List<String> arr = new ArrayList<>(List.of(Reader.textStrip(text)));
        if(!SearchedWord.equalsIgnoreCase(word)){
            for(int i = 0; i < arr.size(); i++){
                if(arr.get(i).matches(getRegexPattern(word))){
                    arr.set(i, "[" + word.toUpperCase() + "]");
                }
            }
        }
        SearchedWord = word;
        return RevertToString(arr);
    }
    
    /**
     * Converts ArrayList to String
     * @param str
     * @return ArrayList as String
     */
    public String RevertToString(List<String> str){
        String text = "";
        
        for(int i = 0; i < str.size(); i++){
            text += " " + str.get(i) + " ";
        }
        
        return text;
    }
}
