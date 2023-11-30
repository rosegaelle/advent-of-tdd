package org.advent.day1;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestElfShould {

    int[][] caloriesPerElf = new int[][] {
        {1000, 2000, 3000},
        {4000},
        {5000, 6000},
        {7000, 8000, 9000},
        {10000}
    };

    @Test
    void have_zero_total_calories_when_created() {
        Elf elf = new Elf();
        assertThat(elf.getTotalCalories(), equalTo(0));
    }

    @Test
    void have_1000_total_calories_after_adding_1000() {
        Elf elf = new Elf();
        elf.addCalories(1000);
        assertThat(elf.getTotalCalories(), equalTo(1000));
    }

    @Test
    void compare_return_positive_value_for_elf_with_more_total_calories() {
        Elf bigElf = new Elf();
        bigElf.addCalories(5000);
        Elf smallElf = new Elf();
        smallElf.addCalories(3000);
        assertThat(bigElf.compareTo(smallElf), greaterThan(0));
    }

    @Test
    void compare_zero_for_equal_elf() {
        Elf elf = new Elf();
        elf.addCalories(5000);
        assertThat(elf.compareTo(elf), equalTo(0));
    }

    @Test
    void compare_return_negative_value_for_elf_with_less_total_calories() {
        Elf bigElf = new Elf();
        bigElf.addCalories(5000);
        Elf smallElf = new Elf();
        smallElf.addCalories(3000);
        assertThat(smallElf.compareTo(bigElf), lessThan(0));
    }

    @Test
    void have_6000_total_calories_after_adding_calories_list_1() {
        Elf elf1 = new Elf();
        elf1.addCalories(caloriesPerElf[0]);
        assertThat(elf1.getTotalCalories(), equalTo(6000));
    }

    @Test
    void have_4000_total_calories_after_adding_calories_list_2() {
        Elf elf2 = new Elf();
        elf2.addCalories(caloriesPerElf[1]);
        assertThat(elf2.getTotalCalories(), equalTo(4000));
    }

    @Test
    void have_11000_total_calories_after_adding_calories_list_3() {
        Elf elf3 = new Elf();
        elf3.addCalories(caloriesPerElf[2]);
        assertThat(elf3.getTotalCalories(), equalTo(11000));
    }

    @Test
    void have_24000_total_calories_after_adding_calories_list_4() {
        Elf elf4 = new Elf();
        elf4.addCalories(caloriesPerElf[3]);
        assertThat(elf4.getTotalCalories(), equalTo(24000));
    }

    @Test
    void have_10000_total_calories_after_adding_calories_list_5() {
        Elf elf5 = new Elf();
        elf5.addCalories(caloriesPerElf[4]);
        assertThat(elf5.getTotalCalories(), equalTo(10000));
    }
}
