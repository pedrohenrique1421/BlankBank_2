package model.users;

public class UserController {
    public String getUsuarioNome(User usuario){
        return usuario.nome;
    }

    public int getUsuarioId(User usuario){
        System.out.println("- Error no getUsuario Id, falta integrar com o banco de dados -");
        return 0;
    }

    public String getIdentificador(User usuario){
        return usuario.identificador;
    }
}
