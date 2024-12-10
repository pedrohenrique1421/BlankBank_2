package model.conta;

import jakarta.persistence.*;
import model.users.User;

import java.util.Date;

@Entity
@Table(name = "ContaPoupanca")
public class ContaPoupanca extends Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dataMAnutencao")
    protected Date dataManutencao;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id") // Nome da chave estrangeira na tabela
    private User user;

    @Column(name = "tipo")
    protected final String tipo = "Poupanca";

    // Construtor sem parâmetros
    public ContaPoupanca() {
        super("", 0.0f, null, "", "", new Date()); // ou um valor adequado para sua lógica
    }

    // Construtor com parâmetros
    public ContaPoupanca(String agencia, float saldo, User usuario, String senha, String senhaAnterior, Date dataCriacao) {
        super(agencia, saldo, usuario, senha, senhaAnterior, dataCriacao); // Chama o construtor da classe pai (Conta)
        this.dataManutencao = new Date(); // Atribuindo valor default ou outro valor
    }

    // Getter e Setter para dataManutencao (se necessário)
    public Date getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(Date dataManutencao) {
        this.dataManutencao = dataManutencao;
    }
}
