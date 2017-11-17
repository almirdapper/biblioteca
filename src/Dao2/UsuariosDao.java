package Dao2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Classes.*;


public class UsuariosDao {
    ArrayList<Usuarios>dadosUsuarioDao = new ArrayList<Usuarios>();
    Usuarios usuarios = new Usuarios();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void UsuarioDao(){
        
        
    }

    public ArrayList validaUsuarioDao (ArrayList dadosUsuarios){
     try {
            dadosUsuarioDao = dadosUsuarios;
            String login;
            String Senha;
            
           
            
            conn = ConexaoBD1.getConnection();
            ps = conn.prepareStatement("select login,\n" +
"                                      senha\n" +
"                                     from login where login =? and senha =?");
            
            
             for(Usuarios u : dadosUsuarioDao){
                ps.setString(1, u.getLogin());               
                ps.setString(2, u.getSenha());
            }
             
            rs = ps.executeQuery();
            
            while (rs.next()) {
                usuarios.setLogin(rs.getString("login"));
                 usuarios.setSenha(rs.getString("senha"));
                 dadosUsuarioDao.add(usuarios);
                
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
        
     
    
        
        return dadosUsuarioDao;
    }
}
