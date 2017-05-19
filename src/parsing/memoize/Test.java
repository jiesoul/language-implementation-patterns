package parsing.memoize;

public class Test {
    public static void main(String[] args) {
        BacktrackLexer lexer = new BacktrackLexer(args[0]);
        LookaheadParser parser = new LookaheadParser(lexer, 2);
        parser.list();
    }
}
