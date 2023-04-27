
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class VistaSeleccionadorMonedaController implements Initializable {

    @FXML
    private ComboBox<String> micbxSeleccionMonedas;
    
    @FXML
    private TextField txt_dinero_copiado;
    

    private String[] misOpcionesConversion = {"De Boliviano a Dolar",
                                                "De Boliviano a Euro",
                                                "De Boliviano a Libra",
                                                "De Boliviano a Yen",
                                                "De Boliviano a Won Coreano",
                                                "De Dolar a Boliviano",
                                                "De Euro a Boliviano",
                                                "De libra a Boliviano"};

    
    // a)
    //Instanciamos la vista CantidadDeDineroController, la vista anterior...
    // Sirve para jalar los datos de la vista anterior
    VistaCantidadDeDineroController vista_cantidad_dinero; 
    
    // b)
    // Instanciamos ÉSTE mísmo controlador
    // Sirve para enviar datos a la vista siguiente:
    VistaSeleccionadorMonedaController seleccionador_moneda_instancia;
    
    
    
    
    
//    @FXML
//    private void llamaResultadoConversion(ActionEvent event) {
//
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(getClass().getResource("/vista/VistaResultadoConversion.fxml"));
//            Scene scene = new Scene(fxmlLoader.load());
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.showAndWait();
//
//        } catch (IOException ex) {
//            System.out.println("IO Exception " + ex.getMessage());
//        }
//
//    }

  
    
    @FXML
    private void llamaResultadoConversion ()throws IOException{
        Stage vistaSiguiente = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        AnchorPane root = (AnchorPane) fxmlLoader.load(getClass().getResource("/vista/VistaResultadoConversion.fxml").openStream());
    
        //Ahora creo una instacia del controlador de la vista siguiente, la vista que queremos abrir
        VistaResultadoConversionController Vis_Res_Conv_Ctrl_Instancia = (VistaResultadoConversionController)fxmlLoader.getController();
        
        // obtenemos los valores de los elemntos que deseamos enviar     
        String dinero = txt_dinero_copiado.getText();
        String conversion = micbxSeleccionMonedas.getValue();
        int indice = micbxSeleccionMonedas.getItems().indexOf(micbxSeleccionMonedas.getValue());
        
        // Enviamos los parámetros a una funcion de la vista siguiente: 
        Vis_Res_Conv_Ctrl_Instancia.reciv_param_vista_anterior(seleccionador_moneda_instancia, dinero, conversion, indice);
    
     
        Scene scene = new Scene(root);
        vistaSiguiente.setScene(scene);
        vistaSiguiente.alwaysOnTopProperty();
        vistaSiguiente.initModality(Modality.APPLICATION_MODAL);
        vistaSiguiente.show();
        
    }  
    
    

    @FXML
    public void recibe_param_vista_anterior(VistaCantidadDeDineroController vistaCantDinero, String texto) {
      txt_dinero_copiado.setText(texto);
      vista_cantidad_dinero = vistaCantDinero;
      
    }
    
    
    // Obtenemos los indices del elemento seleccionado, de 0 a 7, 8 elementos...
    @FXML
    public void elementoCmbxCambiado(){
        System.out.println("Elemento cambiado a : " + micbxSeleccionMonedas.getValue());
        System.out.println("Indice : " + micbxSeleccionMonedas.getItems().indexOf(micbxSeleccionMonedas.getValue()));
        
    }
    
    
      // Initializes the controller class.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializamos la variable, necesaria para el intercambio de datos entre vistas
        seleccionador_moneda_instancia = this;
        
        // Agregamos aqui los elementos de nuestro Combobox
        micbxSeleccionMonedas.getItems().addAll(misOpcionesConversion);
    }

}
