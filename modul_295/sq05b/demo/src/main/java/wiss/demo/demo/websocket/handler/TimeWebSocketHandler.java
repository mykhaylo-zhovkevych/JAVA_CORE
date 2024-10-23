package wiss.demo.demo.websocket.handler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class TimeWebSocketHandler extends TextWebSocketHandler {

    // Liste aller aktiven WebSocket-Sessions
    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    // Konstruktor mit Thread, der die Zeit jede Sekunde an alle Sessions sendet
    public TimeWebSocketHandler() {
        // Erstelle und starte einen neuen Thread
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    // Formatierung der aktuellen Zeit als HH:mm:ss
                    String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
                    List<WebSocketSession> disconnectedSessions = new ArrayList<>();

                    // Sende die aktuelle Zeit an jede verbundene WebSocket-Session
                    for (WebSocketSession session : sessions) {
                        try {
                            if (session.isOpen()) {
                                // Sende die Zeit an den Client
                                session.sendMessage(new TextMessage("Serverzeit "+ time));
                            } else {
                                // Füge nicht offene Sessions zur Liste der zu entfernenden Sessions hinzu
                                disconnectedSessions.add(session);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    // Entferne nicht mehr verbundene Sessions aus der Liste
                    sessions.removeAll(disconnectedSessions);

                    // Warte eine Sekunde, bevor der nächste Zeitstempel gesendet wird
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Starte den Thread
        thread.start();
    }

    // Methode, die aufgerufen wird, wenn eine Verbindung hergestellt wird
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Füge die neue Session zur Liste hinzu
        sessions.add(session);
    }

    // Methode, die aufgerufen wird, wenn eine Verbindung geschlossen wird
    @Override
    public void afterConnectionClosed(WebSocketSession session, org.springframework.web.socket.CloseStatus status) throws Exception {
        // Entferne die Session, wenn die Verbindung geschlossen wird
        sessions.remove(session);
    }
}