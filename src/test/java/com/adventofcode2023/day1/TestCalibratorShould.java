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
    final String example5 = "two1nine";
    final String example6 = "eightwothree";
    final String example7 = "abcone2threexyz";
    final String example8 = "xtwone3four";
    final String example9 = "4nineeightseven2";
    final String example10 = "zoneight234";
    final String example11 = "7pqrstsixteen";

    @Test
    void have_blank_values_when_created() {
        Calibrator calibrator = new Calibrator();

        assertThat(calibrator.getOriginalValue(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void have_blank_values_when_created_with_null() {
        Calibrator calibrator = new Calibrator(null);

        assertThat(calibrator.getOriginalValue(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void have_blank_values_when_created_with_blank() {
        Calibrator calibrator = new Calibrator("");

        assertThat(calibrator.getOriginalValue(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void have_empty_values_when_assigned_null() {
        Calibrator calibrator = new Calibrator(null);

        assertThat(calibrator.getOriginalValue(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void have_an_empty_value_when_assigned_blank() {
        Calibrator calibrator = new Calibrator("");

        assertThat(calibrator.getOriginalValue(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void have_a_non_empty_value_when_assigned_a_valid_value() {
        Calibrator calibrator = new Calibrator(example1);

        assertThat(calibrator.getOriginalValue(), equalTo(example1));
    }

    @Test
    void have_nothing_to_parse_characters_from_the_original_value_if_not_set() {
        Calibrator calibrator = new Calibrator();

        assertThat(calibrator.getParsedValue(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void have_nothing_to_parse_characters_from_the_original_value_if_null() {
        Calibrator calibrator = new Calibrator(null);

        assertThat(calibrator.getParsedValue(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void have_nothing_to_parse_characters_from_the_original_value_if_blank() {
        Calibrator calibrator = new Calibrator("");

        assertThat(calibrator.getParsedValue(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void parse_zero_digit_from_the_original_value() {
        Calibrator calibrator = new Calibrator("Hello, World!");

        assertThat(calibrator.getParsedValue(), equalTo(StringUtils.EMPTY));
    }



@Test
    void parse_exactly_one_numeric_digit_from_the_original_value_0() {
        Calibrator calibrator = new Calibrator("eight");

        assertThat(calibrator.getParsedValue(), equalTo("8"));
    }



    @Test
    void parse_exactly_one_numeric_digit_from_the_original_value_1() {
        Calibrator calibrator = new Calibrator("0ne ring to rule them all.");

        assertThat(calibrator.getParsedValue(), equalTo("0"));
    }

    @Test
    void parse_exactly_one_numeric_digit_from_the_original_value_2() {
        Calibrator calibrator = new Calibrator("1 ring to rule them all.");

        assertThat(calibrator.getParsedValue(), equalTo("1"));
    }

    @Test
    void parse_exactly_one_enumerated_digit_from_the_original_value() {
        Calibrator calibrator = new Calibrator("one ring to rule them all.");

        assertThat(calibrator.getParsedValue(), equalTo("1"));
    }

    @Test
    void parse_multiple_digits_from_the_original_value_1() {
        Calibrator calibrator = new Calibrator(example1);

        assertThat(calibrator.getParsedValue(), equalTo("12"));
    }

    @Test
    void parse_multiple_digits_from_the_original_value_2() {
        Calibrator calibrator = new Calibrator(example2);

        assertThat(calibrator.getParsedValue(), equalTo("38"));
    }

    @Test
    void parse_multiple_digits_from_the_original_value_3() {
        Calibrator calibrator = new Calibrator(example3);

        assertThat(calibrator.getParsedValue(), equalTo("12345"));
    }

    @Test
    void parse_multiple_digits_from_the_original_value_4() {
        Calibrator calibrator = new Calibrator(example4);

        assertThat(calibrator.getParsedValue(), equalTo("7"));
    }

    @Test
    void parse_multiple_digits_from_the_original_value_5() {
        Calibrator calibrator = new Calibrator(example5);

        assertThat(calibrator.getParsedValue(), equalTo("219"));
    }

    @Test
    void parse_multiple_digits_from_the_original_value_6() {
        Calibrator calibrator = new Calibrator(example6);

        assertThat(calibrator.getParsedValue(), equalTo("83"));
    }

    @Test
    void parse_multiple_digits_from_the_original_value_7() {
        Calibrator calibrator = new Calibrator(example7);

        assertThat(calibrator.getParsedValue(), equalTo("123"));
    }

    @Test
    void parse_multiple_digits_from_the_original_value_8() {
        Calibrator calibrator = new Calibrator(example8);

        assertThat(calibrator.getParsedValue(), equalTo("234"));
    }

    @Test
    void parse_multiple_digits_from_the_original_value_9() {
        Calibrator calibrator = new Calibrator(example9);

        assertThat(calibrator.getParsedValue(), equalTo("49872"));
    }

    @Test
    void parse_multiple_digits_from_the_original_value_10() {
        Calibrator calibrator = new Calibrator(example10);

        assertThat(calibrator.getParsedValue(), equalTo("1234"));
    }

    @Test
    void parse_multiple_digits_from_the_original_value_11() {
        Calibrator calibrator = new Calibrator(example11);

        assertThat(calibrator.getParsedValue(), equalTo("76"));
    }

    @Test
    void parse_multiple_digits_from_the_original_value_0() {
        Calibrator calibrator = new Calibrator("z7onetwonec");

        assertThat(calibrator.getParsedValue(), equalTo("712"));
    }

    @Test
    void return_blank_as_first_digit_if_the_original_value_is_not_set() {
        Calibrator calibrator = new Calibrator();
        assertThat(calibrator.getFirstDigit(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void return_blank_as_first_digit_if_the_original_value_is_null() {
        Calibrator calibrator = new Calibrator(null);

        assertThat(calibrator.getFirstDigit(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void return_blank_as_first_digit_if_the_original_value_is_blank() {
        Calibrator calibrator = new Calibrator("");

        assertThat(calibrator.getFirstDigit(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void return_blank_as_first_digit_if_the_original_value_does_not_contain_digits() {
        Calibrator calibrator = new Calibrator("Hello, World!");

        assertThat(calibrator.getFirstDigit(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_exactly_one_digit() {
        Calibrator calibrator = new Calibrator("0ne ring to rule them all.");

        assertThat(calibrator.getFirstDigit(), equalTo("0"));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_multiple_digits_1() {
        Calibrator calibrator = new Calibrator(example1);

        assertThat(calibrator.getFirstDigit(), equalTo("1"));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_multiple_digits_2() {
        Calibrator calibrator = new Calibrator(example2);

        assertThat(calibrator.getFirstDigit(), equalTo("3"));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_multiple_digits_3() {
        Calibrator calibrator = new Calibrator(example3);

        assertThat(calibrator.getFirstDigit(), equalTo("1"));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_multiple_digits_4() {
        Calibrator calibrator = new Calibrator(example4);

        assertThat(calibrator.getFirstDigit(), equalTo("7"));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_multiple_digits_5() {
        Calibrator calibrator = new Calibrator(example5);

        assertThat(calibrator.getFirstDigit(), equalTo("2"));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_multiple_digits_6() {
        Calibrator calibrator = new Calibrator(example6);

        assertThat(calibrator.getFirstDigit(), equalTo("8"));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_multiple_digits_7() {
        Calibrator calibrator = new Calibrator(example7);

        assertThat(calibrator.getFirstDigit(), equalTo("1"));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_multiple_digits_8() {
        Calibrator calibrator = new Calibrator(example8);

        assertThat(calibrator.getFirstDigit(), equalTo("2"));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_multiple_digits_9() {
        Calibrator calibrator = new Calibrator(example9);

        assertThat(calibrator.getFirstDigit(), equalTo("4"));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_multiple_digits_10() {
        Calibrator calibrator = new Calibrator(example10);

        assertThat(calibrator.getFirstDigit(), equalTo("1"));
    }

    @Test
    void return_the_first_digit_if_the_original_value_contains_multiple_digits_11() {
        Calibrator calibrator = new Calibrator(example11);

        assertThat(calibrator.getFirstDigit(), equalTo("7"));
    }

    @Test
    void return_blank_as_last_digit_if_the_original_value_is_not_set() {
        Calibrator calibrator = new Calibrator();
        assertThat(calibrator.getLastDigit(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void return_blank_as_last_digit_if_the_original_value_is_null() {
        Calibrator calibrator = new Calibrator(null);

        assertThat(calibrator.getLastDigit(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void return_blank_as_last_digit_if_the_original_value_is_blank() {
        Calibrator calibrator = new Calibrator("");

        assertThat(calibrator.getLastDigit(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void return_blank_as_last_digit_if_the_original_value_does_not_contain_digits() {
        Calibrator calibrator = new Calibrator("Hello, World!");

        assertThat(calibrator.getLastDigit(), equalTo(StringUtils.EMPTY));
    }

    @Test
    void return_the_last_digit_if_the_original_value_contains_exactly_one_digit() {
        Calibrator calibrator = new Calibrator("0ne ring to rule them all.");

        assertThat(calibrator.getLastDigit(), equalTo("0"));
    }

    @Test
    void return_the_last_digit_if_the_original_value_contains_multiple_digits_1() {
        Calibrator calibrator = new Calibrator(example1);

        assertThat(calibrator.getLastDigit(), equalTo("2"));
    }

    @Test
    void return_the_last_digit_if_the_original_value_contains_multiple_digits_2() {
        Calibrator calibrator = new Calibrator(example2);

        assertThat(calibrator.getLastDigit(), equalTo("8"));
    }

    @Test
    void return_the_last_digit_if_the_original_value_contains_multiple_digits_3() {
        Calibrator calibrator = new Calibrator(example3);

        assertThat(calibrator.getLastDigit(), equalTo("5"));
    }

    @Test
    void return_the_last_digit_if_the_original_value_contains_multiple_digits_4() {
        Calibrator calibrator = new Calibrator(example4);

        assertThat(calibrator.getLastDigit(), equalTo("7"));
    }

    @Test
    void return_the_last_digit_if_the_original_value_contains_multiple_digits_5() {
        Calibrator calibrator = new Calibrator(example5);

        assertThat(calibrator.getLastDigit(), equalTo("9"));
    }

    @Test
    void return_the_last_digit_if_the_original_value_contains_multiple_digits_6() {
        Calibrator calibrator = new Calibrator(example6);

        assertThat(calibrator.getLastDigit(), equalTo("3"));
    }

        @Test
    void return_the_last_digit_if_the_original_value_contains_multiple_digits_7() {
        Calibrator calibrator = new Calibrator(example7);

        assertThat(calibrator.getLastDigit(), equalTo("3"));
    }

    @Test
    void return_the_last_digit_if_the_original_value_contains_multiple_digits_8() {
        Calibrator calibrator = new Calibrator(example8);

        assertThat(calibrator.getLastDigit(), equalTo("4"));
    }

    @Test
    void return_the_last_digit_if_the_original_value_contains_multiple_digits_9() {
        Calibrator calibrator = new Calibrator(example9);

        assertThat(calibrator.getLastDigit(), equalTo("2"));
    }

    @Test
    void return_the_last_digit_if_the_original_value_contains_multiple_digits_10() {
        Calibrator calibrator = new Calibrator(example10);

        assertThat(calibrator.getLastDigit(), equalTo("4"));
    }

    @Test
    void return_the_last_digit_if_the_original_value_contains_multiple_digits_11() {
        Calibrator calibrator = new Calibrator(example11);

        assertThat(calibrator.getLastDigit(), equalTo("6"));
    }

    @Test
    void calibrate_as_zero_if_the_original_value_is_not_set() {
        Calibrator calibrator = new Calibrator();
        assertThat(calibrator.getCalibratedValue(), equalTo(0));
    }

    @Test
    void calibrate_as_zero_if_the_original_value_is_null() {
        Calibrator calibrator = new Calibrator(null);

        assertThat(calibrator.getCalibratedValue(), equalTo(0));
    }

    @Test
    void calibrate_as_zero_if_the_original_value_is_blank() {
        Calibrator calibrator = new Calibrator("");

        assertThat(calibrator.getCalibratedValue(), equalTo(0));
    }

    @Test
    void calibrate_as_zero_if_the_original_value_does_not_contain_digits() {
        Calibrator calibrator = new Calibrator("Hello, World!");

        assertThat(calibrator.getCalibratedValue(), equalTo(0));
    }

    @Test
    void calibrate_as_duplicate_if_the_original_value_contains_exactly_one_digit_1() {
        Calibrator calibrator = new Calibrator("0ne ring to rule them all.");

        assertThat(calibrator.getCalibratedValue(), equalTo(0));
    }

    @Test
    void calibrate_as_duplicate_if_the_original_value_contains_exactly_one_digit_2() {
        Calibrator calibrator = new Calibrator("1 ring to rule them all.");

        assertThat(calibrator.getCalibratedValue(), equalTo(11));
    }

    @Test
    void calibrate_as_duplicate_if_the_original_value_contains_exactly_one_digit_3() {
        Calibrator calibrator = new Calibrator("one ring to rule them all.");

        assertThat(calibrator.getCalibratedValue(), equalTo(11));
    }

    @Test
    void calibrate_if_the_original_value_contains_multiple_digits_1() {
        Calibrator calibrator = new Calibrator(example1);

        assertThat(calibrator.getCalibratedValue(), equalTo(12));
    }

    @Test
    void calibrate_if_the_original_value_contains_multiple_digits_2() {
        Calibrator calibrator = new Calibrator(example2);

        assertThat(calibrator.getCalibratedValue(), equalTo(38));
    }

    @Test
    void calibrate_if_the_original_value_contains_multiple_digits_3() {
        Calibrator calibrator = new Calibrator(example3);

        assertThat(calibrator.getCalibratedValue(), equalTo(15));
    }

    @Test
    void calibrate_if_the_original_value_contains_multiple_digits_4() {
        Calibrator calibrator = new Calibrator(example4);

        assertThat(calibrator.getCalibratedValue(), equalTo(77));
    }

    @Test
    void calibrate_if_the_original_value_contains_multiple_digits_5() {
        Calibrator calibrator = new Calibrator(example5);

        assertThat(calibrator.getCalibratedValue(), equalTo(29));
    }

    @Test
    void calibrate_if_the_original_value_contains_multiple_digits_6() {
        Calibrator calibrator = new Calibrator(example6);

        assertThat(calibrator.getCalibratedValue(), equalTo(83));
    }

    @Test
    void calibrate_if_the_original_value_contains_multiple_digits_7() {
        Calibrator calibrator = new Calibrator(example7);

        assertThat(calibrator.getCalibratedValue(), equalTo(13));
    }

    @Test
    void calibrate_if_the_original_value_contains_multiple_digits_8() {
        Calibrator calibrator = new Calibrator(example8);

        assertThat(calibrator.getCalibratedValue(), equalTo(24));
    }

    @Test
    void calibrate_if_the_original_value_contains_multiple_digits_9() {
        Calibrator calibrator = new Calibrator(example9);

        assertThat(calibrator.getCalibratedValue(), equalTo(42));
    }

    @Test
    void calibrate_if_the_original_value_contains_multiple_digits_10() {
        Calibrator calibrator = new Calibrator(example10);

        assertThat(calibrator.getCalibratedValue(), equalTo(14));
    }

    @Test
    void calibrate_if_the_original_value_contains_multiple_digits_11() {
        Calibrator calibrator = new Calibrator(example11);

        assertThat(calibrator.getCalibratedValue(), equalTo(76));
    }

    @Test
    void calibrate_if_the_original_value_contains_multiple_digits_0() {
        Calibrator calibrator = new Calibrator("z7onetwonec");

        assertThat(calibrator.getCalibratedValue(), equalTo(72));
    }
}
