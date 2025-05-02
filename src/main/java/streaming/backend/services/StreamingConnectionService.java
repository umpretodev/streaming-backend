package streaming.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import streaming.backend.buffers.ConnectionBuffer;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

@Service
public class StreamingConnectionService {
    @Autowired
    ConnectionBuffer connectionBuffer;

    private void sendMessage(SseEmitter emitter, String message) throws IOException {
        emitter.send(SseEmitter.event().data(message));
    }

    public void broadcastMessage(String message) throws IOException {
        Set<Map.Entry<String, SseEmitter>> connections = connectionBuffer.getAll();

        for (Map.Entry<String, SseEmitter> connection : connections) {
            SseEmitter emitter = connection.getValue();
            sendMessage(emitter, message);
        }
    }
}