package Factory;
import Classes.*;
import java.util.ArrayList;
import Dao2.*;
import javax.swing.JOptionPane;

public class UsuarioFac {
  Usuarios usuarios = new Usuarios();
    ArrayList<Usuarios>dadosUsuarios = new ArrayList<Usuarios>();
    ArrayList<Usuarios>dadosUsuarios2 = new ArrayList<Usuarios>();
    UsuariosDao usuariosDao = new UsuariosDao();
  
    public void UsuarioFac(){
        
    }

    public boolean validaUsuario (String login, String senha){
        String log;
        String senh;
        
        usuarios.setLogin(login);
        usuarios.setSenha(senha);
        dadosUsuarios.add(usuarios);
        
        dadosUsuarios2 = usuariosDao.validaUsuarioDao(dadosUsuarios);
        
        for(Usuarios u: dadosUsuarios2){
         log =  u.getLogin();
         senha = u.getSenha();
                 }
        
        
        if (log == null){
          if (senh == null) {
              JOptionPane.showMessageDialog(null, "Usuario Nao cadastrado!!");
          }
        }
        return true;
    }
}
