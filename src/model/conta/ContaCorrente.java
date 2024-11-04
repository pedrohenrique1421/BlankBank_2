package model.conta;

import model.users.User;

public class ContaCorrente extends Conta{
    protected String dataManutencao;
    protected final String tipo = "Corrente";

    public ContaCorrente(int id, String agencia, float saldo, String dataManutencao, User usuario, int senha, int senhaAnterior, String dataCriacao){
        super(id, agencia, saldo, usuario,  senha, senhaAnterior, dataCriacao);
        this.dataManutencao = dataManutencao;
    }

}
