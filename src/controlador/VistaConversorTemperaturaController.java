package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

// Aqui ingresamos la temperatura que vamos a convertir a otro sistema
public class VistaConversorTemperaturaController implements Initializable {

    @FXML
    private TextField txt_fld_temp_conv;
                      

    // Instanciamos ÉSTE mismo controlador
    VistaConversorTemperaturaController conv_temperatura_instancia;

    @FXML        
    private void llamaSeleccionTemperatura() throws IOException {
        Stage vistaSigSeleccion = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        AnchorPane root = (AnchorPane) fxmlLoader.load(getClass().getResource("/vista/vistaSeleccionTemperatura.fxml").openStream());
        
        //Ahora creo una instancia del controlador de la vista siguiente:
        VistaSeleccionTemperaturaController selecc_temperatura_instancia = (VistaSeleccionTemperaturaController)fxmlLoader.getController();
        
        //Enviamos los parametros a una funcion de la vista siguiente...
        selecc_temperatura_instancia.recv_param_vista_anterior(conv_temperatura_instancia, txt_fld_temp_conv.getText());
        
        
        Scene scene = new Scene(root);
        vistaSigSeleccion.setScene(scene);
        vistaSigSeleccion.alwaysOnTopProperty();
        vistaSigSeleccion.initModality(Modality.APPLICATION_MODAL);
        vistaSigSeleccion.show();
        
    }

//    @FXML
//    private void llamaSeleccionTemperatura(ActionEvent event) {
//
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(getClass().getResource("/vista/vistaSeleccionTemperatura.fxml"));
//            Scene scene = new Scene(fxmlLoader.load());
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.showAndWait();
//        } catch (IOException ex) {
//            System.out.println("Excepcion en CONV TEMP: " + ex.getMessage());
//        }
//
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicializamos la variable
        conv_temperatura_instancia = this;
        
    }

}
