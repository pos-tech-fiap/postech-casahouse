document.getElementById('reservaForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Evitar o envio do formulário

    // Coletar os dados do formulário
    const idCliente = document.getElementById('idCliente').value;
    const dataEntrada = document.getElementById('dataEntrada').value;
    const dataSaida = document.getElementById('dataSaida').value;
    const quantidadePessoas = parseInt(document.getElementById('quantidadePessoas').value);
    const valorTotalQuartos = calcularValorTotalQuartos(); // Função para calcular o valor total dos quartos
    const valorTotalServicos = calcularValorTotalServicos(); // Função para calcular o valor total dos serviços
    const valorTotalItens = calcularValorTotalItens(); // Função para calcular o valor total dos itens
    const valorTotal = valorTotalQuartos + valorTotalServicos + valorTotalItens;

    // Coletar IDs dos quartos, serviços e itens
    const quartos = document.getElementById('quartos').value.split(',');
    const servicos = document.getElementById('servicos').value.split(',');
    const itens = document.getElementById('itens').value.split(',');

    // Construir o objeto de dados
    const data = {
        idCliente: idCliente,
        dataEntrada: dataEntrada,
        dataSaida: dataSaida,
        quantidadePessoas: quantidadePessoas,
        quartos: quartos,
        servicos: servicos,
        itens: itens,
        valorTotal: valorTotal
    };

    // Enviar a requisição POST com os dados para o servidor
    fetch('http://localhost:8080/reservas', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        window.location.href = 'confirmacao.html';
    })
    .catch(error => {
        console.error('Erro:', error);
    });
});


async function calcularValorTotalQuartos() {
    const quartosSelecionados = document.getElementById('quartos').value.split(',');
    let valorTotal = 0;

    for (const quartoId of quartosSelecionados) {
        try {
            const response = await fetch(`http://localhost:8080/tipo-quarto/${quartoId}`);
            const data = await response.json();

            if (data.valorDiaria && !isNaN(data.valorDiaria)) {
                valorTotal += parseFloat(data.valorDiaria);
            } else {
                console.error(`O quarto ${quartoId} não possui um valor de diária válido.`);
            }
        } catch (error) {
            console.error(`Erro ao obter detalhes do quarto ${quartoId}:`, error);
        }
    }

    return valorTotal;
}

async function calcularValorTotalServicos() {
    const servicosSelecionados = document.getElementById('servicos').value.split(',');
    let valorTotal = 0;

    for (const servicoId of servicosSelecionados) {
        try {
            const response = await fetch(`http://localhost:8080/servicos/${servicoId}`);
            const data = await response.json();

            if (data.valor && !isNaN(data.valor)) {
                valorTotal += parseFloat(data.valor);
            } else {
                console.error(`O serviço ${servicoId} não possui um valor válido.`);
            }
        } catch (error) {
            console.error(`Erro ao obter detalhes do serviço ${servicoId}:`, error);
        }
    }

    return valorTotal;
}

function calcularValorTotalItens() {
    // Implemente a lógica para calcular o valor total dos itens com base nos IDs dos itens selecionados
    // Aqui, você pode recuperar os valores dos itens do servidor ou de uma outra fonte de dados
    // Neste exemplo, retornamos um valor fixo de 50 para cada item selecionado
    const itensSelecionados = document.getElementById('itens').value.split(',');
    return itensSelecionados.length * 50;
}

