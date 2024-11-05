package model.objRetorno;

import model.users.User;

import java.util.Date;

public class ObjRetornoContaPoupanca {
    public int id;
    public String agencia;
    public float saldo;
    public User usuario;
    public Date dataCriacao;

    public ObjRetornoContaPoupanca(int id, String agencia, float saldo, User usuario, Date dataCriacao){
        this.id = id;
        this.agencia = agencia;
        this.dataCriacao = dataCriacao;
        this.saldo = saldo;
        this.usuario = usuario;
    }
}
