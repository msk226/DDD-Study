package stduy.ddd.common.response;

import java.time.LocalDateTime;

public record ApiResponse<T>(
        int status,
        String code,
        String message,
        T data,
        LocalDateTime timestamp,
        String path
) {
    public static <T> ApiResponse<T> success(T data, String path) {
        return new ApiResponse<>(200, "SUCCESS", "요청이 성공적으로 처리되었습니다.", data, LocalDateTime.now(), path);
    }

    public static ApiResponse<Void> success(String path) {
        return new ApiResponse<>(200, "SUCCESS", "요청이 성공적으로 처리되었습니다.", null, LocalDateTime.now(), path);
    }

    public static ApiResponse<?> fail(ErrorCode code, String path) {
        return new ApiResponse<>(code.getStatus(), code.name(), code.getMessage(), null, LocalDateTime.now(), path);
    }
}