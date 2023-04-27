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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VistaSeleccionTemperaturaController implements Initializable {

    @FXML
    private ComboBox<String> cmbxSistTemperatura;

    private String[] misSistemasTemperatura = {"Grados a Fahrenheit", "Fahrenheit a Grados",
        "Grados a Kelvin", "Kelvin a Grados",
        "Fahrenheit a Kelvin", "Kelvin a Fahrenheit",
        "Grados a Rankine", "Rankine a Grados",
        "Fahrenheit a Rankine", "Rankine a Fahrenheit",
        "Rankine a Kelvin", "Kelvin a Rankine"};

    @FXML
    private Label lbl_temp_recuperada;

    //@FXML
    //private TextField txt_fld_temp_conv;

    // a)
    // Instanciamos la vista CantidadDeDineroController, la vista anterior...
    // Sirve para jalar los datos de la vista anterior
    VistaConversorTemperaturaController conversor_temperatura_instancia;

    // b
    // Instanciamos ÉSTE mísmo controlador
    // Nos servirá para enviar datos a la vista siguiente
    VistaSeleccionTemperaturaController selecc_temp_instancia;

    @FXML
    private void llamaResultadoTemperatura() throws IOException {
        Stage vistaSiguiente = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        AnchorPane raiz = (AnchorPane) fxmlLoader.load(getClass().getResource("/vista/vistaResultadoTemperatura.fxml").openStream());

        // Ahora creo una instancia del controlador de la vista siguiente, la vista que queremos abrir
        VistaResultadoTemperaturaController resultado_temp_instancia = (VistaResultadoTemperaturaController)fxmlLoader.getController();

        //Obtenemos los valores de los elementos que queremos enviar
        String temperatura = lbl_temp_recuperada.getText();
        String sist_temp = cmbxSistTemperatura.getValue();
        int indice = cmbxSistTemperatura.getItems().indexOf(cmbxSistTemperatura.getValue());

        // Enviamos los valores a una funcion de la vista siguiente
        resultado_temp_instancia.recv_param_vista_anterior(selecc_temp_instancia, temperatura, sist_temp, indice);

        Scene scene = new Scene(raiz);
        vistaSiguiente.setScene(scene);
        vistaSiguiente.alwaysOnTopProperty();
        vistaSiguiente.initModality(Modality.APPLICATION_MODAL);
        vistaSiguiente.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Inicializamos la variable, necesaria para el intercambio de datos entre vistas
        selecc_temp_instancia = this;

        // Agregamos las opciones al Combobox
        cmbxSistTemperatura.getItems().addAll(misSistemasTemperatura);

    }

    void recv_param_vista_anterior(VistaConversorTemperaturaController conv_temperatura_instancia, String texto) {
        lbl_temp_recuperada.setText(texto);
        conversor_temperatura_instancia = conv_temperatura_instancia;

    }

}
