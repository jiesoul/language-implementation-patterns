package parsing.memoize;

public class LookaheadParser extends Parser {

    void element() {
        if (LA(1) == LookaheadLexer.NAME && LA(2) == LookaheadLexer.EQUALS) {
            match(LookaheadLexer.NAME);
            match(LookaheadLexer.EQUALS);
            match(LookaheadLexer.NAME);
        } else if (LA(1) == LookaheadLexer.NAME) {
            match(LookaheadLexer.NAME);
        } else if (LA(1) == LookaheadLexer.LBRACK) {
            list();
        } else {
            throw new Error("expecting naem or list; found " + LT(1));
        }
    }
}
