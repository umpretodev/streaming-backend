package streaming.backend.dtos.payloads;

import jakarta.validation.constraints.NotBlank;

public record UserPayloadDto(
        @NotBlank(message = "teste") String nickname,
        @NotBlank(message = "teste") String avatar
) {
}
