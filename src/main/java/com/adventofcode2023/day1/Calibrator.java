package com.adventofcode2023.day1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;


class Calibrator {
    private String originalValue = StringUtils.EMPTY;
    private int calibratedValue = 0;

    private static Map<String, String> enumeratedDigitsMapping;
    static {
        enumeratedDigitsMapping = new HashMap<>();
        // numerical
        enumeratedDigitsMapping.put("1", "1");
        enumeratedDigitsMapping.put("2", "2");
        enumeratedDigitsMapping.put("3", "3");
        enumeratedDigitsMapping.put("4", "4");
        enumeratedDigitsMapping.put("5", "5");
        enumeratedDigitsMapping.put("6", "6");
        enumeratedDigitsMapping.put("7", "7");
        enumeratedDigitsMapping.put("8", "8");
        enumeratedDigitsMapping.put("9", "9");
        // enumerated
        enumeratedDigitsMapping.put("one", "1");
        enumeratedDigitsMapping.put("two", "2");
        enumeratedDigitsMapping.put("three", "3");
        enumeratedDigitsMapping.put("four", "4");
        enumeratedDigitsMapping.put("five", "5");
        enumeratedDigitsMapping.put("six", "6");
        enumeratedDigitsMapping.put("seven", "7");
        enumeratedDigitsMapping.put("eight", "8");
        enumeratedDigitsMapping.put("nine", "9");
    }


    public Calibrator() {
    }

    public Calibrator(String value) {
        this.setOriginalValue(value);
        this.calibrateValue();
    }

    private void setOriginalValue(String value) {
        if(StringUtils.isNotEmpty(value)) {
            this.originalValue = value;
        }
    }

    public String getOriginalValue() {
        return this.originalValue;
    }

    private void calibrateValue() {
        if(StringUtils.isNotEmpty(this.getOriginalValue())) {
            this.calibratedValue = (10 * this.getFirstDigit()) + this.getLastDigit();
        }
    }

    public int getFirstDigit() {
        int firstDigit = 0;

        Map<String, Integer> results = new HashMap<>();

        for(String key: enumeratedDigitsMapping.keySet()) {
            if(this.getOriginalValue().contains(key)) {
                results.put(key, this.getOriginalValue().indexOf(key));
            }
        }

        if(MapUtils.isNotEmpty(results)) {
            String firstKey = Collections.min(results.entrySet(), Map.Entry.comparingByValue()).getKey();
            firstDigit = Integer.parseInt(enumeratedDigitsMapping.get(firstKey));
        }

        return firstDigit;
    }

    public int getLastDigit() {
        int lastDigit = 0;

        Map<String, Integer> results = new HashMap<>();

        for(String key: enumeratedDigitsMapping.keySet()) {
            if(this.getOriginalValue().contains(key)) {
                results.put(key, this.getOriginalValue().lastIndexOf(key));
            }
        }

        if(MapUtils.isNotEmpty(results)) {
            String lastKey = Collections.max(results.entrySet(), Map.Entry.comparingByValue()).getKey();
            lastDigit = Integer.parseInt(enumeratedDigitsMapping.get(lastKey));
        }

        return lastDigit;
    }

    public int getCalibratedValue() {
        return this.calibratedValue;
    }
}
