package cn.fcsca.exception;

/**
 * UserNotExistException
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 上午 9:33 2018-08-13
 */
public class UserNotExistException extends RuntimeException {
    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     */
    public UserNotExistException() {
        super("用户不存在！");
    }
}
