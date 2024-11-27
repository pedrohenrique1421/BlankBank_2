package data;

import model.conta.Conta;
import model.conta.ContaController;
import model.conta.ContaPoupanca;
import model.objRetorno.ObjRetornoContaPoupanca;
import model.users.User;
import model.users.UserController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ContaPoupancaData {
    private final List<ContaPoupanca> CONTAS_POUPANCA = new ArrayList<>();
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

    public boolean addContaPoupanca(ContaPoupanca contaPoupanca){
        int proxId;
        do{
            proxId = random.nextInt(1000000000, 2147483647);
        } while (verificarId(proxId));
        contaController.mudarId(contaPoupanca, proxId);
        CONTAS_POUPANCA.add(contaPoupanca);
        ids.add(proxId);
        return true;
    }

    public ContaPoupanca getContaPoupanca(String nome, String identificador, String senha){
        for (int i = 0; i < CONTAS_POUPANCA.size(); i++) {
            ContaPoupanca conta = CONTAS_POUPANCA.get(i);
            User usuario = contaController.getUsuarioConta(conta);
            if (userController.getUsuarioNome(usuario).equals(nome) && userController.getIdentificador(usuario).equals(identificador)){
                if(contaController.verificarSenhaConta(conta, senha)){
                    return conta;
                }
            }
        }
        return new ContaPoupanca(0, null, 0, new User(0, null, null), null, null, new Date());
    }

    public int depositarValor(int id, float valor){
        for (int i = 0; i < CONTAS_POUPANCA.size(); i++) {
            ContaPoupanca conta = CONTAS_POUPANCA.get(i);
            if (contaController.getId(conta) == id){
                return (contaController.depositarValor(conta, valor)? 200:409);
            }
        }
        return 400;
    }
}
