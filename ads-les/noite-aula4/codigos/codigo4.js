function cabecalho(autor) { 
    console.log("Aplicação de teste do node");
    console.log("feito por: " + autor);
    console.log();
}

function somar(n1, n2) { 
    return n1 + n2;
}

function calcular(n1, n2, operacao) { 
    return operacao(n1, n2);
}

const funcao1 = () => { 
    console.log("Arrow Function");
}

// let resultado = calcular(50, 40, somar);

// let resultado = calcular(50, 40, (n1, n2) => {
//     return n1 ** n2;
// });

let resultado = calcular(50, 40, 
    (n1, n2) => n1 * n2    
)

console.log("50 elevado 40 = ", resultado);


funcao1();
cabecalho("Antonio Rodrigues");
cabecalho("Leandro Colevatti");