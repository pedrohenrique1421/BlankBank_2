package model.conta;


import model.users.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ContaPoupanca extends Conta{
    @Id
    private int id;
    protected double limiteDeSaque = 2000.00, jurosAM = 0.07;
    protected final String tipo = "Poupanca";

    public ContaPoupanca (int id, String agencia, float saldo, User usuario, String senha, String senhaAnterior, Date dataCriacao){
        super(id, agencia, saldo, usuario,  senha, senhaAnterior, dataCriacao);
    }
}
