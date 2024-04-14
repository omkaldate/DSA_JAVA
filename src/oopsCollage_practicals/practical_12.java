package oopsCollage_practicals;

public class practical_12 {
    public static void main(String[] args) {
        System.out.println("Name :  Om Balasaheb Kaldate");
        System.out.println();

        try {int[] numbers = {1, 2, 3};
            System.out.println("Accessing element at index 3: " + numbers[3]);
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("An ArrayIndexOutOfBoundsException occurred: " + e.getMessage());
        }
        finally {
            System.out.println("This block is always executed.");
        }
    }
}
