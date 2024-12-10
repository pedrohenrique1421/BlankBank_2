package view;

import controller.ContaCorrenteData;
import model.conta.ContaCorrente;
import model.users.User;
import model.users.UserController;
import repository_jpa.ContaRepository;

import java.util.List;

public class DevViwer {
    public static void main(String[] args) {
        ContaCorrenteData contaCorrenteData = new ContaCorrenteData();

        contaCorrenteData.getContaCorrente("pedro", "asd", "12323");
    }
}
