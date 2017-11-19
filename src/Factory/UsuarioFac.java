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
        boolean check = false;
        
        check = usuariosDao.validaUsuarioDao(login, senha);
        return check;
        
    }
     
     public void cadastroUsuario (String nomeUsuario, String login, String senha, String dataNascimento){
         usuarios.setNome(nomeUsuario);
         usuarios.setLogin(login);
         usuarios.setSenha(senha);
         usuarios.setDataNascimento(dataNascimento);
         dadosUsuarios.add(usuarios);
         usuariosDao.cadastroUsuarioDAO(dadosUsuarios);
         
     }
    
      public ArrayList<Usuarios> listaUsuariosFac (){
        
        dadosUsuarios =usuariosDao.listarUsuariosDao();
        
        return dadosUsuarios;
    }
      
      public void limparUsuariosFac(){
        usuariosDao.limparUsuariosDAO();
    }
      
     
}