package model.objRetorno;

import model.users.User;

public class ObjRetornoUser {
    public int id = 0;
    public String nome = null, identificador = null;

    public ObjRetornoUser(int id, String nome, String identificador){
        this.id = id;
        this.nome = nome;
        this.identificador = identificador;
    }
}
