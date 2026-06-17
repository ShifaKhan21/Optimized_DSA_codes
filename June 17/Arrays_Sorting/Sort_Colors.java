import java.util.*;

public class Sort_Colors {
    public void sortColors(int[] nums) {
        int i = -1;
        int j = nums.length;
        int k = 0;

        while (k < j) {
            if (nums[k] == 0) {
                i++;
                swap(nums, i, k);
                k++;
            } else if (nums[k] == 1) {
                k++;
            } else {
                j--;
                swap(nums, j, k);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sort_Colors solution = new Sort_Colors();

        // Input array size
        System.out.print("Enter the size of array: ");
        int n = scanner.nextInt();

        // Input array elements
        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements (only 0, 1, or 2):");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Sort colors
        solution.sortColors(nums);

        // Display result
        System.out.println("\nSorted colors:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}
