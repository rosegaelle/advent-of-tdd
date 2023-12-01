package org.advent.day1;

//import static org.mockito.Answers.values;

import java.util.Arrays;

/**
 * Elf that is assigned calories
 */
public class Elf implements Comparable<Elf> {

    private int totalCalories = 0;

    /**
     * Calories carried by the Elf
     * @return total calories
     */
    public int getTotalCalories() {
        return totalCalories;
    }

    /**
     * Adds calories to this elf for carrying
     * @param calories to add to total count for this elf
     */
    public void addCalories(int calories) {
        totalCalories += calories;
    }

    /**
     * Adds calories from a list to this elf for carrying
     * @param caloriesList to incrementally add to total count for this elf
     */
    public void addCalories(int[] caloriesList) {
        if (null != caloriesList) {
            Arrays.stream(caloriesList).forEach(newCalories -> addCalories(newCalories));
        }
    }

    @Override
    public int compareTo(Elf that) {
        return this.getTotalCalories() - that.getTotalCalories();
    }
}
