/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContaBancaria2;


import java.util.ArrayList;

/**
 *
 * @author Felpi
 */
public class ContaBancaria {
    
    private double saldo = 0;
    public  double limiteSaque = 1000;
    private double taxaSaque;
    public Cliente cliente = new Cliente();
    private String numero;

    ArrayList<Cartao> cartao = new ArrayList();
    ArrayList<String> historico = new ArrayList();

    void pagaCartoes(){
        for (Cartao cart:cartao){
            if(cart instanceof CartaoCredito){
                if(saldo > ((CartaoCredito) cart).valorGasto) {
                    modificaSaldo(-((CartaoCredito) cart).valorGasto);
                } else {
                    System.out.println("Não ha saldo suficiente");
                }
            }
        }
    }

    void adicionarCartaoCredito(CartaoCredito cart){
        cartao.add(cart);
        System.out.println("adicionado com sucesso");
    }

    void adicionarCartãoDebito(CartaoDebito cart){
        cartao.add(cart);
        System.out.println("adicionado com sucesso");
    }

    ContaBancaria(String nome, String telefone){
        cliente.nome = nome;
        numero = telefone;
    }

    public void modificaSaldo(double saldo) {
        this.saldo = saldo + this.saldo;
    }

    public String getTelefone(){
        return numero; 
    }


    void paga(Cartao cartaoPgto, ContaBancaria contaPgto, double valor){
        if(cartaoPgto instanceof CartaoDebito){
            contaPgto.modificaSaldo(-valor);
            System.out.println("Pago com cartão de debito");
            this.deposita(valor);

        } else if (cartaoPgto instanceof CartaoCredito) {
            if(((CartaoCredito) cartaoPgto).limite >= ((CartaoCredito) cartaoPgto).valorGasto){
                ((CartaoCredito) cartaoPgto).valorGasto = ((CartaoCredito) cartaoPgto).valorGasto + valor;
                System.out.println("Pago com cartão de credito");
                deposita(valor);
            } else {
                System.out.println("Acima do limite do cartão");
            }
        } else {
            System.out.println("Cartão invalido");
        }
    }
    
    void resumoConta(){
        System.out.println("Nome do Cliente: " + cliente.nome);
        System.out.println("Numero do telefone: " + numero);
        //System.out.println("Cpf do cliente: " + cpfCliente);
    }
    
    void deposita(double valor){
        if(valor <= limiteSaque){
            saldo = saldo + valor;
            System.out.println("Foram depositados " + valor + " reias");
            historico.add("Foram depositados " + valor + " reias");
        } else {
            System.out.println("Não é possivel depositar valor acima de " + limiteSaque);
        }
        modificaTaxaSaque();
    }
    
    void saque(double valor, Cartao cart) {
        modificaTaxaSaque();
        if (cart instanceof CartaoDebito) {
            if (valor <= saldo) {
                this.saldo = saldo - valor;
                System.out.println("Saque de " + valor + " reais realizado com sucesso");
                historico.add("Saque de " + valor + " reais realizado com sucesso");
            } else {
                System.out.println("Saldo insuficiente");
            }
        } else {
            System.out.println("error");
            System.out.println("Voce não pode utilizar um cartão de credito nesssa operação");
        }
    }
    
    void consultaHistorico(){       
        for(String s : historico){
            System.out.println(s);            
        }        
    }
    
    void verSaldo(){
        System.out.println("O saldo é: " + saldo);
    }
    
    void modificaTaxaSaque(){
        if(saldo >= 10000){
            taxaSaque = 4;
        } else if (saldo >= 1000){
            taxaSaque = 3.5;
        } else {
            taxaSaque = 3;
        }
    }    
}
