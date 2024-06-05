package com.projetoa3.alpha0001.Usuario;

import com.projetoa3.alpha0001.SQL.SQL;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

import static com.projetoa3.alpha0001.SQL.SQL.*;

public class DadosUsuario {
    private static final DadosUsuario instance = new DadosUsuario();
    private String email;
    private String usuario;
    private String senha;
    private String CEP;
    private String telefone;
    private String idUsuario;
    private String cidade;
    private String Logradouro;
    private String numero;
    private String estado;
    private String codigo;
    private  ArrayList<String> cupons = new ArrayList();
    private String temp;
    private String creditos;
    private DadosUsuario() {}
    public static DadosUsuario getInstance() {
            return instance;
        }

    public  void setCredit(String credit) throws SQLException {
        creditos = SQL.sqlgetCredit(credit);
    }

    public String getCreditos() {
        return creditos;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) throws SQLException {
       this.usuario= SQL.sqlNome(usuario);

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws SQLException {
        email = SQL.sqlEmail(email);
        this.email = email;
    }

    public String getSenha() throws SQLException {
        return senha;
    }

    public void setSenha(String senha) throws SQLException {
        senha = SQL.sqlSenha(senha);
        this.senha = senha;
    }

    public String getCEP() throws SQLException {
        return CEP;
    }

    public void setCEP(String CEP) throws SQLException {
        CEP = SQL.sqlCEP(CEP);
        this.CEP = CEP;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws SQLException {
        telefone = SQL.sqlTEL(telefone);
        this.telefone = telefone;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) throws SQLException {
        idUsuario = sqlGetID(idUsuario);
        this.idUsuario = idUsuario;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws SQLException {
        String userID = SQL.sqlGetID(cidade);
        cidade = sqlGetCidade(cidade);
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String logradouro) throws SQLException {
        logradouro = sqlGetlogradouro(logradouro);
        Logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws SQLException {
        numero = SQL.sqlGetnumero(numero);
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) throws SQLException {
        estado = SQL.sqlGetEstado(estado);
        this.estado = estado;
    }

    public void setCupons(String idUsuario) throws SQLException {
        cupons.addAll(SQL.sqlgetCupom(idUsuario));
    }

    public  ArrayList getCupons(){
        return cupons ;
    }

}
