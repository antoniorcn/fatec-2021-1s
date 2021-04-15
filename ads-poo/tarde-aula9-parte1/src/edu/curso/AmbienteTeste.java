package edu.curso;

public class AmbienteTeste {

    public static void main(String[] args) {
        YouTuber felipe = new YouTuber();
        YouTuber will = new YouTuber();
        Jornal folha = new Jornal();


        Estudante joao = new Estudante("João");
        Estudante maria = new Estudante("Maria");

        Trabalhador pedro = new Trabalhador("Pedro");
        Trabalhador carla = new Trabalhador("Carla");

        felipe.adicionar(joao);
        felipe.adicionar(maria);

        folha.adicionar(carla);
        folha.adicionar(pedro);
        folha.adicionar(maria);

        will.adicionar(maria);
        will.adicionar(pedro);

        felipe.avisar("Falta profissionais de TI no Brasil");

        will.avisar("Baixou preço das placas mães da Asus");

        folha.avisar("Vacina da China é aplicada em 50% dos Brasileiros");

    }
}
