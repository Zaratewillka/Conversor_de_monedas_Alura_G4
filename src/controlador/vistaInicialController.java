/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author dario
 */
public class vistaInicialController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private ComboBox<String> miComboBox;

    private String[] misOpciones = {"Conversor de Moneda", "Conversor de Temperatura"};

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @FXML
    private void decideConversor(ActionEvent event) {
        String miEleccion = miComboBox.getValue();

        if (miEleccion == "Conversor de Moneda") {
           
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/vista/vistaCantidadDeDinero.fxml"));

                Scene scene = new Scene(fxmlLoader.load());

                Stage stage = new Stage();
                //stage.setTitle("Mi titulo Actual");
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
            } catch (IOException ex) {
                System.out.println("IO Exception: " + ex.getMessage());
            }

        } else {
            
            try{
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/vista/vistaConversorTemperatura.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                
                Stage stage = new  Stage();
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
                        
            }catch (IOException ex){
                System.out.println("IO Exception: " + ex.getMessage());
            }
            
            
            
        }

    }


    private void ConversorDeTemperatura() {

    }

    public void obtenerEleccion(ActionEvent event) {
        String miEleccion = miComboBox.getValue();
        label.setText(miEleccion);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Agregamos aqui los elementos de nuestro Combobox
        miComboBox.getItems().addAll(misOpciones);

        //Referenciamos el metodo con DOBLE 2 puntos
        miComboBox.setOnAction(this::obtenerEleccion);

        //Referenciamos 
    }

}
