public class Solver {

    public void permute(String str, int start, int end) {
        if (start == end)
            System.out.println(str);
        else {
            for (int i = start; i <= end; i++) {
                str = swap(str, start, i);
                permute(str, start + 1, end);
                str = swap(str, start, i);
            }
        }
    }

    private String swap(String str, int i, int j) {
        char[] charArr = str.toCharArray();
        char tmp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = tmp;
        return String.valueOf(charArr);
    }
}
