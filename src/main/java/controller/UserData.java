package controller;

import model.objRetorno.ObjRetornoUser;
import model.users.User;
import model.users.UserController;
import repository_jpa.ContaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class UserData {
    private final List<User> USERS = ContaRepository.listAllUsers();
    private List<Integer> ids = new ArrayList<>();
    Random random = new Random();
    UserController userController = new UserController();


    public User getUser(Long id){
        for (int i = 0; i < USERS.size(); i++) {
            User usuario = USERS.get(i);
            if (Objects.equals(userController.getUsuarioId(usuario), id)){
                return new User(userController.getUsuarioNome(usuario), userController.getIdentificador(usuario));
            }
        }
        return new User(null, null);
    }
}
