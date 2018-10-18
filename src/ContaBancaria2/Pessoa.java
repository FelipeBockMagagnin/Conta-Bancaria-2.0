package ContaBancaria2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author darolt
 */
public class Pessoa {
  // atributos
  private String nome;
  public int idade;
  public boolean vivo = true;
  private int IDADE_MAX = 130;

  
    // métodos
    Pessoa(String nomeInicial, int idadeInicial) {
        // idade da pessoa no momento do registro
        idade = idadeInicial;
        nome = nomeInicial;
    }
  
    public void setCpf(String cpf) {
       if(validaCpf(cpf)){
           System.out.println("Cpf valido");
       } else {
           System.out.println("Cpf invalido");
       }
    }
  
  public String getNome(){
      return nome;
  }
  
  public int getIdade() {
    return idade;
  }
  
  private void setIdade(int idade) {
    if (idade > IDADE_MAX) {
      System.out.println("Idade máxima atingida!");
    } else {
      this.idade = idade;
    }
  }
  
  private boolean validaCpf(String cpfTentativa) {
    //verifica se o tamanho do cpf 
    boolean seguirParaVerific = false;
    int numIgual = 0;

    if(cpfTentativa.length() == 11){
        for(int c =0;c<10;c++){            
            if(cpfTentativa.charAt(c) == cpfTentativa.charAt(c+1)){
                numIgual++;
            }
        }
    } else {
        System.out.println("O cpf não possui 11 digitos");
    }   

    //se o cpf tiver todos os numeros igual ele não é valido
    if(numIgual != 10 && cpfTentativa.length() == 11){            
        seguirParaVerific = true;
    }        

    if(seguirParaVerific == true){         
        int testa = 0, multi = 10, verifica1,verifica2; 

        //verificação primeiro digito (verifica1)
        for(int c=0;c < 9;c++){
            testa = testa + Character.getNumericValue(cpfTentativa.charAt(c)) * multi; 
            multi--;
        }   
        verifica1 = testa%11;
        if(verifica1 == 0 || verifica1 == 1){
            verifica1 = 0;
        } else {
            verifica1 = 11 - verifica1;
        }

        //verificação segundo digito (verifica2)
        testa = 0;
        multi = 11;
        for(int c=0;c < 10;c++){
            testa = testa + Character.getNumericValue(cpfTentativa.charAt(c)) * multi; 
            multi--;
        }
        verifica2 = testa%11;
        if(verifica2 == 0 || verifica2 == 1){
            verifica2 = 0;
        } else {
            verifica2 = 11 - verifica2;
        }           

        //verificação final
        if(verifica1 == Character.getNumericValue(cpfTentativa.charAt(9)) && verifica2 == Character.getNumericValue(cpfTentativa.charAt(10))){
            return true;
        } else {
            return false;
        }    
    } else {
        return false;
    }
    }
}
