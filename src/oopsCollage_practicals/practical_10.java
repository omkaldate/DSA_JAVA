package oopsCollage_practicals;

import java.util.Scanner;

public class practical_10 {
    public static void add_complex(double real, double imag, double real1, double imag1) {
        double real_part = real + real1;
        double imag_part = imag + imag1;
        System.out.println("The addition of complex number is :" + real_part + " " + imag_part + "i");
    }

    public static void mul_complex(double real, double imag, double real1, double imag1) {
        double real_part = real * real1 - imag * imag1;
        double imag_part = real * imag1 + imag * real1;
        System.out.println("The multiplication of complex number is :" + real_part + " " + imag_part + "i");
    }

    public static void sub_complex(double real, double imag, double real1, double imag1) {
        double real_part = real - real1;
        double imag_part = imag - imag1;
        System.out.println("The subtraction of complex  number is :" + real_part + " " + imag_part + "i");
    }

    public static void div_complex(double real, double imag, double real1, double imag1) {
        double real_part = (real * real1 + imag * imag1) / real1 * real1 + imag1 * imag1;
        double imag_part = (imag * real1 - real * imag1) / real1 * real1 + imag1 * imag1;
        System.out.println("The division of complex number is :" + real_part + " " + imag_part + "i");
    }

    public static void main(String[] args) {
        System.out.println("Om Balasaheb Kaldate");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the real part of  1st complex no.");
        double real = sc.nextDouble ();
        System.out.println("Enter the imag part of  1st complex no.");
        double imag = sc.nextDouble();
        System.out.println ("Enter the real part of  2st complex no.");
        double real1 = sc.nextDouble();
        System.out.println("Enter the imag part of  2st complex no.");

        double imag1 = sc.nextDouble();
        add_complex(real,imag,real1,imag1);
        sub_complex(real,imag,real1,imag1);
        mul_complex(real,imag,real1,imag1);
        div_complex(real,imag,real1,imag1);
    }
}

