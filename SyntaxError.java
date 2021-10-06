/** Author: Kevin Abrahams
 * Date: 01-06-2020
 * Class Description: SyntaxError - Provides a class which throws an exception if there is a syntax error.
 */
public class SyntaxError extends Exception {

    /**
     * Serail version uid
     */
    private static final long serialVersionUID = -3694443851308887519L;

    /**
     * Constructor used to set error message
     *
     * @param message - Exception message
     */
    public SyntaxError(String message) {
        super(message);
    }

}
