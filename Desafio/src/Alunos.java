/**
 *
 * @author Leo
 */
public class Alunos {
    private int Matricula;
    private String Nome;
    private Sala Sal;

    public Alunos(){
}

    public Alunos(int Matricula, String Nome) {
        this.Matricula = Matricula;
        this.Nome = Nome;
    }

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int Matricula) {
        this.Matricula = Matricula;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Sala getSal() {
        return Sal;
    }

    public void setSal(Sala Sal) {
        this.Sal = Sal;
    }


}
