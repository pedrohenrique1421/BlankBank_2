package model.conta;

import factory.ContaFactory;
import jakarta.persistence.EntityManager;
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
        if(conta instanceof ContaPoupanca){
            return ((ContaPoupanca) conta).senha.equals(senha);
        } else if(conta instanceof ContaCorrente){
            return ((ContaCorrente) conta).senha.equals(senha);
        }
        return false;
    }

    public float getSaldo(Conta conta, String senha){
        if (verificarSenhaConta(conta, senha)){
            return conta.saldo;
        }
        return -1;
    }

    public void somarSaldo(Conta conta, float valor){
        conta.saldo += valor;
    }

    public boolean retirarValor(Conta conta, String senha, float valor){
        if (verificarSenhaConta(conta, senha) && conta.saldo > valor){
            conta.saldo = conta.saldo - valor;
            return true;
        }
        return false;
    }

    public boolean mudarId(Conta conta, int newId){
        //conta.id = newId;
        return true;
    }

    public int getId(Conta conta){
        if (conta instanceof ContaCorrente) {
            return ((ContaCorrente) conta).id;// Retorna o id de ContaCorrente
        } else if(conta instanceof ContaPoupanca) {
            return ((ContaPoupanca) conta).id;  // Retorna o id de ContaPoupanca
        }
        return -1;
    }

}
