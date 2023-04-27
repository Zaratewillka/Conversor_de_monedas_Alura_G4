package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VistaCantidadDeDineroController implements Initializable {

    @FXML
    private TextField dinero_a_convertir;

    @FXML
    private Button btnEscogerMoneda;

    // Instanciamos ÉSTE mísmo controlador
    VistaCantidadDeDineroController cant_dinero_ctrl_instancia;
    
    
     @FXML
    private void llamaVentanaSeleccionaMoneda() throws IOException {
        Stage vistaSiguiente = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        AnchorPane root = (AnchorPane) fxmlLoader.load(getClass().getResource("/vista/VistaSeleccionadorMoneda.fxml").openStream());

        //Ahora creo una instacia del controlador de la vista siguiente, la vista que queremos abrir
        VistaSeleccionadorMonedaController vista_2_Control_Instancia = (VistaSeleccionadorMonedaController) fxmlLoader.getController();

        // Enviamos los parametros a una funcion de la "vista" siguente...
        vista_2_Control_Instancia.recibe_param_vista_anterior(cant_dinero_ctrl_instancia, dinero_a_convertir.getText());

        
        
        Scene scene = new Scene(root);
        vistaSiguiente.setScene(scene);
        vistaSiguiente.alwaysOnTopProperty();
        vistaSiguiente.initModality(Modality.APPLICATION_MODAL);
        vistaSiguiente.show();

    }
    

//    @FXML
//    private void llamaVentanaSeleccionaMoneda(ActionEvent event) {
//
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(getClass().getResource("/vista/VistaSeleccionadorMoneda.fxml"));
//            
//            // Creo una instancia del controlador/vista que estamos abriendo
//            VistaSeleccionadorMonedaController vistaSeleccMonedaInstancia = (VistaSeleccionadorMonedaController)fxmlLoader.getController();
//            vistaSeleccMonedaInstancia.recibe_param(cant_dinero_ctrl_instancia, dinero_a_convertir.getText());
//            
//            
//            Scene scene = new Scene(fxmlLoader.load());
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            
//            
//            
//            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.showAndWait();
//            
//            
//
//        } catch (IOException ex) {
//            System.out.println("IO Exception " + ex.getMessage());
//        }
//    }


    //Initializes the controller class.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicializamos la variable
        cant_dinero_ctrl_instancia = this;   
    }


}
