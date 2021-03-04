console.log("Hello World JS com Node");

let a = 10;

let aluno1 = {
    ra: "00001",
    nome: "João Silva",
    nascimento: "06/09/2000"
};

console.log(aluno1.nome);
aluno1.nome = "Maria Silva";
console.log(aluno1.nome);

let aluno2 = aluno1;

let lista = [2, 4, 6, 8, 10, 12];
let listaAlunos = [
    {ra: "0001", nome:"João Silva"},
    {ra: "0002", nome:"Maria Silva"},
    {ra: "0003", nome:"Renato Gaucho"}
];

console.log(lista[3]);
lista[3] = 18;
console.log(lista[3]);

console.log(listaAlunos[1]);
listaAlunos[1].ra = "2222";
console.log(listaAlunos[1]);

let c = null;

console.log(c);