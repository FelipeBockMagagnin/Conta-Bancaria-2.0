package ContaBancaria2;

public class PessoaJuridica extends Cliente {
    private String cnpj;

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
}
