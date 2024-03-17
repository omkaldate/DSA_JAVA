package oopsCollage_practicals;
import java.util.Scanner;

public class Rectangle {
        private double width;
        private double length;
        private double area;
        private String color;

        // Constructor
        public Rectangle(double width, double length, String color) {
            this.width = width;
            this.length = length;
            this.color = color;
            this.area = width * length;
        }

        // Getter methods
        public double getLength() {
            return length;
        }

        public double getWidth() {
            return width;
        }

        public String getColor() {
            return color;
        }

        // Method to find area
        public double findArea() {
            return area;
        }

        // Method to compare two rectangles
        public static boolean compareRectangles(Rectangle rect1, Rectangle rect2) {
            return rect1.findArea() == rect2.findArea() && rect1.getColor().equals(rect2.getColor());
        }


    public static void main(String[] args) {
        System.out.println("Om Balasaheb Kaldate");
        Scanner scanner = new Scanner(System.in);

        // Input for first rectangle
        System.out.println("Enter the width of the first rectangle:");
        double width1 = scanner.nextDouble();

        System.out.println("Enter the length of the first rectangle:");
        double length1 = scanner.nextDouble();

        System.out.println("Enter the color of the first rectangle:");
        String color1 = scanner.next();

        // Input for second rectangle
        System.out.println("Enter the width of the second rectangle:");
        double width2 = scanner.nextDouble();

        System.out.println("Enter the length of the second rectangle:");
        double length2 = scanner.nextDouble();

        System.out.println("Enter the color of the second rectangle:");
        String color2 = scanner.next();

        // Creating rectangle objects
        Rectangle rect1 = new Rectangle(width1, length1, color1);
        Rectangle rect2 = new Rectangle(width2, length2, color2);

        scanner.close();

        // Comparing rectangles
        if (compareRectangles(rect1, rect2)) {
            System.out.println("Matching Rectangles");
        } else {
            System.out.println("Non-matching Rectangle");
        }
    }
}
