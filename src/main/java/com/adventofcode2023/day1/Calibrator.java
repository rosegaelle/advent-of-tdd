package com.adventofcode2023.day1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


class Calibrator {
    private String originalValue = StringUtils.EMPTY;
    private String parsedValue = StringUtils.EMPTY;

    private static Map<String, String> enumeratedDigitsMapping;
    static {
        enumeratedDigitsMapping = new HashMap<>();
        enumeratedDigitsMapping.put("zero", "0");
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
        this.setParsedValue();
    }

    private void setOriginalValue(String value) {
        if(StringUtils.isNotEmpty(value)) {
            this.originalValue = value;
        }
    }

    public String getOriginalValue() {
        return this.originalValue;
    }

    private void setParsedValue() {
        this.parsedValue = this.getOriginalValue() ;

        String enumeratedDigits[] = new String[enumeratedDigitsMapping.keySet().size()]; 
        enumeratedDigits = enumeratedDigitsMapping.keySet().toArray(enumeratedDigits);

        while (Arrays.stream(enumeratedDigits).anyMatch(this.parsedValue::contains)) {
            String firstKey = this.findFirstIndexOfEnumeratedDigit(this.parsedValue);
            this.parsedValue = this.parsedValue.replaceFirst("(?i)" + firstKey, enumeratedDigitsMapping.get(firstKey));
        }

        this.parsedValue = this.parsedValue.replaceAll("[^\\d]", "");
    }

    private String findFirstIndexOfEnumeratedDigit(String str) {
        Map<String, Integer> result = new HashMap<>();

        for(String key: enumeratedDigitsMapping.keySet()) {
            if(str.contains(key)) {
                result.put(key, str.indexOf(key));
            }
        }

        return Collections.min(result.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public String getParsedValue() {
        return this.parsedValue;
    }

    public String getFirstDigit() {
        String firstDigit = StringUtils.EMPTY;

        if(StringUtils.isNotEmpty(parsedValue) && 1 <= parsedValue.length()) {
            firstDigit = parsedValue.substring(0,1);
        }

        return firstDigit;
    }

    public String getLastDigit() {
        String lastDigit = StringUtils.EMPTY;

        if(StringUtils.isNotEmpty(parsedValue)) {
            if(1 == parsedValue.length()) {
                lastDigit = parsedValue.substring(0, 1);
            } else if(2 <= parsedValue.length()) {
                lastDigit = parsedValue.substring(parsedValue.length()-1, parsedValue.length());
            }
        }

        return lastDigit;
    }

    public Integer getCalibratedValue() {
        if(StringUtils.EMPTY.equalsIgnoreCase(getFirstDigit() + getLastDigit())) {
            return 0;
        } else {
            return Integer.valueOf(getFirstDigit() + getLastDigit());
        }
    }
}
