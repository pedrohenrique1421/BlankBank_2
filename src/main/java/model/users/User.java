package model.users;


import jakarta.persistence.*;


@Entity
@Table(name="user")
@MappedSuperclass
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nome")
    protected String nome = "";
    @Column(name="identificador")
    protected String identificador = "";

    public User(){

    }

    public User(String nome, String identificador){
        this.nome = nome;
        this.identificador = identificador;
    }
}
