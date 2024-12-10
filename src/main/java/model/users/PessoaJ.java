package model.users;

public class PessoaJ extends User {
    protected String cnpj, endereco;

    public PessoaJ(String nome, String cnpj, String endereco, String identificador){
        super(nome, identificador);
        this.cnpj = cnpj;
        this.endereco = endereco;
    }
}