package model.conta;

import model.users.User;

import java.util.Date;
import java.util.Random;

public class Conta {
    Random random = new Random();

    protected String agencia;
    protected float saldo;
    private String senha = "", senhaAnterior = senha;
    protected User usuario;
    protected Date dataCriacao;

    public Conta(String agencia, float saldo,User usuario, String senha, String senhaAnterior, Date dataCriacao){
        this.agencia = agencia;
        this.saldo = saldo;
        this.usuario = usuario;
        this.dataCriacao = dataCriacao;

        definirSenha(senha, senhaAnterior);
    }

    protected boolean definirSenha(String novaSenha, String senhaAnterior){
        if (this.senha.equals(this.senhaAnterior)){
            this.senha = novaSenha;
            return true;
        } else if (this.senhaAnterior.equals(senhaAnterior)){
            this.senha = novaSenha;
            return true;
        } else {
            return false;
        }
    }

    protected boolean verificarSenha(String senhaAVerificar){
        return this.senha.equals(senhaAVerificar);
    }
}
