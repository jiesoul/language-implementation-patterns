package parsing.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    Lexer input;
    List<Integer> markers;
    List<Token> lookahead;
    int p  = 0;

    public Parser(Lexer input) {
        this.input = input;
        markers = new ArrayList<>();
        lookahead = new ArrayList<>();
        sync(1);

    }

    private void sync(int i) {
        if (p+i-1 > (lookahead.size()-1)) {
            int n = (p+i-1) - (lookahead.size()-1);
            fill(n);
        }
    }

    private void fill(int n) {
        for (int i = 0; i <= n; i++) {
            lookahead.add(input.nextToken());
        }
    }


    public void consume() {
        p++;
        if (p==lookahead.size() && !isSpeculating()) {
            p = 0;
            lookahead.clear();
        }

        sync(1);
    }

    private boolean isSpeculating() {
        return markers.size() > 0;
    }

    public Token LT(int i) {
        sync(i);
        return lookahead.get(p+i-1);
    }

    public int LA(int i) {
        return LT(i).type;
    }

    public void match(int x) throws MismatchedTokenException {
        if (LA(1) == x) {
            consume();
        } else {
            throw new MismatchedTokenException("expecting " + input.getTokenName(x) +
                            "; found " + LT(1));
        }
    }

    public int mark() {
        markers.add(p);
        return p;
    }

    public void release() {
        int marker = markers.get(markers.size()-1);
        markers.remove(markers.size()-1);
        seek(marker);
    }

    private void seek(int index) {
        p = index;
    }
    
}
