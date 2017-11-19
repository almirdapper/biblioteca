
package Factory;
import Dao2.LivroDao;
import java.util.ArrayList;
import Classes.Livros;

public class LivroFac {
    LivroDao livroDao = new LivroDao();
    Livros livros = new Livros();
    ArrayList<Livros>dadosLivroFac = new ArrayList<Livros>();
    
    public LivroFac(){
        
    }
    
    
    public void cadastrarLivroFac(String tirulo, String autor, String genero, String ano, String disponivel){
      livros.setAno(ano);
      livros.setAutores(autor);
      livros.setDisponivel(disponivel);
      livros.setGenero(genero);
      livros.setTitulo(tirulo);
      dadosLivroFac.add(livros);
      livroDao.cadastrarLivroDao(dadosLivroFac);
    }
    
    public ArrayList<Livros> listaLivrosFac (){
        
        dadosLivroFac =livroDao.listarLivrosDao();
        
        return dadosLivroFac;
    }
    
    public void limparLivrosFac(){
        livroDao.limparLivrosDAO();
    }
}

