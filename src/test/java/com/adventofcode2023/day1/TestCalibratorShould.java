package com.adventofcode2023.day1;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestCalibratorShould {

    // https://adventofcode.com/2023/day/1
    final String example1 = "1abc2";
    final String example2 = "pqr3stu8vwx";
    final String example3 = "a1b2c3d4e5f";
    final String example4 = "treb7uchet";

    @Test
    void have_a_blank_value_when_created() {
        Calibrator calibrator = new Calibrator();

        assertThat(calibrator.getOriginalValue(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void have_a_blank_value_when_created_with_null() {
        Calibrator calibrator = new Calibrator(null);

        assertThat(calibrator.getOriginalValue(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void have_a_blank_value_when_created_with_blank() {
        Calibrator calibrator = new Calibrator("");

        assertThat(calibrator.getOriginalValue(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void have_an_empty_value_when_assigned_null() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(null);

        assertThat(calibrator.getOriginalValue(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void have_an_empty_value_when_assigned_blank() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue("");

        assertThat(calibrator.getOriginalValue(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void have_a_non_empty_value_when_assigned_a_valid_value() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example1);

        assertThat(calibrator.getOriginalValue(), equalTo(example1));
    }

    @Test
    void have_nothing_to_parse_characters_from_the_original_value_if_not_set() {
        Calibrator calibrator = new Calibrator();

        assertThat(calibrator.parseDigits(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void have_nothing_to_parse_characters_from_the_original_value_if_null() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(null);

        assertThat(calibrator.parseDigits(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void have_nothing_to_parse_characters_from_the_original_value_if_blank() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue("");

        assertThat(calibrator.parseDigits(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void parse_zero_digit_from_the_original_value() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue("Hello, World!");

        assertThat(calibrator.parseDigits(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void parse_exactly_one_digit_from_the_original_value() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue("0ne ring to rule them all.");

        assertThat(calibrator.parseDigits(), equalTo("0"));
    }

    @Test
    void parse_multiple_digits_from_the_original_value_1() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example1);

        assertThat(calibrator.parseDigits(), equalTo("12"));
    }

    @Test
    void parse_multiple_digits_from_the_original_value_2() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example2);

        assertThat(calibrator.parseDigits(), equalTo("38"));
    }

    @Test
    void parse_multiple_digits_from_the_original_value_3() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example3);

        assertThat(calibrator.parseDigits(), equalTo("12345"));
    }

    @Test
    void parse_multiple_digits_from_the_original_value_4() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example4);

        assertThat(calibrator.parseDigits(), equalTo("7"));
    }

    @Test
    void return_blank_as_first_digit_if_the_original_value_is_not_set() {
        Calibrator calibrator = new Calibrator();
        assertThat(calibrator.getFirstDigit(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void return_blank_as_first_digit_if_the_original_value_is_null() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(null);

        assertThat(calibrator.getFirstDigit(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void return_blank_as_first_digit_if_the_original_value_is_blank() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue("");

        assertThat(calibrator.getFirstDigit(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void return_blank_as_first_digit_if_the_original_value_does_not_contain_digits() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue("Hello, World!");

        assertThat(calibrator.getFirstDigit(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_exactly_one_digit() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue("0ne ring to rule them all.");

        assertThat(calibrator.getFirstDigit(), equalTo("0"));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_multiple_digits_1() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example1);

        assertThat(calibrator.getFirstDigit(), equalTo("1"));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_multiple_digits_2() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example2);

        assertThat(calibrator.getFirstDigit(), equalTo("3"));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_multiple_digits_3() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example3);

        assertThat(calibrator.getFirstDigit(), equalTo("1"));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_multiple_digits_4() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example4);

        assertThat(calibrator.getFirstDigit(), equalTo("7"));
    }

    @Test
    void return_blank_as_last_digit_if_the_original_value_is_not_set() {
        Calibrator calibrator = new Calibrator();
        assertThat(calibrator.getLastDigit(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void return_blank_as_last_digit_if_the_original_value_is_null() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(null);

        assertThat(calibrator.getLastDigit(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void return_blank_as_last_digit_if_the_original_value_is_blank() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue("");

        assertThat(calibrator.getLastDigit(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void return_blank_as_last_digit_if_the_original_value_does_not_contain_digits() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue("Hello, World!");

        assertThat(calibrator.getLastDigit(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void return_the_last_digit_if_the_original_value_contains_exactly_one_digit() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue("0ne ring to rule them all.");

        assertThat(calibrator.getLastDigit(), equalTo("0"));
    }

    @Test
    void return_the_last_digit_if_the_original_value_contains_multiple_digits_1() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example1);

        assertThat(calibrator.getLastDigit(), equalTo("2"));
    }

    @Test
    void return_the_last_digit_if_the_original_value_contains_multiple_digits_2() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example2);

        assertThat(calibrator.getLastDigit(), equalTo("8"));
    }

    @Test
    void return_the_last_digit_if_the_original_value_contains_multiple_digits_3() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example3);

        assertThat(calibrator.getLastDigit(), equalTo("5"));
    }

    @Test
    void return_the_last_digit_if_the_original_value_contains_multiple_digits_4() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example4);

        assertThat(calibrator.getLastDigit(), equalTo("7"));
    }

    @Test
    void calibrate_as_zero_if_the_original_value_is_not_set() {
        Calibrator calibrator = new Calibrator();
        assertThat(calibrator.calibrate(), equalTo(0));
    }

    @Test
    void calibrate_as_zero_if_the_original_value_is_null() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(null);

        assertThat(calibrator.calibrate(), equalTo(0));
    }

    @Test
    void calibrate_as_zero_if_the_original_value_is_blank() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue("");

        assertThat(calibrator.calibrate(), equalTo(0));
    }

    @Test
    void calibrate_as_zero_if_the_original_value_does_not_contain_digits() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue("Hello, World!");

        assertThat(calibrator.calibrate(), equalTo(0));
    }

    @Test
    void calibrate_as_duplicate_if_the_original_value_contains_exactly_one_digit() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue("One ring 2 rule them all.");

        assertThat(calibrator.calibrate(), equalTo(22));
    }

    @Test
    void calibrate_if_the_original_value_contains_multiple_digits_1() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example1);

        assertThat(calibrator.calibrate(), equalTo(12));
    }

    @Test
    void calibrate_if_the_original_value_contains_multiple_digits_2() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example2);

        assertThat(calibrator.calibrate(), equalTo(38));
    }

    @Test
    void calibrate_if_the_original_value_contains_multiple_digits_3() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example3);

        assertThat(calibrator.calibrate(), equalTo(15));
    }

    @Test
    void calibrate_if_the_original_value_contains_multiple_digits_4() {
        Calibrator calibrator = new Calibrator();
        calibrator.setOriginalValue(example4);

        assertThat(calibrator.calibrate(), equalTo(77));
    }
}
