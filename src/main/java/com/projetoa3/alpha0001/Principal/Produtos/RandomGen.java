package com.projetoa3.alpha0001.Principal.Produtos;

import java.util.Random;

public class RandomGen {
  private static final RandomGen instance = new RandomGen();
    Random random = new Random();
    StringBuilder codigo = new StringBuilder();

    public static RandomGen getInstance() {return instance;}

    public RandomGen() {}

    public  StringBuilder genCode(){
        for (int i = 0; i < 8; i++) {
            int valorAleatorio = random.nextInt(36);

            if (valorAleatorio < 10) {

                this.codigo.append(valorAleatorio);
            } else if (valorAleatorio < 36) {

                this.codigo.append((char) (valorAleatorio + 65 - 10));
            } else {
                this.codigo.append((char) (valorAleatorio + 97 - 36 - 10));
            }
        }


        return codigo;
    }
}
