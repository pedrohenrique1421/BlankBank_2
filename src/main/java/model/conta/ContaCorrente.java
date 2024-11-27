package model.conta;

import model.users.User;

import java.util.Date;

public class ContaCorrente extends Conta{
    protected Date dataManutencao;
    protected final String tipo = "Corrente";

    public ContaCorrente(int id, String agencia, float saldo, Date dataManutencao, User usuario, String senha, String senhaAnterior, Date dataCriacao){
        super(id, agencia, saldo, usuario,  senha, senhaAnterior, dataCriacao);
        this.dataManutencao = dataManutencao;
    }

}
