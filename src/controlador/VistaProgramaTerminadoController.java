package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VistaProgramaTerminadoController implements Initializable {

    @FXML
    private Button btnCerrarSistema;

    @FXML
    private void cerrarTodasVentanas(ActionEvent event) {
        Stage stage = (Stage) this.btnCerrarSistema.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
