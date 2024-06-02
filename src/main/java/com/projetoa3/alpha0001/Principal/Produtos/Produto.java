package com.projetoa3.alpha0001.Principal.Produtos;


import java.util.ArrayList;

public class Produto {
    private static final Produto instance = new Produto();
    private int ID;
    private String nomeItem;
    private double precoItem;
    private ArrayList<Produto> produtos;
    private Produto(){}
    public static Produto getInstance() {return instance; }

    public void produto(int ID, String nomeItem, double precoItem){
      this.ID = ID;
      this.nomeItem = nomeItem;
      this.precoItem = precoItem;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(double precoItem) {
        this.precoItem = precoItem;
    }

}
