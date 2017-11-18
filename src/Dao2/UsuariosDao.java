package Dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Classes.*;

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
}
