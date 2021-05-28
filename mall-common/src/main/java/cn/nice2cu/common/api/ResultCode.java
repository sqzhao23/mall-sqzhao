package cn.nice2cu.common.api;


/**
 * 枚举了一些常用 API 操作码
 * @author sqzhao
 * @date 2021年05月16日 10:16
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "success"),
    FAILED(500, "failed"),
    VALIDATE_FAILED(404, "validate failed"),
    UNAUTHORIZED(401, "unauthorized"),
    FORBIDDEN(403, "forbidden");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
