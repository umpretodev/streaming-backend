package streaming.backend.dtos.responses;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.Set;

public record StreamingConnectionResponseDto(
        Set<Map.Entry<String, SseEmitter>> connections
) {
}
