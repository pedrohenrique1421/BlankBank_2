package view;

import data.ContaCorrenteData;
import data.ContaPoupancaData;
import data.UserData;
import model.conta.Conta;
import model.conta.ContaController;
import model.conta.ContaCorrente;
import model.conta.ContaPoupanca;
import model.objRetorno.ObjRetornoContaCorrente;
import model.objRetorno.ObjRetornoUser;
import model.users.User;
import model.users.UserController;

import java.util.Date;

public class Manager {
    Viwer viwer = new Viwer();
    Catcher cat = new Catcher();
    UserData userData = new UserData();
    ContaPoupancaData contaPoupancaData = new ContaPoupancaData();
    ContaCorrenteData contaCorrenteData = new ContaCorrenteData();
    ContaController contaController = new ContaController();
    UserController userController = new UserController();

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
    public boolean entrarConta(Conta conta){
        boolean loop = true;
        do {
            if(contaController.getTipoConta(conta).equals("corrente")){
                viwer.printMenuCorrente();
                boolean loopAcao = true;
                switch (cat.getInt()){
                    case 1:
                        // Transferir
                        loopAcao = true;
                        do {
                            viwer.printTipoDeContaTransferencia();
                            switch (cat.getInt()){
                                case 1:
                                    // Poupanca
                                    viwer.getInformacoesTransferencia(1);
                                    int id = cat.getInt();
                                    viwer.getInformacoesTransferencia(3);
                                    float valor = cat.getFloat();
                                    System.out.print("\n\nDigite a sua senha\n--> ");
                                    String senha = cat.getSenha();
                                    int response = 0;
                                    if(contaController.retirarValor(conta, senha, valor)){
                                        response = contaPoupancaData.depositarValor(id, valor);
                                    }
                                    switch (response){
                                        case 0:
                                            viwer.printResposta("mal sucedida, saldo invalido");
                                        case 200:
                                            viwer.printResposta("bem sucedida.");
                                            break;
                                        case 409:
                                            viwer.printResposta("mal sucedida. error na operação");
                                            break;
                                        case 400:
                                            viwer.printResposta("mal sucedida, conta invalida");
                                            entrarConta(conta);
                                            break;
                                        default:
                                            System.out.println("error inesperado");
                                            entrarConta(conta);
                                            break;
                                    }
                                    loopAcao = false;// Encerra a açao
                                    break;
                                case 2:
                                    // Corrente
                                    viwer.getInformacoesTransferencia(1);
                                    id = cat.getInt();
                                    viwer.getInformacoesTransferencia(3);
                                    valor = cat.getFloat();
                                    System.out.print("\n\nDigite a sua senha\n--> ");
                                    senha = cat.getSenha();
                                    response = 0;
                                    if(contaController.retirarValor(conta, senha, valor)){
                                        response = contaCorrenteData.depositarValor(id, valor);
                                    }
                                    switch (response){
                                        case 0:
                                            viwer.printResposta("mal sucedida, saldo invalido");
                                        case 200:
                                            viwer.printResposta("bem sucedida.");
                                            break;
                                        case 409:
                                            viwer.printResposta("mal sucedida. error na operação");
                                            break;
                                        case 400:
                                            viwer.printResposta("mal sucedida, conta invalida");
                                            entrarConta(conta);
                                            break;
                                        default:
                                            System.out.println("error inesperado");
                                            entrarConta(conta);
                                            break;
                                    }
                                    loopAcao = false;// Encerra a açao
                                    break;
                                case 3:
                                    // cancelar
                                    System.out.print("\n\n-- Ação cancelada --\n\n");
                                    entrarConta(conta);
                                    break;
                                default:
                                    viwer.printErrorInput();
                                    break;
                            }
                        } while (loopAcao);
                        break;
                    case 2:
                        //Sacar
                        viwer.getInformacoesTransferencia(3);
                        float valor = cat.getFloat();
                        System.out.print("\n\nDigite a sua senha\n--> ");
                        String senha = cat.getSenha();
                        if(contaController.retirarValor(conta, senha, valor)){
                            System.out.println("retirada permitida");
                        } else {
                            System.out.println("error");
                            entrarConta(conta);
                        }
                        break;
                    case 3:
                        //Depositar
                        viwer.getInformacoesTransferencia(3);
                         valor = cat.getFloat();
                        System.out.print("\n\nDigite a sua senha\n--> ");
                        senha = cat.getSenha();
                        if(contaController.verificarSenhaConta(conta, senha)){
                            if(contaController.depositarValor(conta, valor)) {
                                System.out.println("Deposito efetuado");
                            }
                        } else {
                            System.out.println("error");
                            entrarConta(conta);
                        }
                        break;
                    case 4:
                        //Extrato
                        System.out.print("\n\nDigite a sua senha\n--> ");
                        senha = cat.getSenha();
                        viwer.printConta(contaController.getId(conta), userController.getUsuarioNome(contaController.getUsuarioConta(conta)), userController.getIdentificador(contaController.getUsuarioConta(conta)), contaController.getSaldo(conta, senha));
                        System.out.print("\n\ndigite algo --> ");
                        cat.getSenha();
                        break;
                    case 5:
                        // Sair
                        verificacaoConta();
                        break;
                    default:
                        break;
                }
            } else {
                viwer.printMenuPoupanca();
                switch (cat.getInt()){
                    case 1:
                        // Retirar
                        break;
                    case 2:
                        //Extrato
                        break;
                    case 3:
                        //Sair
                        break;
                }
            }
        } while (loop);
        verificacaoConta();
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
            String senha;
            switch (cat.getInt()){
                case 1:
                    loop = false;
                    System.out.println("Poupança");
                    viwer.printInserirSenha("nova");
                    senha = cat.getSenha();
                    ContaPoupanca contaA = new ContaPoupanca(0, "0000-X", 0, user, senha, senha, new Date());
                    contaPoupancaData.addContaPoupanca(contaA);
                    entrarConta(contaA);
                    break;
                case 2:
                    loop = false;
                    System.out.println("Corrente");
                    viwer.printInserirSenha("nova");
                    senha = cat.getSenha();
                    ContaCorrente contaB = new ContaCorrente(0, "0000-X", 0, new Date(), user, senha, senha, new Date());
                    contaCorrenteData.addContaCorrente(contaB);
                    entrarConta(contaB);
                    break;
            }
        } while (loop);
        return true;
    }
}