package ru.daniil.app;

import ru.daniil.app.LeetCodeClass.ListNode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode {

    private LeetCode(){}

    public static LinkedList<Integer> AddTwoNumbers(LinkedList<Integer> listA, LinkedList<Integer> listB){
        LinkedList<Integer> finalList = new LinkedList<>();
        for (int i = 0; i < listA.size(); i++) {
            byte sum = (byte) (listA.get(i) + listB.get(i));
            if (sum >= 10){
                String line = "" + sum;
                String[] array = line.split("");
                finalList.add(i, Integer.parseInt(array[0]));
                finalList.add(i +1,Integer.parseInt(array[1]));
                continue;
            }
            finalList.add((int)sum);
        }
        return finalList;
    }

    public static boolean PalindromeNumber(int x){
        char[] array = (Math.abs(x) + "").toCharArray();
        for (int i = 0; i < array.length/2; i++) {
            if (!(array[array.length - 1 - i] == array[i])) return false;
        }
        return true;
    }

    public static boolean ContainsDuplicate(int[] array){
        Set<Integer> set = Arrays.stream(array).boxed().collect(Collectors.toSet());
        return set.size() != array.length;
    }



    public static ListNode RemoveLinkedListElements(ListNode head, int val){
        if (head == null) return null;
        if (head.next == null){
            if (head.val == val) return null;
            else return head;
        }

        ListNode tail = new ListNode(0, head);
        ListNode prev = tail;
        ListNode next = head;

        while (next.next != null){
            if (next.val == val)
                prev.next = next.next;
            else prev = next;

            next = next.next;
        }

        if (next.val == val)
            prev.next = null;

        return tail.next;
    }

    public static int[] CountingBits(int n){

        switch (n) {
            case 0 -> {
                return new int[]{0};
            }
            case 1 -> {
                return new int[]{0, 1};
            }
            case 2 -> {
                return new int[]{0, 1, 1};
            }
        }


        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 1;

        for (int i = 3; i <= n; i++) {
            int counter = 0, x = i;
            while (x / 2 > 0 || x == 1){
                if (x % 2 == 1){
                    counter++;
                }
                x = x / 2;
            }
            ans[i] = counter;
        }

        return ans;
    }

    public static double MaximumAverageSubarray(int[] nums, int k){
        int sum = 0;

        for (int i = 0; i < k; i++)
            sum += nums[i];

        if (nums.length == k) return (double) sum/k;

        double uns = Double.NEGATIVE_INFINITY;
        uns = Math.max(uns, (double) sum/k);
        for (int i = k; i < nums.length; i++) {
            sum-=nums[i-k];
            sum+=nums[i];
            uns = Math.max(uns, (double) sum/k);
        }
        return uns;
    }

    public static void MoveZeroes(int[] nums){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int num : nums) {
            if (num == 0) arrayDeque.addLast(num);
            else arrayDeque.addFirst(num);
        }
        nums = Arrays.stream(arrayDeque.toArray(new Integer[0])).mapToInt(x -> x).toArray();
    }
}
