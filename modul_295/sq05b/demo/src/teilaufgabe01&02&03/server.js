const WebSocket = require('ws');

// WebSocket-Server auf Port 8080 erstellen
const server = new WebSocket.Server({ port: 8080 });

server.on('connection', (socket) => {
    console.log('Client verbunden');

    // Zeit alle 1 Sekunde an den Client senden
    const interval = setInterval(() => {
        const currentTime = new Date().toLocaleTimeString();
        socket.send(currentTime);
    }, 1000);

    // Nachricht vom Client empfangen
    socket.on('message', (message) => {
        console.log(`Nachricht vom Client: ${message}`);
    });

    // Verbindung schliessen und den Zeitintervall stoppen
    socket.on('close', () => {
        console.log('Client getrennt');
        clearInterval(interval);
    });

    socket.on('error', (err) => {
        console.error('Fehler:', err);
    });
});

// console.log('WebSocket-Server läuft auf ws://localhost:8080');
