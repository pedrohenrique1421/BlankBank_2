package view;

import model.objRetorno.ObjRetornoUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catcher {
    Scanner scanner = new Scanner(System.in);

    public int getInt(){
        return scanner.nextInt();
    }

    public float getFloat(){
        return scanner.nextFloat();
    }

    public List<Integer> getMultiInt(int numDeNum){
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < numDeNum; i++) {
            System.out.print("\n--> ");;
            lista.add(scanner.nextInt());
        }
        return lista;
    }

    public ObjRetornoUser getUserInfo(){
        ObjRetornoUser usuario = new ObjRetornoUser(0L, null, "");
        System.out.print("nome: ");
        usuario.nome = scanner.next();
        System.out.print("CPF ou CNPJ: ");
        usuario.identificador = scanner.next();
        return usuario;
    }

    public String getSenha(){
        return scanner.next();
    }

}
