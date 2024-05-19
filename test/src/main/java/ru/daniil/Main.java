package ru.daniil;

import ru.daniil.app.LeetCode;
import ru.daniil.app.LeetCodeClass.ListNode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] x = {0, 1, 0, 2, 3, 4};
        LeetCode.MoveZeroes(x);
        System.out.println(Arrays.toString(x));

        for (int number: x)
            System.out.println(number);

    }

}