package com.projetoa3.alpha0001;

import javafx.scene.control.Alert;

public class Erros {
    public void erroEntrada(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Erro");
         alert.setHeaderText(null);
         alert.setContentText("Preencha todos os campos");
         alert.showAndWait();
    }
    public void erroLogin(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Erro");
         alert.setHeaderText(null);
         alert.setContentText("EMAIL OU SENHA INCORRETOS" + "\n" + " Ou Usuario não cadastrado");
         alert.showAndWait();
    }
    public void erroCadastro(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Erro ao cadastrar usuario"+"\n"+"Se persistir contate o suporte");
            alert.showAndWait();
    }
    public void erroFXML(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Erro ao Carregar FXML");
            alert.showAndWait();
    }
    public void erroSenha(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("As senhas devem ser iguais");
            alert.showAndWait();
    }
    public void erroComprar(){
         Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Creditos insuficientes");
            alert.showAndWait();
    }
}
