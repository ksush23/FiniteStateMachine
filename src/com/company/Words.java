package com.company;

import java.util.List;

public class Words {

    private List<Character> alphabet;
    public Words(List<Character> alphabet){
        this.alphabet = alphabet;
    }

    public void generate(StringBuilder sb, int n, DeterministicFSM dFSM) {
        if (n == sb.length()) {
            if (dFSM.accepts(sb.toString())){
                System.out.println(sb);
            }
            return;
        }
        for (char symbol : this.alphabet) {
            sb.setCharAt(n, symbol);
            generate(sb, n + 1, dFSM);
        }
    }
}
