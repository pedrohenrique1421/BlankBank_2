package controller;

import model.conta.Conta;
import model.conta.ContaController;
import model.conta.ContaCorrente;
import model.users.User;
import model.users.UserController;
import repository_jpa.ContaRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ContaCorrenteData {
    private final List<ContaCorrente> CONTAS_CORRENTES = ContaRepository.listAll();
    private List<Integer> ids = new ArrayList<>();
    Random random = new Random();
    ContaController contaController = new ContaController();
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

    public boolean addContaCorrente(ContaCorrente contaCorrente){
        try{
            ContaRepository.salvarContaCorrente(contaCorrente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        //CONTAS_CORRENTES.add(contaCorrente);//Aqui entrava o JPA | la ele...
    }

    public ContaCorrente getContaCorrente(String nome, String identificador, String senha){
        for (int i = 0; i < CONTAS_CORRENTES.size(); i++) {
            ContaCorrente conta = CONTAS_CORRENTES.get(i);
            User usuario = contaController.getUsuarioConta(conta);
            if (userController.getUsuarioNome(usuario).equals(nome) && userController.getIdentificador(usuario).equals(identificador)){
                if(contaController.verificarSenhaConta(conta, senha)){
                    return conta;
                }
            }
        }
        return new ContaCorrente(null, 0,new User(null, null), null, null, new Date());
    }

    public int depositarValor(int id, float valor){
        for (int i = 0; i < CONTAS_CORRENTES.size(); i++) {
            ContaCorrente conta = CONTAS_CORRENTES.get(i);
            if (contaController.getId(conta) == id){
                return (contaController.depositarValor(conta, valor)? 200:409);
            }
        }
        return 400;
    }
}
