package desafio;

/**
 *
 * @author victoria
 */
public class Aluno {
    
    protected String nome;
    protected String matricula;
    protected String telefone;
    protected String email;
    protected String uffmail;
    protected String status;
    
    public Aluno(String nome, String matricula, String telefone, String email, String uffmail, String status){
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.email = email;
        this.uffmail = uffmail;
        this.status = status;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getMatricula() {
        return matricula;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getUffmail() {
        return uffmail;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setUffmail(String uffmail) {
        this.uffmail = uffmail;
    }
    
}
