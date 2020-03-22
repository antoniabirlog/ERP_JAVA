package application;

import java.io.IOException;

import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class SampleController {
	public static Rengine engine = new Rengine(new String[] { "--no-save--" }, false, null);

	@FXML
	void handleButtonAction(ActionEvent event) throws IOException {
	     System.out.println("Am apasat");
	     StringBuilder sb;
	        engine.eval("source('C:/Users/Antonia/Desktop/MASTER sem 4/ERP/scripts/functiiUtilizate.R')");

	        REXP result2 = engine.eval("e");
			System.out.println(result2);
	 }
	
	
	@FXML
	void incarcaDate(ActionEvent event) throws IOException{
		
		
		Runtime rt = Runtime.getRuntime();
		System.err.println(String.format("Free: %d bytes, Total: %d bytes, Max: %d bytes",
		  rt.freeMemory(), rt.totalMemory(), rt.maxMemory()));
	    
	    
	    
		System.out.println("Date in curs de incarcare...");
		 engine.eval("source('C:/Users/Antonia/Desktop/MASTER sem 4/ERP/scripts/incarcaDate.R')");
		
        REXP result2 = engine.eval("varianta.comp");
		System.out.println(result2);


        		
	}
	
	@FXML
	void afiseazaGrafic(ActionEvent event) throws IOException{
		System.out.println("Date in curs de procesare...");
        engine.eval("source('C:/Users/Antonia/Desktop/MASTER sem 4/ERP/scripts/tabelareVarianta.R')");  
	}
	
	@FXML
	void corelogramaVar(ActionEvent event){
		System.out.println("Matrice corelatie");
		  engine.eval("source('C:/Users/Antonia/Desktop/MASTER sem 4/ERP/scripts/matriceCorelatie.R')");
		 
	}
	
	@FXML
	void componente(ActionEvent event){
		System.out.println("Componente nestandardizate");
		  engine.eval("source('C:/Users/Antonia/Desktop/MASTER sem 4/ERP/scripts/compNestand.R')");
		 
		 
	}
	
	@FXML
	void componenteStd(ActionEvent event){
		System.out.println("Componente standardizate");
		  engine.eval("source('C:/Users/Antonia/Desktop/MASTER sem 4/ERP/scripts/compStand.R')");
		 
	}
	
	@FXML
	void corVarComp(ActionEvent event){
		System.out.println("Corelograma variabile observate - componente");
		  engine.eval("source('C:/Users/Antonia/Desktop/MASTER sem 4/ERP/scripts/corelatiiVarComp.R')");
	}
	
	@FXML
	void cercCorelatii(ActionEvent event){
		System.out.println("Cercul corelatiilor...");
		  engine.eval("source('C:/Users/Antonia/Desktop/MASTER sem 4/ERP/scripts/cercCorelatii.R')");
	}
	
	@FXML
	void cosinusuri(ActionEvent event){
		System.out.println("Cosinusuri...");
		  engine.eval("source('C:/Users/Antonia/Desktop/MASTER sem 4/ERP/scripts/cosinusuri.R')");
		  Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setTitle("Mesaj informare ");
		  alert.setHeaderText("");
		  alert.setContentText("Un fisier csv a fost creat in folderul de lucru curent");
		  alert.showAndWait().ifPresent(rs -> {
		      if (rs == ButtonType.OK) {
		          System.out.println("Pressed OK.");
		      }
		  });
	}
	
	@FXML
	void contributii(ActionEvent event){
		System.out.println("Creare Contributii.csv");
		  engine.eval("source('C:/Users/Antonia/Desktop/MASTER sem 4/ERP/scripts/contributii.R')");
		  Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setTitle("Mesaj informare ");
		  alert.setHeaderText("");
		  alert.setContentText("Un fisier csv a fost creat in folderul de lucru curent");
		  alert.showAndWait().ifPresent(rs -> {
		      if (rs == ButtonType.OK) {
		          System.out.println("Pressed OK.");
		      }
		  });
	}
	
	@FXML
	void comunalitati(ActionEvent event){
		System.out.println("Creare Comunalitati.csv");
		  engine.eval("source('C:/Users/Antonia/Desktop/MASTER sem 4/ERP/scripts/comunalitati.R')");
	}
	
	@FXML
	void scoruriSupl(ActionEvent event){
		System.out.println("Extindere model...");
		  engine.eval("source('C:/Users/Antonia/Desktop/MASTER sem 4/ERP/scripts/scoruriSupl.R')");
	}
	
	
	
	@FXML
	void sterge(ActionEvent event){
		System.out.println("Se inchide...");
		  engine.eval("rm(list=ls())");
		  Platform.exit();
	}
	
	
}