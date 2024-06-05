package com.projetoa3.alpha0001;

import com.projetoa3.alpha0001.Usuario.DadosUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PedidosController implements Initializable {

    @FXML
    private Button close;
    @FXML
    private ListView<String> ListPedidos;
    DadosUsuario dados = DadosUsuario.getInstance();

    @FXML
    void close(ActionEvent event) {
    Stage stage = (Stage) close.getScene().getWindow();
    stage.close(); }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for(int i = 0; i < dados.getPedido().size(); i++ ){
            ListPedidos.getItems().addAll(String.valueOf(dados.getPedido().get(i)));
        }

    }
}
