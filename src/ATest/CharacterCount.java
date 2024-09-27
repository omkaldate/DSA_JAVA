package ATest;

import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String data = sc.nextLine();
        char coder = sc.next().charAt(0);
        int count = 0;

        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == coder) {
                count++;
            }
        }

        System.out.println(count);
    }
}
