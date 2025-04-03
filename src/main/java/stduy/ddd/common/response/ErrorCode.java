package stduy.ddd.common.response;

public enum ErrorCode {
    INVALID_TITLE(400, "제목은 50자 이내여야 합니다."),
    DUPLICATE_EMAIL(409, "이미 존재하는 이메일입니다."),
    USER_NOT_FOUND(404, "사용자를 찾을 수 없습니다."),
    UNAUTHORIZED(401, "로그인이 필요합니다."),
    FORBIDDEN(403, "접근 권한이 없습니다."),
    INTERNAL_SERVER_ERROR(500, "알 수 없는 오류가 발생했습니다."),

    //"제목 또는 내용의 형식이 잘못되었습니다."
    CONTENT_FORMAT_ERROR(400, "제목 또는 내용의 형식이 잘못되었습니다."), ;

    private final int status;
    private final String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}