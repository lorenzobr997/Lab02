package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AlienDictionary model = new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TextField txtWord;
    
    @FXML
    private Button btnTranslate;
    
    @FXML
    private Button btnReset;
    
    @FXML
    private TextArea txtResult;

    @FXML
    void doTranslate(ActionEvent event) {
    	// TODO - add the button and complete this    
    	String string = txtWord.getText();
    	String[] parts = string.split(" ");
    	if(parts.length == 2) {
    		String alienWord = parts[0];
    		String translation = parts[1];
    		if(alienWord.matches("^[a-zA-Z]*$") && translation.matches("^[a-zA-Z]*$")){
    		model.addWord(alienWord, translation);
    		txtResult.appendText("Aggiunta la traduzione di " + parts[0] + "\n" + model.ricercaParola(parts[0]).toString());
    		}
    		else {
    			txtResult.setText("ERRORE: Il testo deve contenere solo lettere\n");
    		}
    	}else if(parts.length == 1) {
    		if(parts[0].matches("^[a-zA-Z]*$")) {
    			if(model.ricercaParola(string) == null) {
    				txtResult.appendText("Non esiste traduzione per " + string + "\n");
    			}
    			txtResult.appendText(model.translateWord(string));
    			}else {
        			txtResult.setText("ERRORE: Il testo deve contenere solo lettere\n");
        		}
    	}else {
			txtResult.setText("ERRORE: Numero di parole non valido");
			return;
		}
    	
    	
    	txtWord.clear();
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	// TODO - add the button and complete this
    	txtWord.clear();
    	txtResult.clear();
    }
    
    
    @FXML
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
    }
}