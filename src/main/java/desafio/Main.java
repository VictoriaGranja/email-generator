package desafio;

import java.util.Scanner;

/**
 *
 * @author victoria
 */
public class Main {
    
    public static void main(String[] args) {
        
        Arquivo obj = new Arquivo();
        System.out.println("Matrícula: ");
        Scanner teclado = new Scanner(System.in);
        String matricula = teclado.nextLine();
        Aluno aluno = obj.lerArquivo(matricula);
        if(aluno != null){
            obj.modificarArquivo(aluno);
        }
        
    }
    
}
