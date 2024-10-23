// WebSocket-Verbindung herstellen
const socket = new WebSocket('ws://localhost:8080');

// Verbindungsstatus anzeigen
const statusEl = document.getElementById('status');
const messageEl = document.getElementById('message');

// WebSocket-Ereignisse
socket.onopen = () => {
    statusEl.textContent = 'Verbunden';
};

socket.onmessage = (event) => {
    messageEl.textContent = `Serverzeit: ${event.data}`;
};

// Fehlerbehandlung
socket.onerror = () => {
    statusEl.textContent = 'Fehler: Verbindung konnte nicht hergestellt werden';
};

socket.onclose = () => {
    statusEl.textContent = 'Verbindung getrennt';
};

// Tastenanschläge an den Server senden
document.addEventListener('keypress', (event) => {
    if (socket.readyState === WebSocket.OPEN) {
        socket.send(`Taste gedrückt: ${event.key}`);
    } else {
        console.error('WebSocket-Verbindung ist nicht geöffnet.');
    }
});
