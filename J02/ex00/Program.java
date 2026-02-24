
import java.util.Scanner;

class Program {
    public static void main(String[] args) {
        // need to parse signature.txt into a class Signatures
        // read input and process the files and log them into results
        Scanner scanner = new Scanner(System.in);
        Signature sign = Signature.getInstance();
        sign.parseSignatures();
        while(scanner.hasNextLine()) {
            String path = scanner.nextLine();
            if (path.equals("42")) {
                break;
            }
            System.out.println(path);
        }
        scanner.close();
    }
}