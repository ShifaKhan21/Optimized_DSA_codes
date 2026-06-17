import java.util.*;

public class Happy_Number {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (seen.contains(n)) {
                return false;
            }
            seen.add(n);
            int sum = 0;
            String s = String.valueOf(n);

            for (int i = 0; i < s.length(); i++) {
                int dig = s.charAt(i) - '0';
                sum += dig * dig;
            }
            n = sum;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Happy_Number solution = new Happy_Number();

        // Input number
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        // Check if happy number
        boolean result = solution.isHappy(n);

        // Display result
        if (result) {
            System.out.println(n + " is a Happy Number");
        } else {
            System.out.println(n + " is not a Happy Number");
        }

        scanner.close();
    }
}
