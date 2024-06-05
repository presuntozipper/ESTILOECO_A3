package com.projetoa3.alpha0001;


import com.projetoa3.alpha0001.Usuario.DadosUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;


public class Pag_principalController  {
     @FXML
    private Button BermudasJeans;
     @FXML
    private Button JaquetaJeans;

    @FXML
    private Button SaiaJeans;
    @FXML
    private Button macacaoJeans;

    @FXML
    private Button shortsJeans;

    @FXML
    private Button close;
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
    private Button Doe;
    @FXML
    private Button calcaJe;
    @FXML
    private ImageView logo;
    @FXML
    private BorderPane mainPane;
    DadosUsuario dadosUsuario = DadosUsuario.getInstance();

    public void calcaJeans() throws IOException {
            calcaJe.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("Pag_prod.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();


    }
     public void saiaJeans() throws IOException {
            SaiaJeans.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("Saia.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
    }
     public void bermudaJeans() throws IOException {
            BermudasJeans.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("Bermuda.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
    }

     public void shortsJeans() throws IOException {
            shortsJeans.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("Shorts.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
    }

     public void JaquetaJeans() throws IOException {
            JaquetaJeans.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("Jaqueta.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
    }

     public void macacoJeans() throws IOException {
            macacaoJeans.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("Macacao.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
    }


   public void conta(ActionEvent event) throws IOException, SQLException {
            dadosUsuario.setPedido(dadosUsuario.getIdUsuario());
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

  public void close()
    {System.exit(0);}
}

