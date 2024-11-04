package model.conta;

import model.objRetorno.ObjRetornoContaCorrente;
import model.users.User;

public class ContaController {
    public User getUsuario(ContaCorrente conta){
        return conta.usuario;
    }

    public boolean verificarSenha(ContaCorrente conta, int senha){
        return conta.verificarSenha(senha);
    }

    public ObjRetornoContaCorrente getConta(ContaCorrente conta){
        return new ObjRetornoContaCorrente(conta.id, conta.agencia, conta.saldo, conta.dataManutencao, conta.usuario);
    }
}
