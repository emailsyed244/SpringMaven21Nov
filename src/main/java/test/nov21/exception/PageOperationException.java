package test.nov21.exception;

/**
 * This class is used to throw the the user defined exception in page operations.
 *
 * Created by UC186961 on 04/11/2014.
 */
public class PageOperationException extends  RuntimeException {

    public PageOperationException(String msg)
    {
        super(msg);
    }
}
