package com.projetoa3.alpha0001.Principal.Produtos;

import com.projetoa3.alpha0001.Usuario.Carrinho;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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

public class JaquetaController implements Initializable {
     @FXML
    private ChoiceBox<String> escolheTam;
    @FXML
    private Text NomeProduto;
    @FXML
    private Text preco;
    @FXML
    private Button Doe;

    @FXML
    private Button addCarrinho;

    @FXML
    private Button carrinho;

    @FXML
    private Button conta;

    @FXML
    private ImageView loggoutIcon;

    @FXML
    private ImageView logo;

    @FXML
    private BorderPane mainPane;

    @FXML
    private ImageView teste;
    @FXML
    private Text total;
    @FXML
    private Button voltar;
    int itemID;
    String nomeItem;
    double value = 159;
    Carrinho c = new Carrinho();
    Produto prod = Produto.getInstance();
    public void addList(ActionEvent event) throws IOException {
        itemID = 1;
        nomeItem = "Jaqueta Jeans,tamanho: " + escolheTam.getValue(); ;
        value = 159.99;
      prod.produto(itemID,nomeItem, value);
      c.addValCarrinho(value);
      System.out.println(c.getValCarrinho());
      c.addCarrinho(nomeItem);

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
           FXMLLoader loader = new FXMLLoader(getClass().getResource("Pag_principal"));
           Parent root = loader.load();
           voltar.getScene().getWindow().hide();
           Stage stage = new Stage();
           Scene scene = new Scene(root);
           stage.initStyle(StageStyle.TRANSPARENT);
           stage.setScene(scene);
           stage.show();
       }
   }
    @FXML
    void close(){
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //preco.setText("R$ 159.99");
      //  NomeProduto.setText("Calça Jeans");
        escolheTam.getItems().addAll("36", "38","40","42","44","46");

        escolheTam.setValue("40");
    }
}
