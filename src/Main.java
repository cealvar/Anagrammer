import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str;
        boolean stop = false;
        Solver anagrammer = new Solver();

        while (!stop) {
            System.out.print("Enter str ing: ");
            Scanner in = new Scanner(System.in);
            str = in.nextLine();
            int str_length = str.length();
            anagrammer.permute(str, 0, str_length - 1);
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