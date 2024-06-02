package com.projetoa3.alpha0001;
import com.projetoa3.alpha0001.SQL.*;
import com.projetoa3.alpha0001.Usuario.Carrinho;
import com.projetoa3.alpha0001.Usuario.DadosUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class LoginController extends Config_ContaController   implements Initializable
{
    Erros erros = new Erros();
    @FXML
    private Button Cadastro;
    @FXML
    private TextField Email;
    @FXML
    private Button Login;
    @FXML
    private TextField Senha;
    @FXML
    private Stage stage;
    @FXML
    DadosUsuario dados = DadosUsuario.getInstance();

    int resposta;
    public boolean fazerlogin(ActionEvent event) throws IOException {
        String usuario =  Email.getText();
        String senha = Senha.getText();
        try {
            if (SQL.sqlDados(usuario, senha)) {
                dados.setUsuario(usuario);

                dadosUsuario.setCredit(usuario);
                dados.setIdUsuario(usuario);
                dados.setUsuario(usuario);
                dados.setEmail(usuario);
                dados.setSenha(usuario);
                dados.setCEP(usuario);
                dados.setTelefone(usuario);
                dadosUsuario.setCidade(dadosUsuario.getIdUsuario());
                dadosUsuario.setLogradouro(dadosUsuario.getIdUsuario());
                dadosUsuario.setNumero(dadosUsuario.getIdUsuario());
                dadosUsuario.setEstado(dadosUsuario.getIdUsuario());

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Pag_principal.fxml"));
                Parent root = loader.load();
                Login.getScene().getWindow().hide();
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                System.out.println(".Fxml Carregado com sucesso");
                return true;
            }else{erros.erroLogin();return false;}
        }catch (SQLException e ){erros.erroLogin();}

        return false;
    }
    public void cadastro(ActionEvent event)  throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Cadastro.fxml"));
        Parent root = loader.load();
        Cadastro.getScene().getWindow().hide();
        if(root != null){
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        }else{erros.erroFXML();}

    }
    public void close()
    {
       resposta = JOptionPane.showConfirmDialog(null,"Você tem certeza se quer sair?","confirmação",JOptionPane.YES_NO_OPTION);
       if(resposta == JOptionPane.YES_OPTION) { System.exit(0);}}

    @Override
    public void initialize(URL location, ResourceBundle arg1) {

    }
}




