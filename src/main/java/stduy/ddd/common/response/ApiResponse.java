package stduy.ddd.common.response;

import java.time.LocalDateTime;

public record ApiResponse<T>(
        int status,
        String code,
        String message,
        T data,
        LocalDateTime timestamp
) {
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "SUCCESS", "요청이 성공적으로 처리되었습니다.", data, LocalDateTime.now());
    }

    public static ApiResponse<Void> success() {
        return new ApiResponse<>(200, "SUCCESS", "요청이 성공적으로 처리되었습니다.", null, LocalDateTime.now());
    }

    public static ApiResponse<?> fail(ErrorCode code) {
        return new ApiResponse<>(code.getStatus(), code.name(), code.getMessage(), null, LocalDateTime.now());
    }
}