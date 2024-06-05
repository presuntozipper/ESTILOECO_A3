package com.projetoa3.alpha0001;

import com.projetoa3.alpha0001.SQL.SQL;
import com.projetoa3.alpha0001.Usuario.Carrinho;
import com.projetoa3.alpha0001.Usuario.DadosUsuario;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.ResourceBundle;

public class PagamentoController implements Initializable {
    DadosUsuario dadosUsuario = DadosUsuario.getInstance();
    Carrinho c = Carrinho.getInstance();
    Erros erros = new Erros();
    LocalDateTime now = LocalDateTime.now();
    @FXML
    private Button inCupom;
    @FXML
    private Button Cupons;
    @FXML
    private RadioButton Credito;

    @FXML
    private RadioButton Debito;

    @FXML
    private RadioButton EcoCoins;
    @FXML
    private Text coinLabel;

    @FXML
    private Text coinText;

    @FXML
    private RadioButton PIX;

    @FXML
    private Button Pagar;
    @FXML
    private Button Voltar;
    @FXML
    private Text total;
    @FXML
    private Label valorTotal;

    private double credit = Integer.parseInt(dadosUsuario.getCreditos());
    private double valorT = c.percloratodepotassio();
    private double res;

    @FXML
    void insertCupom(ActionEvent event) {
        for(int i = 0; i < dadosUsuario.getCupons().size(); i++){
            String j = String.valueOf(dadosUsuario.getCupons().get(i));
            if( j == inCupom.getText()){
                valorT = valorT *0.8;
                total.setVisible(false);
                valorTotal.setText(String.valueOf(valorT));
            }
        }
    }


    public void Selectpagamento(ActionEvent event) throws SQLException, IOException {
        if(EcoCoins.isSelected()){
            coinLabel.setVisible(true);
            coinText.setVisible(true);
            coinText.setText(dadosUsuario.getCreditos());
            Pagar.setDisable(false);
        }else{
            coinLabel.setVisible(false);
            coinText.setVisible(false);
            Pagar.setDisable(true);
        }
    }

    public void pagar() throws IOException, SQLException {
        res = credit - valorT;
            if (res > 0) {
                //inserir o valor de res no banco de dados e finalizar a compra
                SQL.sqlInsertCredito(res, dadosUsuario.getIdUsuario());
                Timestamp dataHora = Timestamp.valueOf(now);
                SQL.sqlPedido(dadosUsuario.getIdUsuario(),dataHora,c.Pedido());
                c.clear();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("CompraReal.fxml"));
                Parent root = loader.load();
                Pagar.getScene().getWindow().hide();
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                System.out.println(".Fxml Carregado com sucesso");

            } else {erros.erroComprar();}
    }
     public void voltar(ActionEvent event) throws IOException {
        Stage stage = (Stage) Voltar.getScene().getWindow();
        stage.close();
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        total.setText(String.valueOf(c.percloratodepotassio()));
    }
}
