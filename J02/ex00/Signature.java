
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


class Signature {
    // singleton ?
    private static Signature instance = null;
    Map<String, String> m = null;
    public String signatureFile;
    // map attribute <Format(String), Signature(String)>

    private Signature() {
        // private constructor
    }

    public void parseSignatures() {
        // open file
        try {
            FileReader fr = new FileReader(Signature.getInstance().signatureFile);
            BufferedReader buffer = new BufferedReader(fr);
            int i = 0;
            String line;
            while((line = buffer.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    m.put(parts[0].trim(), parts[1].trim());
                }
                else {
                    // throw?
                }
            }
            System.out.println("map");
            System.out.println(m);
        } catch (Exception e) {

        }
        // put key,val inside HashMap
    }

    public static Signature getInstance() {
        if (instance == null) {
            instance = new Signature();
            instance.signatureFile = "signatures.txt";
            instance.m = new HashMap<>();
        }
        return instance;
    }
}