package com.projetoa3.alpha0001.Usuario;

import java.util.ArrayList;

public class Carrinho{
    private static final Carrinho instance = new Carrinho();
    private static final ArrayList<String> carrinho = new ArrayList<>();
    private static double valCarrinho = 0;
    private static final ArrayList<Double> valores = new ArrayList<>();
    private double itemCarrinho = 0;
    public static Carrinho getInstance(){
        return instance;
    }

    public Carrinho() {
    }
    public double percloratodepotassio(){
        itemCarrinho = 0;
        for(int i = 0; i < valores.size(); i++){
            itemCarrinho +=valores.get(i);
            System.out.println(itemCarrinho);
        }
        System.out.println(" valor total alright "+itemCarrinho);
        return itemCarrinho;
    }
    public void brometo(int i){
        for( i = 0; i < carrinho.size(); i++){
            carrinho.remove(i);
        }
    }
    public void francio(int i){
        for( i = 0; i < carrinho.size(); i++){
            valores.remove(i);
        }
    }

    public ArrayList<String> getCarrinho() {
        return carrinho;
    }
    public void addValCarrinho(double item){
         valores.add(item);
         valCarrinho += item;
    }

    public double getValCarrinho(){
        return valCarrinho;
    }
    public ArrayList<Double> getValores(){
        return valores;
    }

    public void  addCarrinho(String item) {
        carrinho.add(item);
        System.out.println("Carrinho adicionado com sucesso! " + valCarrinho);
    }

   public void clear(){
        carrinho.clear();
        valores.clear();
   }


}
