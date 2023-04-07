import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        System.out.println(groupAnagram(new String[]{"eat", "tan", "ate", "tab", "tea", "bat", "nat"}));
    }

    static List<List<String>> groupAnagram(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }
}

