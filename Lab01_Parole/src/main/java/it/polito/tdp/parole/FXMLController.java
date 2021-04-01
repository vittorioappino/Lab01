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
    	String parola = txtParola.getText();
    	double tempoInizio= System.nanoTime();
    	elenco.addParola(parola);
    	double tempoFine= System.nanoTime();
    	txtParola.clear();
    	txtResult.setText(elenco.toString());
    	double diff=(tempoFine-tempoInizio)/1e9;
    	String s =""+diff;
    	txtPrestazioni.setText(s);
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	double tempoInizio= System.nanoTime();
    	elenco.reset();
    	double tempoFine= System.nanoTime();
    	txtResult.clear();
    	double diff=(tempoFine-tempoInizio)/1e9;
    	String s =""+diff;
    	txtPrestazioni.setText(s);
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	String parola = txtResult.getSelectedText();
    	double tempoInizio= System.nanoTime();
    	elenco.Cancella(parola);
    	double tempoFine= System.nanoTime();
    	txtResult.clear();
    	txtResult.setText(elenco.toString());
    	double diff=(tempoFine-tempoInizio)/1e9;
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
