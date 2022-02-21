package desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author victoria
 */
public class GeraEmail {
    
    public List<String> gerador(String nome){
        
        nome = nome.toLowerCase();
        String arroba = "@id.uff.br";
        
        String[] nomeCompleto = nome.split(" ");
        List<String> iniciais = new ArrayList();
        List<String> emails = new ArrayList();
        
        for(String letra : nomeCompleto){
            String inicial = letra.substring(0,1);
            iniciais.add(inicial);
        }
        
        int tamNome; 
        tamNome = nomeCompleto.length - 1;
        int meio = tamNome/2;
        
        emails.add((nomeCompleto[0].concat("_").concat(nomeCompleto[tamNome]).concat(arroba)));
        emails.add((nomeCompleto[0].concat(nomeCompleto[tamNome]).concat(arroba)));
        emails.add((iniciais.get(0).concat(nomeCompleto[tamNome]).concat(arroba)));
        
        if(meio != tamNome){
            emails.add((nomeCompleto[0].concat(iniciais.get(meio)).concat(iniciais.get(tamNome)).concat(arroba)));
            emails.add((iniciais.get(0).concat(nomeCompleto[meio]).concat(nomeCompleto[tamNome]).concat(arroba)));
        }
        
        return emails;
    }
    
    public void geraOpcoes(List<String> emails, Aluno aluno){
        
        int opcao; 
        System.out.println(aluno.getNome() + ", por favor escolha uma das opções abaixo para o seu UFFMail");
        for(int i = 0; i < emails.size(); i++){
            System.out.println((i+1) + " - " + emails.get(i));
        }
        
        Scanner teclado = new Scanner(System.in);
        opcao = teclado.nextInt();
        
        System.out.println("A criação de seu e-mail " + "(" + emails.get(opcao - 1) + ") será feita nos próximos minutos.");
        System.out.println("Um SMS foi enviado para " + aluno.getTelefone() + " com a sua senha de acesso.");
        
        aluno.setUffmail(emails.get(opcao - 1));
    }
    
}
