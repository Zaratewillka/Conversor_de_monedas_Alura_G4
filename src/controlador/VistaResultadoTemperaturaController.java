package controlador;

import convertidores.ConversorTemperaturas;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VistaResultadoTemperaturaController implements Initializable {

    @FXML
    private Label lbl_1;

    @FXML
    private Label lbl_2;

    @FXML
    private Label lbl_3;
    
    
    // Instanciamos la clase que nos va a resolver las conversiones de temperatura
    ConversorTemperaturas convertidor_sist_temp = new ConversorTemperaturas();
    
    // a)
    // Instanciamos la vista VistaSeleccionTemperaturaController, la vista anterior
    // sirve para jalar los datos de la vista anterior
    VistaSeleccionTemperaturaController selecc_sist_temp_instancia;
    
    

    @FXML
    private void llamaDeseasContinuar(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/vista/vistaDeseasContinuar.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex) {
            System.out.println("IO Exception " + ex.getMessage());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void recv_param_vista_anterior(VistaSeleccionTemperaturaController selecc_temp_instancia, String temperatura, String sist_temp, int indice) {
       
        // En el ejemplo esta asi, pertenece a la parte que recibe los datos de la vista anterior
        selecc_sist_temp_instancia = selecc_temp_instancia; 
        
        // Llamamos al convertidor de monedas
        double convertido = convertidor_sist_temp.tipoConversion(indice, Double.parseDouble(temperatura));
        
        lbl_1.setText("Temperatura : " + temperatura);
        lbl_2.setText("El índice es : " + indice + " " + "Sistema de conversión: " + sist_temp);
        lbl_3.setText("La temperatura ingresada: " + temperatura + " equivale a: " + convertido);
    }

}
