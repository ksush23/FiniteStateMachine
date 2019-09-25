package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<String> Q = new ArrayList<>();
    private static List<Character> Sigma = new ArrayList<>();
    private static List<Transition> Delta = new ArrayList<>();
    private static String Q0;
    private static List<String> F = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        FileReader fileReader = new FileReader("input");
        Scanner scanner = new Scanner(fileReader);

        String[] alphabet = scanner.nextLine().split("\\s+");
        for (String letter: alphabet
             ) {
            Sigma.add(letter.charAt(0));
        }

        String[]states = scanner.nextLine().split("\\s+");
        for (String state: states
             ) {
            Q.add(state);
        }

        Q0 = scanner.nextLine();

        String[]finStates = scanner.nextLine().split("\\s+");
        for (String finState: finStates
             ) {
            F.add(finState);
        }

        while(scanner.hasNextLine()){
            String[]tr = scanner.nextLine().split("\\s+");
            Transition transition = new Transition(tr[0], tr[1].charAt(0), tr[2]);
            Delta.add(transition);
        }

        DeterministicFSM dFSM = new DeterministicFSM(Q, Sigma, Delta, Q0, F);

        Words words = new Words(Sigma);

        StringBuilder sb = new StringBuilder();
        for (int length = 1; length <= 10; length++) {
            sb.setLength(length);
            words.generate(sb, 0, dFSM);
        }
    }
}
