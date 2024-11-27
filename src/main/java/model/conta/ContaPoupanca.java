package model.conta;

import model.users.User;

import java.util.Date;

public class ContaPoupanca extends Conta{
    protected double limiteDeSaque = 2000.00, jurosAM = 0.07;
    protected final String tipo = "Poupanca";

    public ContaPoupanca (int id, String agencia, float saldo, User usuario, String senha, String senhaAnterior, Date dataCriacao){
        super(id, agencia, saldo, usuario,  senha, senhaAnterior, dataCriacao);
    }
}
