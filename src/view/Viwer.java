package view;

public class Viwer {
    Catcher cat = new Catcher();

    public void printVerificacaoConta(){
        System.out.print("\nEntrar na sua conta --> 1\nCriar uma conta --> 2\nSair --> 404\n--> ");
    }

    public void printMenuCriarConta(){
        System.out.print("\n\n-- Criar conta --\n\n");
    }

    public void printTipoDeConta(){
        System.out.print("\nQue tipo de conta você deseja abrir?\n" +
                "Poupança --> 1\nCorrente --> 2\n--> ");
    }

    public void printInserirSenha(String tipo){
        if (tipo.equals("nova")){
            System.out.print("\n\nInsira sua nova senha\n--> ");
        } else {
            System.out.print("\n\nInsira sua senha\n--> ");
        }
    }

    public void getInformacoesTransferencia(int i){
        switch (i){
            case 1:
                System.out.print("\n\nQaul o id da conta que você deseja transferir?\n--> ");
                break;
            case 2:
                System.out.print("\n\nQual a senha da sua poupanca?\n--> ");
                break;
            case 3:
                System.out.print("\n\nQual o valor desejado?\n--> ");
        }
    }

    public void printErrorInput(){
        System.out.println("Opção invalida");
    }

    public void printConta(int id, String nomeUser, String identificadorUser, float saldo){
        System.out.printf("| Id: %i |\n| Nome do propietario: %s |\n| Identificador do propietario(CPF ou CNPJ) |\n| Saldo: %.2f |", id, nomeUser, identificadorUser, saldo);
    }

    public void printQualValor(){
        System.out.print("\nQual o valor?\n--> ");
    }

    public void printMenuCorrente(){
        System.out.print("\n\nTransferir --> 1\nSacar --> 2\nDepositar --> 3\nExtrato --> 4\nSair --> 5\n--> ");
    }

    public void printMenuPoupanca(){
        System.out.print("\n\nRetirar --> 1\nExtrato --> 2\nSair --> 3\n--> ");
    }

    public void printTipoDeContaTransferencia(){
        System.out.print("Para que tipo da conta que você quer transferir?\n\nPoupanca --> 1\nCorrente --> 2\n--> ");
    }

    public void printResposta(String texto){
        System.out.print("A operação foi " + texto);
    }
}
