package org.Patterns.Strategy;

public class Main {
    public static void main(String[] args) {
        SortContext context = new SortContext();

        int[] numbers = {3, 7, 2, 9, 1};

        // Using Bubble Sort
        context.setSortStrategy(new BubbleSortStrategy());
        context.sortNumbers(numbers);

        // Using Quick Sort
        context.setSortStrategy(new QuickSortStrategy());
        context.sortNumbers(numbers);
    }
}