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

        String nome, cpf, numero;
        int idade, input;
        boolean finalizar = false;


        System.out.print("Digite seu nome: ");
        nome = scan.next();
        System.out.print("Digite sua idade: ");
        idade = scan.nextInt();
        System.out.println("Digite seu numero de telefone: ");
        numero = scan.next();

        //pessoa criada com sucesso
        Pessoa pessoa = new Pessoa(nome, idade);


        System.out.print("Escreva seu cpf (sem caracteres especiais): ");
        cpf = scan.next();

        pessoa.setCpf(cpf);

        ContaBancaria conta = new ContaBancaria(nome, numero, pessoa.getCpf());
        System.out.println("Conta criada com sucesso");
    }
}
