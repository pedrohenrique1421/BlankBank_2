package model.users;

public class User {
    protected int id = 0;
    protected String nome = "", identificador = "";

    public User(int id, String nome, String identificador){
        this.id = id;
        this.nome = nome;
        this.identificador = identificador;
    }
}
