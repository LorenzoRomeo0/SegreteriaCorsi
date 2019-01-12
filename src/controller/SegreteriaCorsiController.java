package controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.*;

public class SegreteriaCorsiController {
	Model model;
	
	 	@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ComboBox<String> comboCorsi;

	    @FXML
	    private TextField txtCodice;

	    @FXML
	    private Button btnCompila;

	    @FXML
	    private TextField txtNome;

	    @FXML
	    private TextField txtCognome;

	    @FXML
	    private Button btnCerca;

	    @FXML
	    private Button btnIscrivi;

	    @FXML
	    private TextArea txtResult;

	    @FXML
	    private Button btnReset;

	    @FXML
	    void cerca(ActionEvent event) {

	    }
	    
	    @FXML
	    void compila(ActionEvent event) {
	    	txtNome.setText(model.findStudentName(Integer.parseInt(txtCodice.getText())));
	    	txtCognome.setText(model.findStudentSurname(Integer.parseInt(txtCodice.getText())));
	    }

	    @FXML
	    void iscrivi(ActionEvent event) {

	    }

	    @FXML
	    void reset(ActionEvent event) {

	    }

	    @FXML
	    void selection(ActionEvent event) {

	    }

	    @FXML
	    void initialize() {
	        assert comboCorsi != null : "fx:id=\"comboCorsi\" was not injected: check your FXML file 'SegreteriaCorsi.fxml'.";
	        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'SegreteriaCorsi.fxml'.";
	        assert btnCompila != null : "fx:id=\"btnCompila\" was not injected: check your FXML file 'SegreteriaCorsi.fxml'.";
	        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaCorsi.fxml'.";
	        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaCorsi.fxml'.";
	        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'SegreteriaCorsi.fxml'.";
	        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaCorsi.fxml'.";
	        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaCorsi.fxml'.";
	        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaCorsi.fxml'.";
	        model=new Model();
	        for(String s:model.getCorsi())
	        	System.out.println(s);
	        comboCorsi.getItems().addAll(model.getCorsi());
	        txtCodice.textProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(ObservableValue<? extends String> observable, String oldValue, 
		            String newValue) {
		            if (!newValue.matches("\\d*")) {
		                txtCodice.setText(newValue.replaceAll("[^\\d]", ""));
		            }
		        }
		    });
	    }
	void setModel(Model m) {
		model=m;
	}
}
