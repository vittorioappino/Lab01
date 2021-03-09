package it.polito.tdp.parole;

import it.polito.tdp.parole.model.ParoleLinkedList;
import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	ParoleLinkedList elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextArea txtPrestazioni;

    
    @FXML
    private Button btnCancella;

    @FXML
    void doInsert(ActionEvent event) {
    	long tempoInizio= System.nanoTime();
    	String parola = txtParola.getText();
    	elenco.addParola(parola);
    	txtParola.clear();
    	txtResult.setText(elenco.toString());
    	long tempoFine= System.nanoTime();
    	long diff=tempoFine-tempoInizio;
    	String s =""+diff;
    	txtPrestazioni.setText(s);
    }

    @FXML
    void doReset(ActionEvent event) {
    	long tempoInizio= System.nanoTime();
    	txtParola.clear();
    	elenco.reset();
    	txtResult.clear();
    	long tempoFine= System.nanoTime();
    	long diff=tempoFine-tempoInizio;
    	String s =""+diff;
    	txtPrestazioni.setText(s);
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	long tempoInizio= System.nanoTime();
    	String parola = txtResult.getSelectedText();
    	elenco.Cancella(parola);
    	txtResult.clear();
    	txtResult.setText(elenco.toString());
    	long tempoFine= System.nanoTime();
    	long diff=tempoFine-tempoInizio;
    	String s =""+diff;
    	txtPrestazioni.setText(s);
    }

    @FXML
    void initialize() {
    	  assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
          assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
          assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
          assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
          assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
          assert txtPrestazioni != null : "fx:id=\"txtPrestazioni\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new ParoleLinkedList() ;
    }
}
