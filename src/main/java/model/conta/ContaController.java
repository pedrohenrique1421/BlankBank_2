package model.conta;

import model.objRetorno.ObjRetornoContaCorrente;
import model.objRetorno.ObjRetornoContaPoupanca;
import model.users.User;

public class ContaController {
    public User getUsuarioConta(Conta conta){
        return conta.usuario;
    }

    public String getTipoConta(Conta conta){
        if(conta instanceof ContaCorrente){
            return "corrente";
        } else {
            return "poupanca";
        }
    }

    public boolean verificarSenhaConta(Conta conta, String senha){
        return conta.verificarSenha(senha);
    }

    public float getSaldo(Conta conta, String senha){
        if (conta.verificarSenha(senha)){
            return conta.saldo;
        }
        return -1;
    }

    public boolean retirarValor(Conta conta, String senha, float valor){
        if (conta.verificarSenha(senha) && conta.saldo > valor){
            conta.saldo = conta.saldo - valor;
            return true;
        }
        return false;
    }

    public boolean depositarValor(Conta conta, float valor){
            conta.saldo = conta.saldo + valor;
            return true;
    }

    public boolean mudarId(Conta conta, int newId){
        //conta.id = newId;
        return true;
    }

    public int getId(Conta conta){
        //Integrar com banco de dados
        return 0;
    }
}
