package wiss.demo.demo.websocket.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class TimeWebSocketHandler extends TextWebSocketHandler {

    private Timer timer;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    String serverTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                    session.sendMessage(new TextMessage("Serverzeit: " + serverTime));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1000); 
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // Timer stoppen, wenn die Verbindung geschlossen wird
        if (timer != null) {
            timer.cancel();
        }
    }
}
