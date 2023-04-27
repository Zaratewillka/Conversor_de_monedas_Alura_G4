package controlador;

import convertidores.ConvertidorMonedas;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VistaResultadoConversionController implements Initializable {

    @FXML
    private Button btnLlamaDeseasContinuar;

    @FXML
    private Label lbl_1;

    @FXML
    private Label lbl_2;

    @FXML
    private Label lbl_3;
    
    // Instanciamos la clase que  nos va a resolver las conversiones de moneda
    ConvertidorMonedas conversor_monedas = new ConvertidorMonedas();

    // a)
    // Instanciamos la vista SeleccionadorMonedaController, la vista anterior
    // Sirve para jalar los datos de la vista anterior
    VistaSeleccionadorMonedaController selecc_moneda_instancia;

    @FXML
    private void LlamaDeseasContinuar(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/vista/vistaDeseasContinuar.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex) {
            System.out.println("Excepcion IO RESULTADO CONVERSION : " + ex.getMessage());
        }
    }

    //  Initializes the controller class.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void reciv_param_vista_anterior(VistaSeleccionadorMonedaController seleccionador_moneda_instancia, String dinero, String conversion, int indice) {

        
        
        // Este código es parte de donde se recibe los datos de la anterior vista
        selecc_moneda_instancia = seleccionador_moneda_instancia;
        
        
               
        //Llamamos al convertidor de monedas
        double convertido = conversor_monedas.seleccionadorTipoConversion(indice, Double.parseDouble(dinero));
        
        lbl_1.setText("Cantidad de dinero: " + dinero);
        lbl_2.setText("El índice es: " + indice + " " + ". Tipo de conversión: " + conversion);
        lbl_3.setText("El dinero ingresado : " + dinero + " equivale a : " + convertido);
        
        
    }

}
