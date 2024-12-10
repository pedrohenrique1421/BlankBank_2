package model.conta;

import jakarta.persistence.*;
import model.users.User;
import java.util.Date;

@Entity
@Table(name = "ContaPoupanca")
public class ContaPoupanca extends Conta {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "dataManutencao")
    protected Date dataManutencao;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id") // Nome da chave estrangeira na tabela
    private User user;

    @Column(name = "saldo")
    protected float saldo;

    @Column(name = "senha")
    protected String senha = "";

    @Column(name = "tipo")
    protected final String tipo = "Poupanca";

    // Construtor sem parâmetros
    public ContaPoupanca() {
        super("", 0.0f, null, new Date()); // ou um valor adequado para sua lógica
    }

    // Construtor com parâmetros
    public ContaPoupanca(String agencia, float saldo, User usuario, String senha, Date dataCriacao) {
        super(agencia, saldo, usuario, dataCriacao); // Chama o construtor da classe pai (Conta)
        this.dataManutencao = new Date(); // Atribuindo valor default
        this.user = usuario;
        this.senha = senha;
    }

    public User getUsuario() {
        return user;
    }

    public boolean verificarSenha(String senhaAVerificar){
        return this.senha.equals(senhaAVerificar);
    }
}
