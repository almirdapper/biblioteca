
package Dao2;
import java.util.*;
import Factory.LivroFac;
import Classes.Livros;
import Classes.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class LivroDao {
   ArrayList<Livros> dadosLivrosDao = new ArrayList<Livros>();
   Livros livros = new Livros();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
 
    public void LivroDao (){
        
    }
    
    public void cadastrarLivroDao(ArrayList<Livros> dadosLivroFac){
         try {
            conn = ConexaoBD1.getConnection();
            ps = conn.prepareStatement("insert into livros (titulo, autores, genero, ano, disponivel) values(?,?,?,?,?)");
            
            
            for (Livros l: dadosLivroFac){
                ps.setString(1, l.getTitulo());
                ps.setString(2, l.getAutores());
                ps.setString(3, l.getGenero());
                ps.setString(4, l.getAno());
                ps.setString(5, l.getDisponivel());

            }
            
            
           
            ps.execute();
            JOptionPane.showMessageDialog(null, "Livro Cadastrado com Sucesso!");
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
    
    public ArrayList<Livros> listarLivrosDao(){
        
        try {
            conn = ConexaoBD1.getConnection();
            ps = conn.prepareStatement("select id,titulo,autores,genero,ano,disponivel from livros");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                livros = new Livros();
                livros.setId(rs.getInt("id"));
                livros.setTitulo(rs.getString("titulo"));
                livros.setAutores(rs.getString("autores"));
                livros.setGenero(rs.getString("genero"));
                livros.setAno(rs.getString("ano"));
                livros.setDisponivel(rs.getString("disponivel"));
                
                dadosLivrosDao.add(livros);
                
                
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
        
        return dadosLivrosDao;
    }
    
     public void limparLivrosDAO(){
           try {
            conn = ConexaoBD1.getConnection();
            ps = conn.prepareStatement("truncate livros");
            
        
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Tabela de Livros limpa!!");
           
            
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
