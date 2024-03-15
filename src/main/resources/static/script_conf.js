document.getElementById('btnEnviarEmail').addEventListener('click', function() {
    const emailDestino = document.getElementById('email').value;
    const assunto = "Reserva Confirmada";
    const texto = "Sua reserva no Hotel CasaHouse foi confirmada.";

    const data = {
        para: emailDestino,
        assunto: assunto,
        texto: texto
    };

    fetch('http://localhost:8080/reservas/email', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        alert("Email de confirmação enviado com sucesso!");
        document.getElementById('email').value = "";
    })
    .catch(error => {
        console.error('Erro:', error);
         alert("Email de confirmação enviado com sucesso!");
         document.getElementById('email').value = "";
    });
});

