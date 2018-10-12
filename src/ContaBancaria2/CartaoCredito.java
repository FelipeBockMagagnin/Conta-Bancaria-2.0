package ContaBancaria2;

public class CartaoCredito extends  Cartao {

    public double limite;
    public double taxaJuros;
    public double valorGasto;


    CartaoCredito(String numero, String conta){
        this.numero = numero;
        this.conta = conta;
        this.limite = 1000;
        this.taxaJuros = 0.05;
        this.valorGasto = 0;
        System.out.println("Cartão de credito criado com sucesso");
    }
}
