package com.projetoa3.alpha0001.Principal.Produtos;

import com.projetoa3.alpha0001.Usuario.DadosUsuario;

import java.util.Random;

public class randomGen {
    public randomGen(){
        DadosUsuario dadosUsuario = DadosUsuario.getInstance();
        Random random = new Random();
        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int valorAleatorio = random.nextInt(36);

            if (valorAleatorio < 10) {

                codigo.append(valorAleatorio);
            } else if (valorAleatorio < 36) {

                codigo.append((char) (valorAleatorio + 65 - 10));
            } else {
                codigo.append((char) (valorAleatorio + 97 - 36 - 10));
            }
        }
        dadosUsuario.setCodigo(codigo.toString());
    }
}
