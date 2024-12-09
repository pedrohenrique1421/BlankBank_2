package model.users;

public class UserController {
    public String getUsuarioNome(User usuario){
        return usuario.nome;
    }

    public int getUsuarioId(User usuario){
        return usuario.idLocal;
    }

    public String getIdentificador(User usuario){
        return usuario.identificador;
    }
}
