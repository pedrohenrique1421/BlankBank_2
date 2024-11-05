package view;

import data.UserData;
import model.objRetorno.ObjRetornoUser;
import model.users.User;

public class Manager {
    Viwer viwer = new Viwer();
    Catcher cat = new Catcher();
    UserData userData = new UserData();

    // Passo 1 - Perguntar se o usuario possui uma conta
    public boolean verificacaoConta(){
        viwer.printVerificacaoConta();
        switch (cat.getInt()){
            case 1:
                System.out.println("Entrando");
                break;
            case 2:
                System.out.println("Criando conta");
                break;
            case 3:
                System.out.println("Saindo");
                break;
            default:
                System.out.println("Error");
                return false;
        }
        return true;
    }
    // Passo 2.1 - Se SIM ir para o menu de entrar na conta

    // Passo 2.2 - Se NÃO ir para o menu de criar uma conta
    public boolean criarConta(){
        boolean loop = true;
        viwer.printMenuCriarConta();
        ObjRetornoUser user = cat.getUserInfo();
        userData.addUser(new User(user.id, user.nome, user.identificador));
        do {
            viwer.printTipoDeConta();
            switch (cat.getInt()){
                case 1:
                    loop = false;
                    System.out.println("Poupança");
                    break;
                case 2:
                    loop = false;
                    System.out.println("Corrente");
            }
        } while (loop);
        return true;
    }
}
