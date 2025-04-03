package stduy.ddd.common.response;

public enum ErrorCode {
    INVALID_TITLE(400, "제목은 50자 이내여야 합니다."),
    DUPLICATE_EMAIL(409, "이미 존재하는 이메일입니다."),
    USER_NOT_FOUND(404, "사용자를 찾을 수 없습니다."),
    UNAUTHORIZED(401, "로그인이 필요합니다."),
    FORBIDDEN(403, "접근 권한이 없습니다."),
    INTERNAL_SERVER_ERROR(500, "알 수 없는 오류가 발생했습니다."),


    ANSWER_NOT_FOUND(404, "답변을 찾을 수 없습니다."),
    QUESTION_NOT_FOUND(404, "질문을 찾을 수 없습니다."),
    NOT_EXISTING_USER(404, "존재하지 않는 사용자입니다."),
    WRONG_PASSWORD(401, "비밀번호가 일치하지 않습니다."),

    ALREADY_USING_EMAIL(409, "이미 사용중인 이메일입니다."),
    ALREADY_USING_NICKNAME(409, "이미 사용중인 닉네임입니다."),


    //"제목 또는 내용의 형식이 잘못되었습니다."
    CONTENT_FORMAT_ERROR(400, "제목 또는 내용의 형식이 잘못되었습니다."),

    INVALID_EMAIL(400, "이메일 형식이 올바르지 않습니다."),
    INVALID_NICKNAME(400, "닉네임은 2~15자의 특수문자 없는 문자열이어야 합니다."),
    INVALID_PASSWORD(400, "비밀번호는 8자 이상, 특수문자를 포함해야 합니다."),
    INVALID_PHONE_NUMBER(400, "전화번호는 10~11자리 숫자만 입력 가능합니다."),

    ;

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