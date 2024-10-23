package wiss.demo.demo.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import wiss.demo.demo.websocket.handler.TimeWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    // Wenn sich ein Client mit ws://localhost:8080/time verbindet, wird er an den SocketHandler weitergeleitet
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new TimeWebSocketHandler(), "/time")
                .setAllowedOrigins("*"); // Erlaube Verbindungen von allen Quellen
    }
}
