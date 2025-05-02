package streaming.backend.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import streaming.backend.buffers.ConnectionBuffer;
import streaming.backend.dtos.payloads.UserPayloadDto;
import streaming.backend.services.StreamingConnectionService;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/streaming-connections")
public class StreamingConnectionController {

    @Autowired
    ConnectionBuffer connectionBuffer;

    @Autowired
    StreamingConnectionService streamingConnectionService;

    @PostMapping()
    SseEmitter streamingConnections(@RequestBody @Valid UserPayloadDto userPayloadDto) throws IOException {
        SseEmitter emitter = new SseEmitter();
        String nickname = userPayloadDto.nickname();

        connectionBuffer.putByNickname(nickname, emitter);

        emitter.onCompletion(() -> connectionBuffer.removeByNickname(nickname));
        emitter.onTimeout(() -> connectionBuffer.removeByNickname(nickname));
        emitter.onError(error -> connectionBuffer.removeByNickname(nickname));

        Set<Map.Entry<String, SseEmitter>> connections = connectionBuffer.getAll();
        String message = connections.toString();

        streamingConnectionService.broadcastMessage(message);

        return emitter;
    }
}