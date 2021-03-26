package edu.curso;

public class Riquixa implements Transportador {

    @Override
    public void transportar() {
        System.out.println("Riquixa Transportando cliente");
    }

    @Override
    public void cobrar() {
        System.out.println("Cobrar com dinheiro ou cartão");
    }

}
