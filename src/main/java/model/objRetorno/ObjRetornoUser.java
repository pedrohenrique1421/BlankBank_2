package model.objRetorno;

import model.users.User;

public class ObjRetornoUser {
    public Long id;
    public String nome = null, identificador = null;

    public ObjRetornoUser(Long id, String nome, String identificador){
        this.id = id;
        this.nome = nome;
        this.identificador = identificador;
    }
}
