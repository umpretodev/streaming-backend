package streaming.backend.dtos;

public record ApiResponseDto<T>(
        boolean success,
        T info,
        String message
) {
}
