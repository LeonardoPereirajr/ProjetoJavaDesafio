
import java.util.ArrayList;

/**
 *
 * @author Leo
 */
public class Sala {
    private int Codigo;
    private String Nome;
    ArrayList<Alunos> ListaAlunos;
    
    public Sala(){
        ListaAlunos =new ArrayList();
    }

    public Sala(int Codigo, String Nome) {
        this.Codigo = Codigo;
        this.Nome = Nome;
        ListaAlunos = new ArrayList();
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public ArrayList<Alunos> getListaAlunos() {
        return ListaAlunos;
    }

    public void setListaAlunos(ArrayList<Alunos> ListaAlunos) {
        this.ListaAlunos = ListaAlunos;
    }
    public void addAluno(Alunos A){
        A.setSal(this);
        ListaAlunos.add(A);
    }
    
}
