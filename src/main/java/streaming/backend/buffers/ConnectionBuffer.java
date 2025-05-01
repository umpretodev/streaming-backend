package streaming.backend.buffers;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ConnectionBuffer {
    private final Map<String, SseEmitter> connections = new ConcurrentHashMap<>();

    public void putConnection(String nickname, SseEmitter emitter) {
        connections.put(nickname, emitter);
    }

    public void removeConnection(String nickname) {
        connections.remove(nickname);
    }

    public SseEmitter getConnection(String nickname) {
        return connections.get(nickname);
    }

    public Map<String, SseEmitter> getConnections() {
        return connections;
    }
}
