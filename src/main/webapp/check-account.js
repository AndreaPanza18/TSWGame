document.getElementById("form").addEventListener("submit", function(event) {
    event.preventDefault();

    // Ottenere i valori dei campi email e password
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    // Resettare i messaggi di errore
    document.getElementById("emailError").textContent = "";
    document.getElementById("passwordError").textContent = "";

    // Variabili per tenere traccia degli errori
    let isValid = true;

    // Controllo dell'email
    if (!validateEmail(email)) {
        document.getElementById("emailError").textContent = "Inserisci un'email valida.";
        isValid = false;
        console.log("DIO CANE!")
    }

    // Controllo della password
    if (!validatePassword(password)) {
        document.getElementById("passwordError").textContent = "La password deve essere di almeno 8 caratteri e contenere almeno una lettera maiuscola, una minuscola e un numero.";
        isValid = false;
    }

    // Se tutti i campi sono validi, puoi procedere con il submit del form
    if (isValid) {
        alert("Login riuscito!");
        event.target.submit();
        // Esegui il submit del form, invia i dati al server, ecc.
    }
});

function validateEmail(email) {
    // RegExp per validare un'email
    const re = /^[\w\-\.]+@([\w-]+\.)+[\w-]{2,}$/gm;
    return re.test(email);
}

function validatePassword(password) {
    const pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+[\]{};':"\\|,.<>/?]).{8,}$/;
    return pattern.test(password);
}