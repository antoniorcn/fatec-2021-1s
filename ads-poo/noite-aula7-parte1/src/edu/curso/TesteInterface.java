package edu.curso;

public class TesteInterface {

    public static void main(String[] args) {

        Riquixa r1 = new Riquixa();
        Uber u1 = new Uber();

        Turista t1 = new Turista();
        t1.setTransportador(u1);
        // t1.transp = r1;

        t1.irAoMuseu();
    }
}
