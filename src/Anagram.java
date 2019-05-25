import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        String str;
        boolean stop = false;
        Anagram usr = new Anagram();

        while (!stop) {
            System.out.print("Enter str ing: ");
            Scanner in = new Scanner(System.in);
            str = in.nextLine();
            int str_length = str.length();
            usr.permute(str, 0, str_length - 1);
            str = "";
            while (!str.toLowerCase().equals("y") && !str.toLowerCase().equals("n")) {
                System.out.print("\nContinue entering more strings? [y/n] ");
                str = in.nextLine();
            }
            if (str.toLowerCase().equals("n")) {
                stop = true;
            } else {
                System.out.println("\n");
            }
        }
    }

    private void permute(String str, int start, int end) {
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
