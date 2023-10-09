package JavaBasedQuestion;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class IamImmutable {
    private int i;
    private String s;
    private HashMap<String, String> h;
    public IamImmutable(int i, String s, HashMap<String, String> h) {
        this.i = i;
        this.s = s;

        this.h = new HashMap<>(h);
    }

    public int getI() {
        return i;
    }

    public String getS() {
        return s;
    }

    public Map<String, String> getH() {
        //return new HashMap<>(h);
        return Collections.unmodifiableMap(h);
    }
}

public class ImmutableHashMap {
    public static void main(String[] args) {
        int i = 6;
        String s = "!am@John";
        HashMap<String, String> h = new HashMap<String, String>();

        h.put("Info1", "!am@John");
        h.put("Inf02", "!amCrazy6");


        IamImmutable imm = new IamImmutable(i, s, h);

        h.put("Inf02", "!amCraxy7");

        System.out.println(imm.getS() + imm.getI());
        System.out.println(imm.getH().hashCode());
        for (Map.Entry<String, String> entry: imm.getH().entrySet())
            System.out.println(entry.getKey() + " --- " + entry.getValue());
    }
}
