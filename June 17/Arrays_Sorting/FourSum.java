import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j]
                             + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(
                            nums[i], nums[j],
                            nums[left], nums[right]
                        ));

                        // Skip duplicates
                        while (left < right &&
                               nums[left] == nums[left + 1]) {
                            left++;
                        }

                        while (left < right &&
                               nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    }
                    else if (sum < target) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FourSum solution = new FourSum();

        // Input array size
        System.out.print("Enter the size of array: ");
        int n = scanner.nextInt();

        // Input array elements
        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Input target
        System.out.print("Enter target sum: ");
        int target = scanner.nextInt();

        // Find and display result
        List<List<Integer>> result = solution.fourSum(nums, target);

        System.out.println("\nQuadruplets with sum " + target + ":");
        if (result.isEmpty()) {
            System.out.println("No quadruplets found");
        } else {
            for (List<Integer> quadruplet : result) {
                System.out.println(quadruplet);
            }
        }

        scanner.close();
    }
}
