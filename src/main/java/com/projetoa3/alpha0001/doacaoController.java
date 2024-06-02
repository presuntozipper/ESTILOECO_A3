package com.projetoa3.alpha0001;

import com.projetoa3.alpha0001.Principal.Produtos.Produto;

import com.projetoa3.alpha0001.SQL.SQL;
import com.projetoa3.alpha0001.Usuario.DadosUsuario;
import com.projetoa3.alpha0001.Principal.Produtos.RandomGen;
import javafx.beans.property.SimpleStringProperty;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.*;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;

import java.sql.SQLException;
import java.util.ResourceBundle;

public class doacaoController implements Initializable {
      @FXML
    private Stage stage;

    @FXML
    private ImageView teste;

    @FXML
    private Button Sair;

    @FXML
    private Button carrinho;

    @FXML
    private Button conta;
    @FXML
    private Button cupon;
    @FXML
    private ListView<String> listView;
    @FXML
    private ImageView logo;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Button menu;
    @FXML
    private Spinner<Integer> contador;
     @FXML
    private ListView<Integer> listViewQTD;
    @FXML
    private TableView<Produto> tabela;
    @FXML
    private TableColumn<Produto, SimpleStringProperty> Categoria;
    @FXML
    private TableColumn<Produto, SimpleStringProperty> iD;
    @FXML
    private TextField insert;
    @FXML
    private Button Voltar;
    @FXML
    private Button insertItem;
    String code;
    Erros erros = new Erros();
    DadosUsuario dadosUsuario = DadosUsuario.getInstance();
    RandomGen  randon = RandomGen.getInstance();


    public void addLista(ActionEvent event) throws IOException {
        listView.getItems().add(insert.getText());
        listViewQTD.getItems().add(contador.getValue());
    }

     public void voltar(ActionEvent event) throws IOException {
        Stage stage = (Stage) Voltar.getScene().getWindow();
        stage.close();
     }


    public void Cupon(ActionEvent event) throws IOException, SQLException {
        code = String.valueOf(randon.genCode());
        SQL.sqlInsertCupom(dadosUsuario.getIdUsuario(), code);
        JOptionPane.showConfirmDialog(null,"Doação registrada com sucesso!"+'\n'+"Cupon: "+ code ,"Cupon",JOptionPane.PLAIN_MESSAGE);
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,1); {
            valueFactory.setValue(1);
            contador.setValueFactory(valueFactory);
        }
    }
}
