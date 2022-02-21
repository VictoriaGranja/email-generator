package desafio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.*;

/**
 *
 * @author victoria
 */
public class Arquivo {
    
    public Aluno lerArquivo(String matricula) {
        String arquivoCSV = "Arquivo\\alunos.csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ",";
        try{
            
            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {
                
                String[] aluno = linha.split(csvDivisor);
                Aluno alu = new Aluno(aluno[0], aluno[1], aluno[2], aluno[3], aluno[4], aluno[5]);
                if((matricula.equals(alu.getMatricula()) && (alu.getStatus().equals("Ativo")))){
                    
                    if((alu.getUffmail().equals(""))){
                       GeraEmail obj = new GeraEmail();
                       List<String> emails = obj.gerador(alu.getNome());
                       obj.geraOpcoes(emails, alu);
                       br.close();
                       return alu;
                       
                    }
                    else{
                        System.out.println("O aluno já possui um uffmail.");
                    }
                }
            
            }
            br.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void modificarArquivo(Aluno aluno) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        File antigo = new File("Arquivo\\alunos.csv");
        File novo = new File ("Arquivo\\auxiliar.csv");
        
        try {
            br = new BufferedReader(new FileReader(antigo));
            bw = new BufferedWriter(new FileWriter(novo));
            PrintWriter pw = new PrintWriter(bw);
            String linha = "";
            String linhaEditada = "";
           
            while ((linha = br.readLine()) != null) {
    
                String[] alu = linha.split(",");
                if (aluno.getMatricula().equals(alu[1])){
                    linhaEditada = aluno.getNome() + "," + aluno.getMatricula() + "," + aluno.getTelefone() + "," +
                    aluno.getEmail() + "," + aluno.getUffmail() + "," + aluno.getStatus();
                    
                    pw.write(linhaEditada);
                    pw.write("\n");
                }else{
                    pw.write(linha);
                    pw.write("\n");
                }
                
            }
            
            pw.flush();  
            pw.close();
            br.close();
            bw.close();
            antigo.delete();
            
            Files.move(novo.toPath(), antigo.toPath());
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
