package model.conta;

import model.users.User;

public class ContaPoupanca extends Conta{
    protected double limiteDeSaque = 2000.00, jurosAM = 0.07;
    protected final String tipo = "Poupanca";

    public ContaPoupanca (int id, String agencia, float saldo, User usuario, int senha, int senhaAnterior, String dataCriacao){
        super(id, agencia, saldo, usuario,  senha, senhaAnterior, dataCriacao);
    }
}
