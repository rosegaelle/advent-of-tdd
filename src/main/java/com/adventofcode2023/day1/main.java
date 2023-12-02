package com.adventofcode2023.day1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ExecuteOrder66 {

    public static void main(String args[]) {
        System.out.println("Welcome to Advent of Code/TDD '23: Day 1!");

        try{
            // Ask the user for the input filepath
            // e.g. from https://adventofcode.com/2023/day/1
            /// %WORKSPACE_DIR%/advent-of-tdd/day1_sample_input_file.txt
            // e.g. from https://adventofcode.com/2023/day/1/input
            /// %WORKSPACE_DIR%/advent-of-tdd/day1_puzzle_input_file.txt
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the input file path:");

            String inputFilePath = scanner.nextLine();
            scanner.close();
            System.out.println("The input file path is: " + inputFilePath);

            List<String> lines = parseInputFile(inputFilePath);
            

            List<Calibrator> originalValues = new ArrayList<>();
            lines.forEach(line -> originalValues.add(new Calibrator(line)));


            List<Integer> calibratedValues = new ArrayList<>();
            originalValues.forEach(calibrator -> calibratedValues.add(calibrator.calibrate()));


            Integer sum = calibratedValues.stream().reduce(0, Integer::sum);
            System.out.println("The final sum is: " + sum);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static List<String> parseInputFile(String inputFilePath) {
        List<String> lines = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(inputFilePath);       
            Scanner scanner = new Scanner(fis); 

            while(scanner.hasNextLine()) {  
                lines.add(scanner.nextLine()); 
            }

            scanner.close();
        } catch(IOException e) {  
            e.printStackTrace();
        }

        return lines;
    }
}
