package edu.curso;
public class TesteObserver {
    public static void main(String[] args) {
        YouTubber felipe = new YouTubber("Felipe Dechamps");
        YouTubber guanabara = new YouTubber("Gustavo Guanabara");
        YouTubber ibere = new YouTubber("Iberê");

        Estudante fabio = new Estudante("Fabio");
        Estudante maria = new Estudante("Maria");
        Estudante pedro = new Estudante("Pedro");
        Estudante juliana = new Estudante("Juliana");

        Professor antonio = new Professor();

        ibere.adicionar(fabio);
        guanabara.adicionar(maria);
        felipe.adicionar(pedro);
        guanabara.adicionar(juliana);
        ibere.adicionar(juliana);
        ibere.adicionar(antonio);

        guanabara.notificar("Venha aprender HTML e CSS");
        ibere.notificar("Vamos colocar o submarino na agua");
        felipe.notificar("IA no dia a dia");
    }
}
