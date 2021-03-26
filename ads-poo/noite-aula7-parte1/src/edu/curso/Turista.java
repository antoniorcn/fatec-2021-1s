package edu.curso;

public class Turista {
    Transportador transp;

//    public Turista(Transportador t) {
//        this.transp = t;
//    }

    public void setTransportador(Transportador t) {
        this.transp = t;
    }

    void irAoMuseu() {
//        if (transp instanceof Riquixa) {
//            System.out.println("Esperando o Riquixa para me levar ao Museu");
//        } else if (transp instanceof Uber) {
//            System.out.println("Esperando o Uber para me levar ao Museu");
//        }
        transp.transportar();
        transp.cobrar();
    }
}
