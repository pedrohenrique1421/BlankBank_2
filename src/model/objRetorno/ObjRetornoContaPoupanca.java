package model.objRetorno;

import model.users.User;

public class ObjRetornoContaPoupanca {
    public int id;
    public String agencia, dataManutencao, dataCriacao;
    public float saldo;
    public User usuario;

    public ObjRetornoContaPoupanca(int id, String agencia, float saldo, User usuario, String dataCriacao){
        this.id = id;
        this.agencia = agencia;
        this.dataCriacao = dataCriacao;
        this.saldo = saldo;
        this.usuario = usuario;
    }
}
