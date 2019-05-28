import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str;
        boolean stop = false;

        while (!stop) {
            System.out.print("Enter string: ");
            Scanner in = new Scanner(System.in);
            str = in.nextLine();
            Solver anagrammer = new Solver();
            anagrammer.permute(str);
            System.out.println("'" + str + "' has the following " + anagrammer.getNumberofAnagrams() + " anagram(s):");
            System.out.println(anagrammer);
            System.out.println(anagrammer.getAnagramMap());
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
}