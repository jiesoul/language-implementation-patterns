package parsing.backtrack;

public class BacktrackParser extends Parser {

    public BacktrackParser(Lexer input) {
        super(input);
    }

    void list() throws RecognitionException {
        match(BacktrackLexer.LBRACK);
        elements();
        match(BacktrackLexer.RBRACK);
    }

    void elements() throws RecognitionException {
        element();
        while (LA(1)== BacktrackLexer.COMMA) {
            match(BacktrackLexer.COMMA);
            element();
        }
    }

    void element() throws RecognitionException {
        if (LA(1) == BacktrackLexer.NAME && LA(2) == BacktrackLexer.EQUALS) {
            match(BacktrackLexer.NAME);
            match(BacktrackLexer.EQUALS);
            match(BacktrackLexer.NAME);
        } else if (LA(1) == BacktrackLexer.NAME) {
            match(BacktrackLexer.NAME);
        } else if (LA(1) == BacktrackLexer.LBRACK) {
            list();
        } else {
            throw new Error("expecting naem or list; found " + LT(1));
        }
    }

    public void stat() throws RecognitionException {
        if (speculate_stat_alt1()) {
            list();
            match(Lexer.EOF_TYPE);
        } else if (speculate_stat_alt2()) {
            assign();
            match(Lexer.EOF_TYPE);
        } else {
            throw new NoViableAltException("expecting stat found " + LT(1));
        }
    }

    public void assign() throws RecognitionException {
        list();
        match(BacktrackLexer.EQUALS);
        list();
    }

    public boolean speculate_stat_alt2() {
        boolean success = true;
        mark();
        try {
            list();
            match(Lexer.EOF_TYPE);
        } catch (RecognitionException e) {
            success = false;
        }
        release();
        return success;

    }

    public boolean speculate_stat_alt1() {
        boolean success = true;
        mark();
        try {
            list();
            match(Lexer.EOF_TYPE);
        } catch (RecognitionException e) {
            success = false;
        }

        release();
        return success;
    }


}
