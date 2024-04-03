package com.mycompany.mavenproject1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PrimaryController {
    Counter Counter = new Counter();
    @FXML
    TextArea TextBox;
    @FXML
    Label wordCountLabel;
    @FXML
    Label sentenceCountLabel;
    @FXML
    TextField textSizeTextBox;
    @FXML
    Label charCountLabel1;
    @FXML
    Label charCountLabel2;
    
    @FXML
    private void switchToSecondary() throws IOException {
        //App.setRoot("secondary");  
        System.out.println("Button pressed");
    }
    @FXML
    private void Execute(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            System.out.println("Calling methods");
            
            wordCountLabel.setText(String.valueOf(Counter.countWords(TextBox.getText())));
            sentenceCountLabel.setText(String.valueOf(Counter.countSentences(TextBox.getText())));
            
            charCountLabel1.setText(String.valueOf(Counter.countCharactersWithoutSpaces(TextBox.getText())));
            charCountLabel2.setText(String.valueOf(Counter.countCharacters(TextBox.getText())));
        }
    }
    
    @FXML
    private void ChangeTextSize(KeyEvent event)throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            TextBox.setStyle("-fx-font-size: " + textSizeTextBox.getText() + "px;");
        }
    }
    private int PC = 0;
    @FXML
    TextField WordSearchBox;
    WordSearchEngine WordSearchEngine = new WordSearchEngine();
    @FXML
    private void SearchWord(KeyEvent event)throws IOException {
        PC++;
        if(PC <= 1){
            WordSearchEngine.setOriginallyText(TextBox.getText());
        }
        if (event.getCode() == KeyCode.ENTER) {
            if(!WordSearchBox.getText().isBlank()){
                TextBox.setText(WordSearchEngine.Search(WordSearchBox.getText(), TextBox.getText()));
            }
        }
    }
    @FXML
    private void RevertText() throws IOException{
        TextBox.setText(WordSearchEngine.OriginallyText);
    }
    
    //===============================
    // Info Labels
    //===============================
    
    // Word count Info Label
    @FXML
    Label wordCountInfoLabel;
    @FXML
    private void wordCountInfoEnter()throws IOException{
        wordCountInfoLabel.setVisible(true);
    }
    @FXML
    private void wordCountInfoExit()throws IOException{
        wordCountInfoLabel.setVisible(false);
    }
    
    // Character count Info Label
    @FXML
    Label charCountInfoLabel;
    @FXML
    private void charCountInfoEnter()throws IOException{
        charCountInfoLabel.setVisible(true);
    }
    @FXML
    private void charCountInfoExit()throws IOException{
        charCountInfoLabel.setVisible(false);
    }
    
    // Text size Info Label
    @FXML
    Label textSizeInfoLabel;
    @FXML
    private void textSizeInfoEnter()throws IOException{
        textSizeInfoLabel.setVisible(true);
    }
    @FXML
    private void textSizeInfoExit()throws IOException{
        textSizeInfoLabel.setVisible(false);
    }
}