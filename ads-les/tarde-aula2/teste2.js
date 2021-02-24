// if (0 == false && false == [] && 0 == "0" && "" == []) { 
//     console.log("São Iguais");
// }


// function fazAlgo( tarefa ) { 
//     console.log("Fazendo algo: " + tarefa);
// }


const fazAlgo = ( tarefa ) => { 
    console.log("Fazendo algo: " + tarefa);
};


// const quadrado = ( n ) => { return n * n };

const quadrado = n => n * n;

function somar(n1, n2) { 
    return n1 + n2;
}

function multiplicar(n1, n2) { 
    return n1 * n2;
}

function calcular(n1, n2, operacao){ 
    return operacao(n1, n2)
}

console.log("Soma: ", calcular(5, 7, multiplicar));

let r1 = calcular(5, 7, (n1, n2) => { return n1 - n2 } );
console.log("R1: ", r1);

fazAlgo("Nada");
fazAlgo("Atividade");
fazAlgo("Descansar");