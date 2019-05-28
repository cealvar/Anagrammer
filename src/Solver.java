import java.util.HashSet;
import java.util.Set;

public class Solver<K, V> {
    private Set<String> perms;
    private HashMap anagram_map;

    @SuppressWarnings("unchecked")
    public Set<String> permute(String str) {
        if (str.length() == 0) {
            Set set = new HashSet();
            set.add("");
            return set;
        }
        char ch = str.charAt(0);
        String substr = str.substring(1);

        Set<String> prevMapSet = permute(substr);
        HashMap<String, String> map = new HashMap<>();

        for (String word : prevMapSet) {
            for (int i = 0; i <= word.length(); i++) {
                String new_word = word.substring(0, i) + ch + word.substring(i);
                if (!map.containsKey(new_word)) {
                    map.put(new_word, new_word);
                }
            }
        }
        anagram_map = map;
        System.out.println(anagram_map);
        perms = map.keySet();
        return perms;
    }

    public int getNumberofAnagrams() {
        return perms.size();
    }

    public Set<String> getAnagrams() {
        return perms;
    }

    public HashMap getAnagramMap() {
        return anagram_map;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : perms) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }
}
