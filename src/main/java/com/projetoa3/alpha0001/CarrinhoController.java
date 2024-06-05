package com.projetoa3.alpha0001;

import com.projetoa3.alpha0001.Principal.Produtos.Produto;
import com.projetoa3.alpha0001.Usuario.Carrinho;

import com.projetoa3.alpha0001.Usuario.DadosUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CarrinhoController implements Initializable {
    Produto p = Produto.getInstance();
    Carrinho c = Carrinho.getInstance();
    Erros erros = new Erros();

    @FXML
    private TableColumn<Produto, Integer> id;
    @FXML
    private TableColumn<Produto, String> nomeProduct;

    @FXML
    private TableColumn<Produto, Double> preco;
        @FXML
    private TableView<Produto> tableCarrinho;

    @FXML
    private Stage stage;

    @FXML
    private ImageView teste;
    @FXML
    private Button delete;

    @FXML
    private Button Sair;
    @FXML
    private Button carrinho;
    @FXML
    private  ListView<String> listaCarrinho = new ListView<String>();
    @FXML
    private Button conta;
    @FXML
    private Button Doe;
    @FXML
    private ImageView logo;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Button carrega;
    @FXML
    private Text total;
    @FXML
    private Button voltar;
    @FXML
    private Button comprar;
    @FXML
    private ListView<String> listPreco = new ListView<String>();
    Produto prod = Produto.getInstance();
    DadosUsuario dados = DadosUsuario.getInstance();

    public void comprar(ActionEvent event) throws IOException {
       comprar.getScene().getWindow();
       Parent root = FXMLLoader.load(getClass().getResource("Pag_pagamento.fxml"));
       Stage stage = new Stage();
       Scene scene = new Scene(root);
       stage.initStyle(StageStyle.TRANSPARENT);
       stage.setScene(scene);
       stage.show();
    }


    public void voltar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pag_principal.fxml"));
        Parent root = loader.load();
        voltar.getScene().getWindow().hide();
        if(root != null){
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        }else{erros.erroFXML();}}
    public void addList() throws IOException {
        System.out.println(c.getCarrinho());
        //mostra os itens no carrinho
        listaCarrinho.getItems().clear();
        listaCarrinho.getItems().addAll(c.getCarrinho());
        //essa parte vai para mostrar o valor total do cariinho
        listPreco.getItems().clear();
        listPreco.getItems().addAll(String.valueOf(c.percloratodepotassio()));

        System.out.println("itens do carrinho addList "+c.getCarrinho());
        System.out.println("Valor do carrinho addList "+c.getValCarrinho());
        c.percloratodepotassio();
        System.out.println("Percloratodepotassio percorreu a lista "+c.percloratodepotassio());
    }
    public void removeList() throws IOException {
        int i = listaCarrinho.getSelectionModel().getSelectedIndex();
        listPreco.getItems().removeFirst();
        listaCarrinho.getItems().remove(i);
        c.brometo(i);
        c.francio(i);
        c.getCarrinho().remove(i);
        System.out.println("itens do carrinho "+c.getCarrinho());
        System.out.println("valor do carrinho "+c.getValCarrinho());

        listPreco.getItems().addAll(String.valueOf(c.getValCarrinho()));
        listPreco.refresh();


        System.out.println("Carrinho "+c.getCarrinho());
    }

   public void conta(ActionEvent event) throws IOException, SQLException {
            conta.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("Config_conta.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
   }

    public void carrinho(ActionEvent event) throws IOException
    {
            carrinho.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("Carrinho.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();

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

public void sair(ActionEvent actionEvent) throws IOException {
       int resposta = JOptionPane.showConfirmDialog(null,"Você tem certeza se quer sair?","confirmação",JOptionPane.YES_NO_OPTION);
       if(resposta == JOptionPane.YES_OPTION)
       {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("NewLogin.fxml"));
           Parent root = loader.load();
           Sair.getScene().getWindow().hide();
           Stage stage = new Stage();
           Scene scene = new Scene(root);
           stage.initStyle(StageStyle.TRANSPARENT);
           stage.setScene(scene);
           stage.show();
       }
   }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listPreco.getItems().addAll(String.valueOf(c.percloratodepotassio()));
        listaCarrinho.getItems().addAll(c.getCarrinho());

    }
}
