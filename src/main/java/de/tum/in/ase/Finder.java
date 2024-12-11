package de.tum.in.ase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Finder {
    List<String> horizontalList;
    List<List<String>> verticalList;

    public int getFinder(File inputFile) throws FileNotFoundException {
        horizontalList = new ArrayList<>();
        verticalList = new ArrayList<>();

        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] letterArray = line.split("");
            horizontalList = Arrays.asList(letterArray);
            verticalList.add(horizontalList);
        }

        /*int total = lToR(verticalList, horizontalList) + rTol(verticalList, horizontalList) +
                upDown(verticalList, horizontalList) + downUp(verticalList, horizontalList) +
                lToRUpDown(verticalList, horizontalList) + rToLUpDown(verticalList, horizontalList) +
                lToRDownUp(verticalList, horizontalList) + rToLDownUp(verticalList, horizontalList);
         */
        return xMAS(verticalList, horizontalList);
    }

    private int lToR(List<List<String>> verticalList, List<String> horizontalList) {
        int counter = 0;
        for (int i = 0; i < verticalList.size(); i++) {
            for (int j = 0; j < horizontalList.size()-3; j++) {
                if (verticalList.get(i).get(j).equals("X") && verticalList.get(i).get(j+1).equals("M") &&
                        verticalList.get(i).get(j+2).equals("A") && verticalList.get(i).get(j+3).equals("S")) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private int rTol(List<List<String>> verticalList, List<String> horizontalList) {
        int counter = 0;
        for (int i = 0; i < verticalList.size(); i++) {
            for (int j = horizontalList.size()-1; j > 2; j--) {
                if (verticalList.get(i).get(j).equals("X") && verticalList.get(i).get(j-1).equals("M") &&
                        verticalList.get(i).get(j-2).equals("A") && verticalList.get(i).get(j-3).equals("S")) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private int upDown(List<List<String>> verticalList, List<String> horizontalList) {
        int counter = 0;
        for (int i = 0; i < verticalList.size()-3; i++) {
            for (int j = 0; j < horizontalList.size(); j++) {
                if (verticalList.get(i).get(j).equals("X") && verticalList.get(i+1).get(j).equals("M") &&
                        verticalList.get(i+2).get(j).equals("A") && verticalList.get(i+3).get(j).equals("S")) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private int downUp(List<List<String>> verticalList, List<String> horizontalList) {
        int counter = 0;
        for (int i = verticalList.size()-1; i > 2; i--) {
            for (int j = 0; j < horizontalList.size(); j++) {
                if (verticalList.get(i).get(j).equals("X") && verticalList.get(i-1).get(j).equals("M") &&
                        verticalList.get(i-2).get(j).equals("A") && verticalList.get(i-3).get(j).equals("S")) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private int lToRUpDown(List<List<String>> verticalList, List<String> horizontalList) {
        int counter = 0;
        for (int i = 0; i < verticalList.size(); i++) {
            for (int j = 0; j < horizontalList.size(); j++) {
                if ((i+3 > verticalList.size()-1) || (j+3 > horizontalList.size()-1)) {
                    //System.out.println("Out of bounds");
                    continue;
                }
                if (verticalList.get(i).get(j).equals("X") && verticalList.get(i+1).get(j+1).equals("M") &&
                        verticalList.get(i+2).get(j+2).equals("A") && verticalList.get(i+3).get(j+3).equals("S")) {
                    //System.out.println("Found!");
                    counter++;
                }
            }
        }
        return counter;
    }

    private int rToLUpDown(List<List<String>> verticalList, List<String> horizontalList) {
        int counter = 0;
        for (int i = 0; i < verticalList.size(); i++) {
            for (int j = horizontalList.size()-1; j > -1; j--) {
                if ((i+3 > verticalList.size()-1) || (j-3 < 0)) {
                    continue;
                }
                if (verticalList.get(i).get(j).equals("X") && verticalList.get(i+1).get(j-1).equals("M") &&
                        verticalList.get(i+2).get(j-2).equals("A") && verticalList.get(i+3).get(j-3).equals("S")) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private int lToRDownUp(List<List<String>> verticalList, List<String> horizontalList) {
        int counter = 0;
        for (int i = verticalList.size()-1; i > -1; i--) {
            for (int j = 0; j < horizontalList.size(); j++) {
                if ((i-3 < 0) || (j+3 > horizontalList.size()-1)) {
                    continue;
                }
                if (verticalList.get(i).get(j).equals("X") && verticalList.get(i-1).get(j+1).equals("M") &&
                        verticalList.get(i-2).get(j+2).equals("A") && verticalList.get(i-3).get(j+3).equals("S")) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private int rToLDownUp(List<List<String>> verticalList, List<String> horizontalList) {
        int counter = 0;
        for (int i = verticalList.size()-1; i > -1; i--) {
            for (int j = horizontalList.size()-1; j > -1; j--) {
                if ((i-3 < 0) || (j-3 < 0)) {
                    continue;
                }
                if (verticalList.get(i).get(j).equals("X") && verticalList.get(i-1).get(j-1).equals("M") &&
                        verticalList.get(i-2).get(j-2).equals("A") && verticalList.get(i-3).get(j-3).equals("S")) {
                    counter++;
                }
            }
        }
        return counter;
    }


    private int xMAS(List<List<String>> verticalList, List<String> horizontalList) {
        int counter = 0;
        for (int i = 0; i < verticalList.size(); i++) {
            for (int j = 0; j < horizontalList.size(); j++) {
                if ((i+1 > verticalList.size()-1) || (j+1 > horizontalList.size()-1) || (i-1 < 0) || (j-1 < 0)) {

                    continue;
                }
                if (verticalList.get(i).get(j).equals("A")) {
                    if ((verticalList.get(i-1).get(j-1).equals("M") && verticalList.get(i+1).get(j+1).equals("S") &&
                            ((verticalList.get(i+1).get(j-1).equals("M") && verticalList.get(i-1).get(j+1).equals("S")) ||
                            (verticalList.get(i-1).get(j+1).equals("M") && verticalList.get(i+1).get(j-1).equals("S")))) ||

                            (verticalList.get(i+1).get(j+1).equals("M") && verticalList.get(i-1).get(j-1).equals("S") &&
                                    ((verticalList.get(i+1).get(j-1).equals("M") && verticalList.get(i-1).get(j+1).equals("S")) ||
                                            (verticalList.get(i-1).get(j+1).equals("M") && verticalList.get(i+1).get(j-1).equals("S"))))
                    ) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}
