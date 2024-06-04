package com.projetoa3.alpha0001.SQL;

import com.projetoa3.alpha0001.ConnectDb;
import com.projetoa3.alpha0001.Erros;
import com.projetoa3.alpha0001.Usuario.DadosUsuario;


import java.sql.*;
import java.util.ArrayList;

public class SQL {
public static Erros erros = new Erros();
static DadosUsuario dados = DadosUsuario.getInstance();
private static ArrayList cupons = new ArrayList();

    public static void sqlInsert(String username, String estado) {
          PreparedStatement ps;
          String sql = "insert into endereço (idUsuario,cepUsuario,Logradouro,numero,cidade,SiglaEstados) values ((select idUsuario from usuario where idUsuario = ?),(select cepUsuario from usuario where idUsuario = ?),'não definido',00,'não definido',?) ";
          try {
            ps = ConnectDb.getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, username);
            ps.setString(3, estado);
            ps.executeUpdate();
            ps.close();
            System.out.println("Inserido com sucesso");
        } catch (SQLException e) {throw new RuntimeException(e);}
    }

    public static boolean sqlCadastro(String nome,String email, String senha,String cep ) throws SQLException {
            String sql = "select * from usuario where idUsuario ";

            Statement stmt = ConnectDb.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            stmt = ConnectDb.getConnection().createStatement();
            sql = "insert into usuario (nomeUsuario,emailUsuario,senhaUsuario,cepUsuario) values (?,?,?,?)";
            PreparedStatement ps;
          try {
            ps = ConnectDb.getConnection().prepareStatement(sql);

           ((PreparedStatement) ps).setString(1, nome);
           ((PreparedStatement) ps).setString(2, email);
           ((PreparedStatement) ps).setString(3, senha);
           ((PreparedStatement) ps).setString(4, cep);

            ps.executeUpdate();
            ps.close();
            System.out.println("Cadastro concluido com sucesso");
            return true;
        } catch (SQLException e) {throw new RuntimeException(e);}
    }

    public static boolean sqlDados(String usuario, String senha) throws SQLException
    {
        try {
            String sql = "select * from usuario where emailUsuario=? and senhaUsuario=?";

            PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);

            statement.setString(1, usuario);
            statement.setString(2, senha);
            ResultSet rs = statement.executeQuery();

            String senhaT = null;
            String email = null;
            while (rs.next()) {
                email = rs.getString("emailUsuario");
                senhaT = rs.getString("senhaUsuario");
            }

            if (email.equals(usuario) && senhaT.equals(senha)) {
            return true;
            }   else {
                rs.close();
                statement.close();
                erros.erroLogin();
                return false; }
        }catch (SQLException e) {erros.erroLogin();}
        return false;
    }

    public static String sqlNome(String nome) throws SQLException {
        String sql = "SELECT nomeUsuario  from usuario WHERE emailUsuario = ?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);

        statement.setString(1,nome);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {nome =  rs.getString("nomeUsuario");}
        rs.close();
        statement.close();
        return nome;
    }

    public static String sqlEmail(String email) throws SQLException {
        String sql = "SELECT emailUsuario from usuario WHERE emailUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1, email);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {email = rs.getString("emailUsuario");}
        rs.close();
        statement.close();
        return email;
    }

    public static String sqlSenha(String senha) throws SQLException {
        String sql = "SELECT senhaUsuario from usuario WHERE emailUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1, senha);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {senha = rs.getString("senhaUsuario");}
        rs.close();
        statement.close();
        return senha;
    }
    public static String sqlCEP(String cep) throws SQLException {
        String sql = "SELECT cepUsuario from usuario WHERE emailUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1, cep);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {cep = rs.getString("cepUsuario");}
        rs.close();
        statement.close();
        return cep;
    }
    public static String sqlTEL(String tel) throws SQLException{
        if (tel != null){
            String sql = "SELECT telefoneUsuario from usuario WHERE emailUsuario=?";
            PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
            statement.setString(1, tel);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {tel = rs.getString("telefoneUsuario");}
            rs.close();
            statement.close();
            return tel;
        }
        else {return tel = "000000";}
    }
    public static String sqlGetID(String idUsuario) throws SQLException{
        String sql = "SELECT idUsuario from usuario WHERE emailUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1, idUsuario);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {idUsuario = rs.getString("idUsuario");}
        rs.close();
        statement.close();
        return idUsuario;
    }

    public static String sqlgetCredit(String credito)throws SQLException {
        String sql = "SELECT creditoUsuario from usuario WHERE emailUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1, credito);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {credito = rs.getString("creditoUsuario");
        }
        System.out.println(credito);
        rs.close();
        statement.close();
        return credito;
    }

    public static boolean sqlUpdateEmail(String email) throws SQLException {
        String sql = "update usuario set emailUsuario=? where idUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1,sqlEmail(email));
        statement.setString(2,sqlGetID(dados.getIdUsuario()));
        statement.executeUpdate();
        statement.close();
        return true;
    }
    public static boolean sqlUpdateSenha(String senha) throws SQLException {
        String sql = "update usuario set senhaUsuario=? where idUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1,sqlEmail(senha));
        statement.setString(2,sqlGetID(dados.getIdUsuario()));
        statement.executeUpdate();
        statement.close();
        return true;
    }
    public static boolean sqlUpdateTel(String telefone) throws SQLException {
        String sql = "update usuario set telefoneUsuario=? where idUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1,sqlEmail(telefone));
        statement.setString(2,sqlGetID(dados.getIdUsuario()));
        statement.executeUpdate();
        statement.close();
        return true;
    }

    public static boolean sqlUpdateCEP(String CEP) throws SQLException {
        String sql = "update usuario set cepUsuario=? where idUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1,sqlEmail(CEP));
        statement.setString(2,sqlGetID(dados.getIdUsuario()));
        statement.executeUpdate();
        statement.close();
        return true;
    }

    public static boolean sqlUpdateCidade(String cidade)throws SQLException{
        String sql = "update endereço set cidade=? where idUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1,cidade);
        statement.setString(2,sqlGetID(dados.getIdUsuario()));
        statement.executeUpdate();
        statement.close();
        return true;
    }
    public static boolean sqlUpdateLog(String logradouro)throws SQLException{
        String sql = "update endereço set Logradouro=? where idUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1,logradouro);
        statement.setString(2,sqlGetID(dados.getIdUsuario()));
        statement.executeUpdate();
        statement.close();
        return true;
    }
    public static boolean sqlUpdateNumero(String numero)throws SQLException{
        String sql = "update endereço set numero=? where idUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1, String.valueOf(numero));
        statement.setString(2,sqlGetID(dados.getIdUsuario()));
        statement.executeUpdate();
        statement.close();
        return true;
    }

    public static String sqlGetlogradouro(String logradouro) throws SQLException {
        String sql = "SELECT Logradouro from endereço WHERE idUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1, logradouro);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {logradouro = rs.getString("Logradouro");}
        rs.close();
        statement.close();
        return logradouro;
    }
    public static String sqlGetnumero(String numero) throws SQLException {
        String sql = "SELECT numero from endereço WHERE idUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1, numero);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {numero = rs.getString("numero");}
        rs.close();
        statement.close();
        return numero;
    }
    public static String sqlGetEstado(String estado) throws SQLException {
        String sql = "SELECT SiglaEstados from endereço WHERE idUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1, estado);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {estado = rs.getString("SiglaEstados");}
        rs.close();
        statement.close();
        if(estado == null){return estado = "não definido";}
        return estado;
    }
    public static String sqlGetCidade(String cidade) throws SQLException {
        String sql = "SELECT cidade from endereço WHERE idUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1, cidade);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {cidade = rs.getString("cidade");}
        rs.close();
        statement.close();
        return cidade;
    }

    public static void sqlInsertCredito(double res, String usuario) throws SQLException {
       String sql = "update usuario set creditoUsuario=? where idUsuario=?";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1, String.valueOf(res));
        statement.setString(2,sqlGetID(dados.getIdUsuario()));
        statement.executeUpdate();
        statement.close();

    }
    public static void sqlPedido(String idUsuario, Timestamp horas,String pedido) throws SQLException {
          PreparedStatement ps;
          String sql = "insert into pedidos (DataeHora,CEP,userID,Estado,cidade,numero,Logradouro,descricaoPedido) values (?,(select cepUsuario from endereço where idUsuario = ?),(select idUsuario from usuario where idUsuario = ?),(select SiglaEstados from endereço where idUsuario = ?),(select cidade from endereço where idUsuario = ?),(select numero from endereço where idUsuario = ?),(select Logradouro from endereço where idUsuario = ?),?) ";
          try {
            ps = ConnectDb.getConnection().prepareStatement(sql);
            ps.setTimestamp(1, horas);
            ps.setString(2, idUsuario);
            ps.setString(3, idUsuario);
            ps.setString(4, idUsuario);
            ps.setString(5, idUsuario);
            ps.setString(6, idUsuario);
            ps.setString(7, idUsuario);
            ps.setString(8, pedido);

            ps.executeUpdate();
            ps.close();
            System.out.println("Inserido com sucesso");
        } catch (SQLException e) {throw new RuntimeException(e);}

    }

    public static void sqlInsertCupom(String usuario,String cod)throws SQLException{
          PreparedStatement ps;
          String sql = "insert into cupons (Cupom,idUsuario) values (?,(select idUsuario from usuario where idUsuario = ?)) ";
          try {
            ps = ConnectDb.getConnection().prepareStatement(sql);
            ps.setString(1, cod);
            ps.setString(2, usuario);

            ps.executeUpdate();
            ps.close();
            System.out.println("Inserido com sucesso");
        } catch (SQLException e) {throw new RuntimeException(e);}
    }

    public static ArrayList sqlgetCupom(String idUsuario) throws SQLException{
        String sql = "SELECT Cupom from cupons WHERE idUsuario=?";
        String Cupom = "";
        PreparedStatement statement = ConnectDb.getConnection().prepareStatement(sql);
        statement.setString(1,idUsuario );
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {Cupom = rs.getString("Cupom");
              cupons.add(Cupom);
        }
        rs.close();
        statement.close();
        return cupons;
    }
    public static void sqlECOCOINS(String usuario)throws SQLException{
          PreparedStatement ps;
          String sql = "insert into usuario (creditoUsuario) value (10000) ";
          try {
            ps = ConnectDb.getConnection().prepareStatement(sql);
            ps.setString(1, usuario);

            ps.executeUpdate();
            ps.close();
            System.out.println("Inserido com sucesso");
        } catch (SQLException e) {throw new RuntimeException(e);}
    }

    public static void sqlInsertPedido(String pedido){
        PreparedStatement ps;
          String sql = "insert into pedidos (descricaoPedido) value (?) ";
          try {
            ps = ConnectDb.getConnection().prepareStatement(sql);
            ps.setString(1, pedido);

            ps.executeUpdate();
            ps.close();
            System.out.println("Inserido com sucesso");
        } catch (SQLException e) {throw new RuntimeException(e);}
    }

}
