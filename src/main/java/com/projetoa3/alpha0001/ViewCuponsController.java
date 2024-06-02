package com.projetoa3.alpha0001;

import com.projetoa3.alpha0001.SQL.SQL;
import com.projetoa3.alpha0001.Usuario.DadosUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewCuponsController implements Initializable {
    @FXML
    private ListView<String> ListViewCupon;
    @FXML
    private Button voltar;
    DadosUsuario dados = DadosUsuario.getInstance();

    @FXML
    void voltar(ActionEvent event) {
        Stage stage = (Stage) voltar.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ListViewCupon.getItems().addAll(dados.getCupons());
    }
}
