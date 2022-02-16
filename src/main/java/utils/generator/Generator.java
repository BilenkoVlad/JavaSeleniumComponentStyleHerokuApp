package utils.generator;

public class Generator {
    protected static final String symbolsForGenerator = "abcdefghijklmnopqrstuvxyz0123456789";

    public static String emailGenerator() {
        StringBuilder stringBuilder = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int index = (int) (symbolsForGenerator.length() * Math.random());
            stringBuilder.append(symbolsForGenerator.charAt(index));
        }
        return stringBuilder + "@mailinator.com";
    }
}
