package model.conta;

import model.users.User;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CorrenteConta")
public class ContaCorrente extends Conta {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dataMAnutencao")
    protected Date dataManutencao;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id") // Nome da chave estrangeira na tabela
    private User user;

    @Column(name = "tipo")
    protected final String tipo = "Corrente";

    // Construtor sem parâmetros
    public ContaCorrente() {
        // Chama o construtor da classe pai (Conta) com valores padrão
        super("", 0.0f, null, "", "", new Date()); // Adapte conforme sua lógica
    }

    // Construtor com parâmetros
    public ContaCorrente(String agencia, float saldo, User usuario, String senha, String senhaAnterior, Date dataCriacao) {
        super(agencia, saldo, usuario, senha, senhaAnterior, dataCriacao); // Chama o construtor da classe pai (Conta)
        this.dataManutencao = new Date(); // Atribuindo valor default
        this.user = usuario;
    }

    // Getter e Setter para dataManutencao (se necessário)
    public Date getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(Date dataManutencao) {
        this.dataManutencao = dataManutencao;
    }
}
