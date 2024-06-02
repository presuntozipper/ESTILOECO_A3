package com.projetoa3.alpha0001;

import com.projetoa3.alpha0001.SQL.SQL;
import com.projetoa3.alpha0001.Usuario.DadosUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CadastroController implements Initializable {

    @FXML
    private Stage stage;
    @FXML
    private Button bypass;
    @FXML
    private TextField cep;
    @FXML
    private ChoiceBox<String> escolheEstado = new ChoiceBox<>();
    @FXML
    private Button Cadastro;

    @FXML
    private Button Voltar;

    @FXML
    private Button close;

    @FXML
    private TextField email;

    @FXML
    private TextField nome;

    @FXML
    private PasswordField senha;

    @FXML
    private PasswordField senha1;

    String sql;
    @FXML
    Erros erros = new Erros();
    DadosUsuario dados = DadosUsuario.getInstance();

    public void Processo_dados(ActionEvent event) throws IOException, SQLException
    {
    if(!SQL.sqlCadastro(nome.getText(), email.getText(), senha.getText(), cep.getText()))
    {
        erros.erroCadastro();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastro.fxml"));
        Parent root = loader.load();
        Cadastro.getScene().getWindow().hide();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    else if (!senha.getText().equals(senha1.getText()))
            {erros.erroSenha();}
    else {

        dados.setEmail(email.getText());
        dados.setTemp(escolheEstado.getValue());
        dados.setIdUsuario(SQL.sqlGetID(email.getText()));
        System.out.println(dados.getIdUsuario());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Verificacao.fxml"));
        Parent root = loader.load();
        Cadastro.getScene().getWindow().hide();
        if(root != null){
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}
        else{erros.erroFXML();}}
    }


    @FXML
    void mudar_pag(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Verificacao.fxml"));
        Parent root = loader.load();
        bypass.getScene().getWindow().hide();
        if(root != null){
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{System.err.println("Erro ao carregar FXML");}
    }

    @FXML
    public void mudar_de_pag(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewLogin.fxml"));
        Parent root = loader.load();
        Voltar.getScene().getWindow().hide();
        if(root != null){
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{System.err.println("Erro ao carregar FXML");}
 }
    public void close(){
        int resposta = JOptionPane.showConfirmDialog(null,"Você tem certeza se quer sair?","confirmação",JOptionPane.YES_NO_OPTION);
       if(resposta == JOptionPane.YES_OPTION) { System.exit(0);}}

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        escolheEstado.getItems().addAll("Acre (AC)",
            "Amapá (AP)",
            "Amazonas (AM)",
            "Pará (PA)",
            "Rondônia (RO)",
            "Roraima (RR)",
            "Tocantins (TO)",
            "Alagoas (AL)",
            "Bahia (BA)",
            "Ceará (CE)",
            "Maranhão (MA)",
            "Paraíba (PB)",
            "Pernambuco (PE)" ,
            "Piauí (PI)",
            "Sergipe (SE)",
            "Distrito Federal (DF)" ,
            "Goiás (GO)" ,
            "Mato Grosso (MT)",
            "Mato Grosso do Sul (MS)",
            "Espírito Santo (ES)" ,
            "Minas Gerais (MG)",
            "Rio de Janeiro (RJ)" ,
            "São Paulo (SP)",
            "Paraná (PR)" ,
            "Rio Grande do Sul (RS)" ,
            "Santa Catarina (SC)");
        escolheEstado.setValue("Acre(sc)");
    }
}
