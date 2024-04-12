package cc.xuepeng.ray.framework.core.common.exception;

/**
 * 文件解析的异常类
 *
 * @author xuepeng
 */
public class FileParseException extends BaseException {

    public FileParseException() {
    }

    public FileParseException(String msg) {
        super(msg);
    }

    public FileParseException(Throwable cause) {
        super(cause);
    }

    public FileParseException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
