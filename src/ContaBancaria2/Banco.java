package ContaBancaria2;





import java.util.Scanner;

/**
 * @author Felpi
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Pessoa pessoa = new Pessoa("Carlos", 18);


        PessoaFisica pesfis = new PessoaFisica("000.000.000-00", "carlos", 18);
        pesfis.setCpf("111.111.111-11");


        ContaBancaria conta = new ContaBancaria("carlos", "3461-2208");

        ContaBancaria conta2 = new ContaBancaria("carlos", "3461-5823");

        CartaoDebito cart = new CartaoDebito("213871928", "shauihdadauhsdi");
        conta.adicionarCartãoDebito(cart);


        CartaoCredito cart2 = new CartaoCredito("414134324", "fwfewffsef");
        conta.adicionarCartaoCredito(cart2);

        conta.paga(cart,conta2,23);
        conta.paga(cart2,conta2,23);

        conta.pagaCartoes();









    }
}
