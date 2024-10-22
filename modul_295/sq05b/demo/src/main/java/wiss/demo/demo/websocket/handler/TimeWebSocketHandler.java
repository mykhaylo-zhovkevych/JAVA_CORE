import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeWebSocketHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Serverzeit formatieren
        String serverTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        // Serverzeit an den Client senden
        session.sendMessage(new TextMessage("Serverzeit: " + serverTime));
    }
}