package parsing.backtrack;

/**
 * Created by jiesoul on 14/05/2017.
 */
public class NoViableAltException extends RuntimeException {
    public NoViableAltException(String s) {
        super(s);
    }
}
