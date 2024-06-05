package com.projetoa3.alpha0001;

import com.mysql.cj.log.Log;
import com.projetoa3.alpha0001.SQL.SQL;
import com.projetoa3.alpha0001.Usuario.DadosUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Config_ContaController implements Initializable {
    @FXML
    private Button Cupons;
    @FXML
    RadioButton alteraCEP = new RadioButton("Alterar CEP");
    @FXML
    private Label cid;
    @FXML
    private Button pagtoMet;
    @FXML
    private Button close;

    @FXML
    private Label estado;

    @FXML
    private Label log;

    @FXML
    RadioButton alteraEmail;

    @FXML
    RadioButton alteraSenha;
    @FXML
    private Button Doe;
    @FXML
    RadioButton alteraTel;

    @FXML
    private TextField Logradouro;

    @FXML
    private TextField Estado;
    @FXML
    private ChoiceBox<String> escolheEstado = new ChoiceBox<>();
     @FXML
    private Button verPedidos;

    @FXML
    private TextField NumRes;

    @FXML
    private TextField Cidade;

    @FXML
    private Label EmailShow;
     @FXML
    private TextField NewEmail;

    @FXML
    private TextField NewSenha;
    @FXML
    private TextField NewSenha1;
    @FXML
    private TextField NewTel;
    @FXML
    private Button Salvar;
    @FXML
    private Label asterisco;
    @FXML
    private Button fix;

    @FXML
    private Label PassShow;

    @FXML
    private Label TelShow;

    @FXML
    private Stage stage;
    @FXML
    private Button Voltar;
    @FXML
    private Label nomeLabel;

    @FXML
    private Button SalvarCEP;

    @FXML
    private Button SalvarEmail;

    @FXML
    private Button SalvarSenha;

    @FXML
    private Button SalvarTel;
    @FXML
    private Label num;

    @FXML
    private Button perfil;

    @FXML
    private Button senha;
     @FXML
    private Text EstadoT;

    @FXML
    private Text LogT;
    @FXML
    private Text cidT;
    @FXML
    private Text numT;

    Erros erros = new Erros();
    DadosUsuario dadosUsuario = DadosUsuario.getInstance();

    public void metPagto(ActionEvent event) throws IOException {
        System.out.println(dadosUsuario.getCreditos());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PayMetod.fxml"));
        Parent root = loader.load();
        pagtoMet.getScene().getWindow().hide();
        if(root != null){
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        }else{erros.erroFXML();}}


    public void alteraCEP(ActionEvent actionEvent)
    {
        if (alteraCEP.isSelected()) {
            Cidade.setText( dadosUsuario.getCidade());
            NumRes.setText(dadosUsuario.getNumero());
            Logradouro.setText(dadosUsuario.getLogradouro());


            Cidade.setDisable(false);
            NumRes.setDisable(false);
            Logradouro.setDisable(false);
            SalvarCEP.setVisible(true);
            escolheEstado.setDisable(false);
        }
        else{Cidade.setDisable(true);
            NumRes.setDisable(true);
            Logradouro.setDisable(true);
            SalvarCEP.setVisible(false);
            escolheEstado.setDisable(true);
        }

    }
    public void alteraEmail(ActionEvent actionEvent)
    {
        if (alteraEmail.isSelected()) {
            NewEmail.setDisable(false);
            SalvarEmail.setVisible(true);
        }
        else{SalvarEmail.setVisible(false);
            NewEmail.setVisible(true);}
    }
    public void alteraSenha(ActionEvent actionEvent)
    {
        if (alteraSenha.isSelected()) {
            asterisco.setVisible(false);
            PassShow.setVisible(true);
            NewSenha.setDisable(false);
            NewSenha1.setDisable(false);
            SalvarSenha.setVisible(true);
        }
        else{
            NewSenha.setDisable(true);
            NewSenha1.setDisable(true);
            PassShow.setVisible(false);
            SalvarSenha.setVisible(false);
            asterisco.setVisible(true);
        }
    }
    public void alteraTel(ActionEvent actionEvent)
    {
        if (alteraTel.isSelected()) {
            NewTel.setDisable(false);
            SalvarTel.setVisible(true);
        }
        else{NewTel.setDisable(true);
        SalvarTel.setVisible(false);}
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        EmailShow.setText(dadosUsuario.getEmail());
        try {
            PassShow.setText(dadosUsuario.getSenha());
            nomeLabel.setText(SQL.sqlNome(dadosUsuario.getEmail()));
            LogT.setText(dadosUsuario.getLogradouro());
            cidT.setText(dadosUsuario.getCidade());
            EstadoT.setText(dadosUsuario.getEstado());
            numT.setText(dadosUsuario.getNumero());
            TelShow.setText(dadosUsuario.getTelefone());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


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

    public void AlterarEmail(ActionEvent event) throws IOException, SQLException {
        if(SQL.sqlUpdateEmail(NewEmail.getText())== true){
             dadosUsuario.setEmail(NewEmail.getText());
            JOptionPane.showMessageDialog(null, "Email alterado com sucesso!");
        }else{JOptionPane.showMessageDialog(null,"Email não pode ser alterado");}

    }
    public void AlterarSenha(ActionEvent event) throws SQLException {
       if(SQL.sqlUpdateSenha(NewSenha.getText())){
           dadosUsuario.setSenha(NewSenha.getText());
           JOptionPane.showMessageDialog(null,"Senha alterada com sucesso");
       }else{JOptionPane.showMessageDialog(null,"Senha não pode ser atualizada");}

    }
    public void AlterarTel(ActionEvent event) throws SQLException {
       if(SQL.sqlUpdateTel(NewTel.getText()) == true){dadosUsuario.setTelefone(NewTel.getText());}
       else{JOptionPane.showMessageDialog(null,"Telefone não pode ser alterado");}

    }
    public void AlterarCEP(ActionEvent event) throws SQLException {
        if(SQL.sqlUpdateLog(Logradouro.getText()) == true){
            dadosUsuario.setCidade(Logradouro.getText());
            JOptionPane.showMessageDialog(null,"Logradouro alterada com sucesso");
        }

        if(SQL.sqlUpdateCidade(Cidade.getText()) == true){
            dadosUsuario.setCidade(Cidade.getText());
            JOptionPane.showMessageDialog(null,"Cidade alterada com sucesso");}

        if(SQL.sqlUpdateNumero(num.getText()) == true){
            dadosUsuario.setNumero(num.getText());
            JOptionPane.showMessageDialog(null,"Numero alterada com sucesso");
        }

    }
    public void doacao(ActionEvent event)throws IOException{
       Doe.getScene().getWindow();
       Parent root = FXMLLoader.load(getClass().getResource("newDoacao.fxml"));
       Stage stage = new Stage();
       Scene scene = new Scene(root);
       stage.initStyle(StageStyle.TRANSPARENT);
       stage.setScene(scene);
       stage.show();

    }
    public void verCupons(ActionEvent event) throws IOException, SQLException {
        if(dadosUsuario.getCupons() == null)
        {erros.erroCupons();}
        else
        {
            Cupons.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("viewCupons.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    void verPedido() throws IOException {
            verPedidos.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Pedidos.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
    }



    public void close() {
        int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza se quer fechar o programa?", "confirmação", JOptionPane.YES_NO_OPTION);
       if(resposta == JOptionPane.YES_OPTION) { System.exit(0);}}
 }






