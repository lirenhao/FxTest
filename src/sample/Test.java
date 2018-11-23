package sample;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        String html = "onclick=\"javascript:location.href='gp_show.aspx?gp_id=184'\"onclick=\"javascript:location.href='gp_show.aspx?gp_id=185'\"";
        Pattern pattern = Pattern.compile("gp_show.aspx\\?gp_id=([0-9]*)'");
        Matcher matcher = pattern.matcher(html);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }
        String start = "gp_show.aspx?gp_id=";
        String[] parts = html.split("'");
        String[] strs = Arrays.stream(parts)
                .filter(subPart -> subPart.contains(start))
                .map(subPart -> subPart.substring(subPart.indexOf(start) + start.length()))
                .toArray(String[]::new);
        System.out.println(Arrays.toString(strs));
    }
}
