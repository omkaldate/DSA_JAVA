package leetCodeContest.Weekly414;

public class ConvertDatatoBinary {
    public static String convert(int num) {
        return Integer.toBinaryString(num);
    }

    public static String convertDateToBinary(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        String yearBinary = convert(year);
        String monthBinary = convert(month);
        String dayBinary = convert(day);

        return yearBinary + "-" + monthBinary + "-" + dayBinary;
    }

    public static void main(String[] args) {
        String date = "2080-02-29";
        System.out.println(convertDateToBinary(date));
    }
}
