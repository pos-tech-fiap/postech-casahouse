document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('reservaForm');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const formData = new FormData(form);
        const nome = formData.get('name');
        const email = formData.get('email');
        const checkin = formData.get('checkin');
        const checkout = formData.get('checkout');

        fetch('http://localhost:8080/localidade/oi', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                nome: nome,
                email: email,
                checkin: checkin,
                checkout: checkout
            })
        })
        .then(response => response.text())
        .then(data => {
            alert(data); // Exibe a mensagem de resposta do servidor
            // Redireciona para a página de confirmação após a reserva ser realizada
            window.location.href = 'confirmacao.html';
        })
        .catch(error => {
            console.error('Erro:', error);
        });
    });
});