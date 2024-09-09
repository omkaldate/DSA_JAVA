package ATest;

interface IntNumber {
    void ins(int item); // Method to insert an item into the stack
    int delt();         // Method to delete an item from the stack
}

class HackerEarth implements IntNumber {
    private int stck[];  // Array to store stack elements
    private int pos;     // Position in the stack

    // Constructor to initialize the stack
    HackerEarth(int size) {
        stck = new int[size];
        pos = -1;
    }

    // Method to insert an item into the stack
    public void ins(int item) {
        if (pos == stck.length - 1) {
            System.out.println("Overflow"); // Stack overflow condition
        } else {
            stck[++pos] = item; // Increment position and add item
        }
    }

    // Method to delete an item from the stack
    public int delt() {
        if (pos < 0) {
            System.out.println("Underflow"); // Stack underflow condition
            return 0;  // Returning -1 as an indicator of underflow
        } else {
            return stck[pos--]; // Return the item and decrement position
        }
    }
}

public class Hacker {
    public static void main(String args[]) {
        HackerEarth obj = new HackerEarth(3); // Create a stack of size 3

        // Insert 4 items into the stack, the 4th will cause an overflow
        for (int i = 0; i < 4; i++) {
            obj.ins(i);
        }

        // Delete 4 items from the stack, the 4th will cause an underflow
        for (int i = 0; i <=3; i++) {
            System.out.println(obj.delt());
        }
    }
}
