package streaming.backend.buffers;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ConnectionBuffer {
    private final Map<String, SseEmitter> connections = new ConcurrentHashMap<>();

    public void putByNickname(String nickname, SseEmitter emitter) {
        connections.put(nickname, emitter);
    }

    public void removeByNickname(String nickname) {
        connections.remove(nickname);
    }

    public SseEmitter getByNickaname(String nickname) {
        return connections.get(nickname);
    }

    public Set<Map.Entry<String, SseEmitter>> getAll() {
        return connections.entrySet();
    }
}
