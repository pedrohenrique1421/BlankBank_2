package view;

import data.ContaCorrenteData;
import data.ContaPoupancaData;
import data.UserData;
import model.conta.ContaCorrente;
import model.conta.ContaPoupanca;
import model.objRetorno.ObjRetornoUser;
import model.users.User;

import java.util.Date;

public class Manager {
    Viwer viwer = new Viwer();
    Catcher cat = new Catcher();
    UserData userData = new UserData();
    ContaPoupancaData contaPoupancaData = new ContaPoupancaData();
    ContaCorrenteData contaCorrenteData = new ContaCorrenteData();

    // Passo 1 - Perguntar se o usuario possui uma conta
    public boolean verificacaoConta(){
        viwer.printVerificacaoConta();
        switch (cat.getInt()){
            case 1:
                System.out.println("Entrando");
                break;
            case 2:
                System.out.println("Criando conta");
                criarConta();
                break;
            case 3:
                System.out.println("Programa encerrado");
                System.exit(0);
                break;
            default:
                System.out.println("Error");
                verificacaoConta();
                return false;
        }
        return true;
    }
    // Passo 2.1 - Se SIM ir para o menu de entrar na conta
    public boolean entrarContaCorrente(ContaCorrente conta){

        return true;
    }
    // Passo 2.2 - Se NÃO ir para o menu de criar uma conta
    public boolean criarConta(){
        boolean loop = true;
        viwer.printMenuCriarConta();
        ObjRetornoUser response = cat.getUserInfo();
        User user = new User(response.id, response.nome, response.identificador);
        userData.addUser(user);
        do {
            viwer.printTipoDeConta();
            int senha;
            switch (cat.getInt()){
                case 1:
                    loop = false;
                    System.out.println("Poupança");
                    viwer.printInserirSenha("nova");
                    senha = cat.getSenhaNova();
                    contaPoupancaData.addContaPoupanca(new ContaPoupanca(0, "0000-X", 0, user, senha, senha, new Date()));
                    break;
                case 2:
                    loop = false;
                    System.out.println("Corrente");
                    viwer.printInserirSenha("nova");
                    senha = cat.getSenhaNova();
                    contaCorrenteData.addContaCorrente(new ContaCorrente(0, "0000-X", 0, new Date(), user, senha, senha, new Date()));
                    break;
            }
        } while (loop);
        return true;
    }
}
