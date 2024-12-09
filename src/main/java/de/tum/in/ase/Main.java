package de.tum.in.ase;

import java.io.File;
import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("/Users/urkocornejo/Library/CloudStorage/OneDrive-TUM/IdeaProjects" +
                "/Personal/AdventOfCode/AdventOfCode4/src/main/resources/input.txt");
        File test = new File("/Users/urkocornejo/Library/CloudStorage/OneDrive-TUM/IdeaProjects/" +
                "Personal/AdventOfCode/AdventOfCode4/src/main/resources/test.txt");

        Finder finder = new Finder();
        int total = finder.getFinder(input);
        System.out.println("Total: "+total);
    }
}