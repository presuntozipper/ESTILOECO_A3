package com.projetoa3.alpha0001;

import com.projetoa3.alpha0001.SQL.SQL;
import com.projetoa3.alpha0001.Usuario.DadosUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;



public class VefController {

    @FXML
    private Button Finalizar;

    @FXML
    private Button close;
    @FXML
    private ImageView concluido;
    DadosUsuario dadosUsuario = DadosUsuario.getInstance();
    @FXML
    void mudar_pag(ActionEvent event) throws IOException {
         SQL.sqlInsert(dadosUsuario.getIdUsuario(), dadosUsuario.getTemp());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewLogin.fxml"));
        Parent root = loader.load();
        Finalizar.getScene().getWindow().hide();
        if(root != null){
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{System.err.println("Erro ao carregar FXML");}
    }
    @FXML
    void realCompra(ActionEvent event) throws IOException {
        Stage stage = (Stage) Finalizar.getScene().getWindow();
        stage.close();
    }


    @FXML
    void close(){System.exit(0);}

}
