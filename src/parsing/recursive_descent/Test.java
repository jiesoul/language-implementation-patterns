package parsing.recursive_descent;

public class Test {
    public static void main(String[] args) {
        ListLexer lexer = new ListLexer(args[0]);
        ListParser parser = new ListParser(lexer);
        parser.list();
    }
}