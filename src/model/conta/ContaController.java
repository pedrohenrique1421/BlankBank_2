package model.conta;

import model.objRetorno.ObjRetornoContaCorrente;
import model.objRetorno.ObjRetornoContaPoupanca;
import model.users.User;

public class ContaController {
    public User getUsuarioContaCorrente(ContaCorrente conta){
        return conta.usuario;
    }

    public User getUsuarioContaPoupanca(ContaPoupanca conta){
        return conta.usuario;
    }

    public boolean verificarSenhaContaCorrente(ContaCorrente conta, int senha){
        return conta.verificarSenha(senha);
    }

    public boolean verificarSenhaContaPopanca(ContaPoupanca conta, int senha){
        return conta.verificarSenha(senha);
    }

    public ObjRetornoContaCorrente getContaCorrente(ContaCorrente conta){
        return new ObjRetornoContaCorrente(conta.id, conta.agencia, conta.saldo, conta.dataManutencao, conta.usuario, conta.dataCriacao);
    }

    public ObjRetornoContaPoupanca getContaPoupanca(ContaPoupanca conta){
        return new ObjRetornoContaPoupanca(conta.id, conta.agencia, conta.saldo, conta.usuario, conta.dataCriacao);
    }
}
