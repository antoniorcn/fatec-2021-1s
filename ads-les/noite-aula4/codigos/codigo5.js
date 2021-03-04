const aluno1 = {
    ra: "00001",
    nome: "João Silva"
};

const aluno2 = aluno1;

// Copiar um objeto
// const aluno3 = {};
// aluno3.ra = aluno1.ra;
// aluno3.nome = aluno1.nome;

// const aluno3 = Object.assign({}, aluno1);

const aluno3 = {...aluno1};

aluno1.ra = "11111";

console.log(aluno1);
console.log(aluno3);


const lista = [3, 5, 7, 9, 11];
const lista2 = [...lista];

lista[2] = 17;
console.log(lista);
console.log(lista2);
