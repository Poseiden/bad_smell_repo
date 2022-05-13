package timecard.mgmt.exception;

import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {
    public static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.UNPROCESSABLE_ENTITY;

    private ErrorKey errorKey;
    private HttpStatus httpStatus;
    private String detail;

    public BusinessException(ErrorKey errorKey) {
        this(errorKey, Strings.EMPTY, DEFAULT_HTTP_STATUS);
    }

    public BusinessException(ErrorKey errorKey, HttpStatus httpStatus) {
        this(errorKey, Strings.EMPTY, httpStatus);
    }

    public BusinessException(ErrorKey errorKey, String detail) {
        this(errorKey, detail, DEFAULT_HTTP_STATUS);
    }

    public BusinessException(ErrorKey errorKey, String detail, HttpStatus httpStatus) {
        super(errorKey.name());
        this.errorKey = errorKey;
        this.detail = detail;
        this.httpStatus = httpStatus;
    }

}
