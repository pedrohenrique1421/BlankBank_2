package model.users;


import javax.persistence.*;

@Entity
@Table(name="user")
@MappedSuperclass
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected int idLocal = 0;
    protected String nome = "", identificador = "";

    public User(int idLocal, String nome, String identificador){
        this.idLocal = idLocal;
        this.nome = nome;
        this.identificador = identificador;
    }
}
