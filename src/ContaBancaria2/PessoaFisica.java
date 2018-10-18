package ContaBancaria2;

public class PessoaFisica extends Cliente {


    private String cpf;

    PessoaFisica(String Cpf, String nome, int idade){
        this.cpf = Cpf;
        this.nome = nome;
        this.idade = idade;
        System.out.println("pessoa fisica criada com sucesso, nome: " + nome + " idade " + idade);
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
