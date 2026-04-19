package com.thealgorithms.searches;

/**
 * Search in Rotated Sorted Array
 *
 * This algorithm searches for a target value in a rotated sorted array.
 * Time Complexity: O(log n)
 */
public final class SearchInRotatedSortedArray {

    private SearchInRotatedSortedArray() {
    }

    /**
     * Searches target in rotated sorted array
     *
     * @param nums the rotated sorted array
     * @param target the value to search
     * @return index of target if found, otherwise -1
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    // Simple test
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int result = search(nums, target);

        System.out.println("Index: " + result);
    }
}
