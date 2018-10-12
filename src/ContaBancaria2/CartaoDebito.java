package ContaBancaria2;

public class CartaoDebito extends  Cartao{
    CartaoDebito(String numero, String Conta){
        this.conta = conta;
        this.numero = numero;
        System.out.println("cartao de debito criado com sucesso");
    }
}
