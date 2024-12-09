package model.conta;

import model.users.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "CorrenteConta :/")

public class ContaCorrente extends Conta{
    @Id
    private int id;
    protected Date dataManutencao;
    protected final String tipo = "Corrente";

    public ContaCorrente(int id, String agencia, float saldo, Date dataManutencao, User usuario, String senha, String senhaAnterior, Date dataCriacao){
        super(id, agencia, saldo, usuario,  senha, senhaAnterior, dataCriacao);
        this.dataManutencao = dataManutencao;
    }

}
