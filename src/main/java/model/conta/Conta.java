package model.conta;

import model.users.User;

import java.util.Date;
import java.util.Random;

public class Conta {
    Random random = new Random();

    protected String agencia;
    protected float saldo;
    protected User usuario;
    protected Date dataCriacao;

    public Conta(String agencia, float saldo,User usuario, Date dataCriacao){
        this.agencia = agencia;
        this.saldo = saldo;
        this.usuario = usuario;
        this.dataCriacao = dataCriacao;

    }


}
