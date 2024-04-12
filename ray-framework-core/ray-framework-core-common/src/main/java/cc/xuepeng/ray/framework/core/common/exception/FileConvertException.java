package cc.xuepeng.ray.framework.core.common.exception;

/**
 * 文件转换的异常类
 *
 * @author xuepeng
 */
public class FileConvertException extends BaseException{

    public FileConvertException() {
    }

    public FileConvertException(String msg) {
        super(msg);
    }

    public FileConvertException(Throwable cause) {
        super(cause);
    }

    public FileConvertException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
