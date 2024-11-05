package view;

public class Viwer {
    Catcher cat = new Catcher();

    public void printVerificacaoConta(){
        System.out.print("\nEntrar na sua conta --> 1\nCriar uma conta --> 2\nSair --> 404\n-->");
    }

    public void printMenuCriarConta(){
        System.out.print("\n\n-- Criar conta --\n\n");
    }

    public void printTipoDeConta(){
        System.out.print("\nQue tipo de conta você deseja abrir?\n" +
                "Poupança --> 1\nCorrente --> 2");
    }
}
