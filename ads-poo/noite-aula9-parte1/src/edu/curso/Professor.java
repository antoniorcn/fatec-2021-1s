package edu.curso;

public class Professor implements Assinante {


    @Override
    public void receberMensagem(String msg) {
        System.out.println("Professor lendo " + msg);
    }
}
