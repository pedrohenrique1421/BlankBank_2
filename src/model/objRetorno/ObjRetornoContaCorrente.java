package model.objRetorno;

import model.users.User;

public class ObjRetornoContaCorrente {
    public int id = 0;
    public String agencia = null, dataManutencao = null, dataCriacao = null;
    public float saldo = 0;
    public User usuario;

    public ObjRetornoContaCorrente(int id, String agencia, float saldo, String dataManutencao, User usuario, String dataCriacao){
        this.id = id;
        this.agencia = agencia;
        this.dataManutencao = dataManutencao;
        this.dataCriacao = dataCriacao;
        this.saldo = saldo;
        this.usuario = usuario;
    }
}