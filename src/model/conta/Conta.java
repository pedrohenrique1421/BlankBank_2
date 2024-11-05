package model.conta;

import model.users.User;

import java.util.Date;
import java.util.Random;

public class Conta {
    Random random = new Random();

    protected int id;
    protected String agencia;
    protected float saldo;
    private int senha = random.nextInt(1111111, 9999999), senhaAnterior = senha;
    protected User usuario;
    protected Date dataCriacao;

    public Conta(int id, String agencia, float saldo,User usuario, int senha, int senhaAnterior, Date dataCriacao){
        this.agencia = agencia;
        this.saldo = saldo;
        this.id = id;
        this.usuario = usuario;
        this.dataCriacao = dataCriacao;

        definirSenha(senha, senhaAnterior);
    }

    protected boolean definirSenha(int novaSenha, int senhaAnterior){
        if (this.senha == this.senhaAnterior){
            this.senha = novaSenha;
            return true;
        } else if (this.senhaAnterior == senhaAnterior){
            this.senha = novaSenha;
            return true;
        } else {
            return false;
        }
    }

    protected boolean verificarSenha(int senhaAVerificar){
        return this.senha == senhaAVerificar;
    }
}
