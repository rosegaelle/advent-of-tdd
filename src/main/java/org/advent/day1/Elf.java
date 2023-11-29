package org.advent.day1;

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
     * Additional calories found by the Elf, to be added to their current total.
     * @param newCalories New calories quantity.
     */
    public void addCalories(int newCalories) {
        this.totalCalories += newCalories;
    }

    /**
     * Comparing the number of calories carried by two Elves.
     * @param arg0 The Elf to be compared against.
     * @return Whether the current Elf is carrying an amount of calories less than (-1), the same (0), or greater than (+1) that of the Elf it is being compared against.
     */
    @Override
    public int compareTo(Elf arg0) {
        if (null == arg0) {
            throw new IllegalArgumentException("Did you forget to specify which Elf should be compared against?");
        } else {
            return compareTo(this.getTotalCalories(), arg0.getTotalCalories());
        }
    }

    /**
     * Helper method for comparing two calory quantities.
     * @param arg0 The LHS of the comparator.
     * @param arg1 The RHS of the comparator.
     * @return Whether the LHS less than (-1), the same (0), or greater than (+1) the RHS.
     */
    public static int compareTo(int arg0, int arg1) {
        return (arg0 < arg1) ? -1 : ((arg0 == arg1) ? 0 : 1);
    }
}
