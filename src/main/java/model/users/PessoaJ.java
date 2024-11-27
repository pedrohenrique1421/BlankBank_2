package model.users;

public class PessoaJ extends User {
    protected String cnpj, endereco;

    public PessoaJ(int id, String nome, String cnpj, String endereco, String identificador){
        super(id, nome, identificador);
        this.cnpj = cnpj;
        this.endereco = endereco;
    }
}