package Comparator;

public class LargestNumber {
    public static String largestNumber(int[] nums) {

        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        for (int i = 0; i < numsStr.length - 1; i++) {
            for (int j = i + 1; j < numsStr.length; j++) {
                String order1 = numsStr[i] + numsStr[j];
                String order2 = numsStr[j] + numsStr[i];

                if (order1.compareTo(order2) < 0) {
                    String temp = numsStr[i];
                    numsStr[i] = numsStr[j];
                    numsStr[j] = temp;
                }
            }
        }

        if (numsStr[0].equals("0")) {
            return "0";
        }

        StringBuilder largestNumber = new StringBuilder();
        for (String numStr : numsStr) {
            largestNumber.append(numStr);
        }
        return largestNumber.toString();
    }

    public static void main(String[] args) {
        int[]nums = {1, 20};
        System.out.println(largestNumber(nums));
    }
}
