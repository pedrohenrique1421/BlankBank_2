package model.objRetorno;

import model.users.User;

import java.util.Date;

public class ObjRetornoContaCorrente {
    public int id = 0;
    public String agencia = null;
    public float saldo = 0;
    public User usuario;
    public Date dataManutencao, dataCriacao;

    public ObjRetornoContaCorrente(int id, String agencia, float saldo, Date dataManutencao, User usuario, Date dataCriacao){
        this.id = id;
        this.agencia = agencia;
        this.dataManutencao = dataManutencao;
        this.dataCriacao = dataCriacao;
        this.saldo = saldo;
        this.usuario = usuario;
    }
}