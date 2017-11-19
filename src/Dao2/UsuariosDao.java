package Dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Classes.*;
import javax.swing.JOptionPane;

public class UsuariosDao {
    
    ArrayList<Usuarios> dadosUsuarioDao = new ArrayList<Usuarios>();

    Usuarios usuarios = new Usuarios();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void UsuarioDao() {

    }

    public boolean validaUsuarioDao(String login, String Senha) {
        boolean check = false;
        
        try {
            conn = ConexaoBD1.getConnection();
            ps = conn.prepareStatement("select * from usuarios where login =? and senha =?");

            ps.setString(1, login);
            ps.setString(2, Senha);

            rs = ps.executeQuery();

            if(rs.next()) {
                check = true;
            }

            ps.execute();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return check;
    }
    
    public void cadastroUsuarioDAO (ArrayList<Usuarios> dadosUsuarioFac){
       try {
            conn = ConexaoBD1.getConnection();
            ps = conn.prepareStatement("insert into usuarios (nome, login, senha, dataNascimento) values(?,?,?,?)");
            
            
            for (Usuarios u: dadosUsuarioFac){
                ps.setString(1, u.getNome());
                ps.setString(2, u.getLogin());
                ps.setString(3, u.getSenha());
                ps.setString(4, u.getDataNascimento());

            }
            
            
           
            ps.execute();
            JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso!");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        
    } 
    
    public ArrayList<Usuarios> listarUsuariosDao(){
        
        try {
            conn = ConexaoBD1.getConnection();
            ps = conn.prepareStatement("select matricula, nome, login, dataNascimento from usuarios");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                usuarios = new Usuarios();
                usuarios.setMatricula(rs.getInt("matricula"));
                usuarios.setNome(rs.getString("nome"));
                usuarios.setLogin(rs.getString("login"));
                usuarios.setDataNascimento(rs.getString("dataNascimento"));
                
                dadosUsuarioDao.add(usuarios);
                
                
            }
            
            ps.execute();
            
           
            
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            try{
               if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
 
                
            }catch(Exception e){
                System.err.println(e);
            }
        }
        
        return dadosUsuarioDao;
    }
    
    public void limparUsuariosDAO(){
           try {
            conn = ConexaoBD1.getConnection();
            ps = conn.prepareStatement("delete from usuarios where matricula != 1");
            
        
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Tabela de Usuários limpa!!");
           
            
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            try{
               if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
 
                
            }catch(Exception e){
                System.err.println(e);
            }
        }
        
        
    
    }
}
