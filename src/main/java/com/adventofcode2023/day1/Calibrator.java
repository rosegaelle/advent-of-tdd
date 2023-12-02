package com.adventofcode2023.day1;

import org.apache.commons.lang3.StringUtils;


class Calibrator {
    private String originalValue = StringUtils.EMPTY;

    public Calibrator() {
    }

    public Calibrator(String originalValue) {
        this.setOriginalValue(originalValue);
    }

    public void setOriginalValue(String value) {
        if(StringUtils.isNotEmpty(value)) {
            this.originalValue = value;
        }
    }

    public String getOriginalValue() {
        return this.originalValue;
    }

    public String parseDigits() {
        return originalValue.replaceAll("[^\\d]", "");
    }

    public String getFirstDigit() {

        String firstDigit = StringUtils.EMPTY;
        String digits = this.parseDigits();

        if(StringUtils.isNotEmpty(digits) && 1 <= digits.length()) {
            firstDigit = digits.substring(0,1);
        }

        return firstDigit;
    }

    public String getLastDigit() {
        String lastDigit = StringUtils.EMPTY;
        String digits = this.parseDigits();

        if(StringUtils.isNotEmpty(digits)) {
            if(1 == digits.length()) {
                lastDigit = digits.substring(0,1);
            } else if(2 <= digits.length()) {
                lastDigit = digits.substring(digits.length()-1,digits.length());
            }
        }

        return lastDigit;
    }

    public Integer calibrate() {
        if(StringUtils.EMPTY.equalsIgnoreCase(getFirstDigit() + getLastDigit())) {
            return 0;
        } else {
            return Integer.valueOf(getFirstDigit() + getLastDigit());
        }
    }
}
