package Karat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String cpdomain: cpdomains){
            String[] cdomain = cpdomain.split(" ");
            int count = Integer.parseInt(cdomain[0]);
            String domain = cdomain[1];
            map.put(domain, map.getOrDefault(domain,0)+count);
            for(int i=domain.length()-1;i>0;i--){
                if(domain.charAt(i)=='.'){
                    String subdomain = domain.substring(i+1);
                    map.put(subdomain, map.getOrDefault(subdomain,0)+count);
                }
            }
        }

        List<String> res = new ArrayList<>();
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subdomainVisits(
                new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}
        ));
    }
}
