package collectionsTest;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;



public class Test {
    public static void main(String[] args) throws Exception {
        String str = "Éxtension";
        System.out.println(str);

        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(utf8EncodedString);

        String argument = "Nårska täcken";
        String encoded = URLEncoder.encode(argument, "utf-8");

    }
}
