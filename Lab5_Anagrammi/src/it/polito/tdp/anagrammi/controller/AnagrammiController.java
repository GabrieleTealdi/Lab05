package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.AnagrammiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	AnagrammiModel model = new AnagrammiModel();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtText;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea txtResCorretti;

    @FXML
    private TextArea txtResErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	String parola = txtText.getText();
    	//txtResCorretti.appendText(model.cerca(parola).toString());
    	List<Anagramma> sol = model.cerca(parola);
    	for(Anagramma a: model.cercaSolCorrette(sol))
    		txtResCorretti.appendText(a.toString()+"\n");
    	//txtResCorretti.appendText(model.cercaSolCorrette(sol).toString());
    	sol.removeAll(model.cercaSolCorrette(sol));
    	//txtResErrati.appendText(sol.toString());
    	for(Anagramma a: sol)
    		txtResErrati.appendText(a.toString()+"\n");

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtText.clear();
    	txtResCorretti.clear();
    	txtResErrati.clear();

    }

    @FXML
    void initialize() {
        assert txtText != null : "fx:id=\"txtText\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResCorretti != null : "fx:id=\"txtResCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResErrati != null : "fx:id=\"txtResErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";
    }
    
    public void setModel(AnagrammiModel model) {
    	this.model = model;
    }
    
}
