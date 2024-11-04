package model.users;

import model.conta.ContaCorrente;

public class UserController {
    public String getUsuarioNome(User usuario){
        return usuario.nome;
    }

    public int getUsuarioId(User usuario){
        return usuario.id;
    }

    public String getIdentificador(User usuario){
        return usuario.identificador;
    }
}
