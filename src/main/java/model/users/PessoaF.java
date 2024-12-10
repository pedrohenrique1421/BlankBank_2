package model.users;

public class PessoaF extends User {
    protected String cpf, dataDeNasc;

    public PessoaF(String nome, String cpf, String dataDeNasc, String identificador){
        super(nome, identificador);
        this.cpf = cpf;
        this.dataDeNasc = dataDeNasc;
    }
}
