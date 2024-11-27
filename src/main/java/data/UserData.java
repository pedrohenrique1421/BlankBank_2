package data;

import model.conta.ContaCorrente;
import model.objRetorno.ObjRetornoContaCorrente;
import model.objRetorno.ObjRetornoUser;
import model.users.User;
import model.users.UserController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserData {
    private final List<User> USERS = new ArrayList<>();
    private List<Integer> ids = new ArrayList<>();
    Random random = new Random();
    UserController userController = new UserController();

    private boolean verificarId(int id){
        if(ids.size() > 0){
            for (int i = 0; i < ids.size(); i++) {
                if (ids.get(i) == id){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addUser(User user){
        int proxId;
        do{
            proxId = random.nextInt(1000000000, 2147483647);
        } while (verificarId(proxId));
        USERS.add(user);
        ids.add(proxId);
        return true;
    }

    public ObjRetornoUser getUser(String nome, String identificador){
        for (int i = 0; i < USERS.size(); i++) {
            User usuario = USERS.get(i);
            if (userController.getUsuarioNome(usuario).equals(nome) && userController.getIdentificador(usuario).equals(identificador)){
                return new ObjRetornoUser(userController.getUsuarioId(usuario), userController.getUsuarioNome(usuario), userController.getIdentificador(usuario));
            }
        }
        return new ObjRetornoUser(0, null, null);
    }
}
