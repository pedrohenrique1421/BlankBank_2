package model.users;

public class PessoaF extends User {
    protected String cpf, dataDeNasc;

    public PessoaF(int id, String nome, String cpf, String dataDeNasc, String identificador){
        super(id, nome, identificador);
        this.cpf = cpf;
        this.dataDeNasc = dataDeNasc;
    }
}
