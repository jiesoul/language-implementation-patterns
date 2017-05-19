package parsing.multi;

public class Test {
    public static void main(String[] args) {
        LookaheadLexer lexer = new LookaheadLexer(args[0]);
        LookaheadParser parser = new LookaheadParser(lexer, 2);
        parser.list();
    }
}
