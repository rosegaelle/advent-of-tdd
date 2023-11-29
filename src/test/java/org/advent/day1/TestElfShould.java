package org.advent.day1;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestElfShould {
    @Test
    void have_zero_total_calories_when_created() {
        Elf elf = new Elf();

        assertThat(elf.getTotalCalories(), equalTo(0));
    }

    @Test
    void both_have_zero_total_calories_when_created() {
        Elf elf1 = new Elf();
        Elf elf2 = new Elf();

        assertThat(elf1.getTotalCalories(), equalTo(0));
        assertThat(elf2.getTotalCalories(), equalTo(0));
    }

    @Test
    void have_1000_total_calories_after_adding_1000() {
        int calories = 1000;
        Elf elf = new Elf();

        elf.addCalories(calories);

        assertThat(elf.getTotalCalories(), equalTo(calories));
    }

    @Test
    void both_have_1000_total_calories_after_adding_1000() {
        int calories = 2000;
        Elf elf1 = new Elf();
        Elf elf2 = new Elf();

        elf1.addCalories(calories);
        elf2.addCalories(calories);

        assertThat(elf1.getTotalCalories(), equalTo(calories));
        assertThat(elf2.getTotalCalories(), equalTo(calories));
    }

    @Test
    void compare_throw_exception_on_null_argument() {
        int calories = 3000;
        Elf elf1 = new Elf();
        elf1.addCalories(calories);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            elf1.compareTo(null);
        });

        String expectedMessage = "Did you forget to specify which Elf should be compared against?";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void compare_return_positive_value_for_elf_with_more_total_calories() {
        int calories = 4000;
        Elf elf1 = new Elf();
        elf1.addCalories(calories);

        Elf elf2 = new Elf();

        assertThat(elf1.compareTo(elf2) > 0, equalTo(true));
        assertThat(Elf.compareTo(elf1.getTotalCalories(), elf2.getTotalCalories()), equalTo(1));
    }

    @Test
    void compare_zero_for_equal_elf() {
        int calories = 5000;
        Elf elf1 = new Elf();
        elf1.addCalories(calories);

        Elf elf2 = new Elf();
        elf2.addCalories(calories);

        assertThat(elf1.compareTo(elf2) == 0, equalTo(true));
        assertThat(Elf.compareTo(elf1.getTotalCalories(), elf2.getTotalCalories()), equalTo(0));
    }

    @Test
    void compare_return_negative_value_for_elf_with_less_total_calories() {
        int calories = 6000;
        Elf elf1 = new Elf();
        elf1.addCalories(calories);

        Elf elf2 = new Elf();
        elf2.addCalories(calories * 2);

        assertThat(elf1.compareTo(elf2) < 0, equalTo(true));
        assertThat(Elf.compareTo(elf1.getTotalCalories(), elf2.getTotalCalories()), equalTo(-1));
    }
}
