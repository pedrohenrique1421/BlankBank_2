package data;

import model.conta.ContaController;
import model.conta.ContaCorrente;
import model.conta.ContaPoupanca;
import model.objRetorno.ObjRetornoContaCorrente;
import model.users.User;
import model.users.UserController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContaCorrenteData {
    private final List<ContaCorrente> CONTAS_CORRENTES = new ArrayList<>();
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
        int proxId;
        do{
            proxId = random.nextInt(1000000000, 2147483647);
        } while (verificarId(proxId));
        contaController.mudarId(contaCorrente, proxId);
        CONTAS_CORRENTES.add(contaCorrente);
        ids.add(proxId);
        return true;
    }

    public ObjRetornoContaCorrente getContaCorrente(String nome, String identificador, String senha){
        for (int i = 0; i < CONTAS_CORRENTES.size(); i++) {
            ContaCorrente conta = CONTAS_CORRENTES.get(i);
            User usuario = contaController.getUsuarioConta(conta);
            if (userController.getUsuarioNome(usuario).equals(nome) && userController.getIdentificador(usuario).equals(identificador)){
                if(contaController.verificarSenhaConta(conta, senha)){
                    return contaController.getContaCorrente(conta);
                }
            }
        }
        return new ObjRetornoContaCorrente(0, null, 0, null, new User(0, null, null), null);
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
