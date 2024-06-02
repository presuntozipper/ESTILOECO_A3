package com.projetoa3.alpha0001;

import com.projetoa3.alpha0001.Usuario.DadosUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.*;


public class PayMetodController implements Initializable {
    Erros erros = new Erros();
    DadosUsuario dados = DadosUsuario.getInstance();
    @FXML
    private Button Voltar;
    @FXML
    private Button Doe;
    @FXML
    private Label SHOWCREDIT;
    @FXML
    private RadioButton Credito;
    @FXML
    private RadioButton Debito;
    @FXML
    private RadioButton EcoCoins;
    @FXML
    private RadioButton PIX;
    @FXML
    private Text ShowCoins;
        @FXML
    private Label nomeLabel;

    public void pagar(ActionEvent event) {
    }
    public void doacao(ActionEvent event)throws IOException {
       Doe.getScene().getWindow();
       Parent root = FXMLLoader.load(getClass().getResource("newDoacao.fxml"));
       Stage stage = new Stage();
       Scene scene = new Scene(root);
       stage.initStyle(StageStyle.TRANSPARENT);
       stage.setScene(scene);
       stage.show();

    }
    public void voltar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pag_principal.fxml"));
        Parent root = loader.load();
        Voltar.getScene().getWindow().hide();
        if(root != null){
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        }else{erros.erroFXML();}}
     public void close()
    {
        int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza se quer fechar o programa?", "confirmação", JOptionPane.YES_NO_OPTION);
       if(resposta == JOptionPane.YES_OPTION) { System.exit(0);}}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       ShowCoins.setText(dados.getCreditos());
       nomeLabel.setText(dados.getUsuario());
    }
}
