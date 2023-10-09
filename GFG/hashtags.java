package GFG;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hashtags {
    public static void main(String[] args) {
        String YourString = "Today is a beautiful sunny day #sun. Hello my name is Mat #Sweet#Home";

        String REG_EX_TAG = "#(\\w+)";

        Pattern tagMatcher = Pattern.compile(REG_EX_TAG);
        Matcher m = tagMatcher.matcher(YourString);
        while(m.find())
        {
            String tag = m.group();
            System.out.println(tag);
        }
    }
}
