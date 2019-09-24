package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<String> Q = new ArrayList<>();
    private static List<Character> Sigma = new ArrayList<>();
    private static List<Transition> Delta = new ArrayList<>();
    private static String Q0;
    private static List<String> F = new ArrayList<>();

    public static void main(String[] args) {
        Q.add("q0");
        Q.add("q1");
        Q.add("q2");
        Q.add("q3");
        Q.add("q4");

        Sigma.add('a');
        Sigma.add('b');
        Sigma.add('c');
        Sigma.add('d');

        Delta.add(new Transition("q0", 'a', "q1"));
        Delta.add(new Transition("q1", 'c', "q1"));
        Delta.add(new Transition("q0", 'b', "q2"));
        Delta.add(new Transition("q2", 'b', "q2"));
        Delta.add(new Transition("q2", 'a', "q4"));
        Delta.add(new Transition("q1", 'b', "q3"));
        Delta.add(new Transition("q3", 'b', "q4"));
        Delta.add(new Transition("q3", 'a', "q4"));
        Delta.add(new Transition("q3", 'd', "q4"));

        Q0 = "q0";

        F.add("q4");

        DeterministicFSM dFSM = new DeterministicFSM(Q, Sigma, Delta, Q0, F);

        Words words = new Words(Sigma);

        StringBuilder sb = new StringBuilder();
        for (int length = 1; length <= Sigma.size(); length++) {
            sb.setLength(length);
            words.generate(sb, 0, dFSM);
        }
    }
}
