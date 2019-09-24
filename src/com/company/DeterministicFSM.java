package com.company;

import java.util.ArrayList;
import java.util.List;

public class DeterministicFSM {
    private List<String> Q;
    private List<Character> Sigma;
    private List<Transition> Delta;
    private String Q0;
    private List<String> F;

    public DeterministicFSM(){
        Q = new ArrayList<>();
        Sigma = new ArrayList<>();
        Delta = new ArrayList<>();
        F = new ArrayList<>();
    }

    public DeterministicFSM(List<String> q, List<Character> sigma,
                            List<Transition> delta, String q0,
                            List<String> f){
        Q = q;
        Sigma = sigma;
        addTransitions(delta);
        addInitialState(q0);
        addFinalStates(f);
    }

    private void addTransitions(List<Transition> transitions){
        Delta = new ArrayList<>();
        for (var transition : transitions
             ) {
            if (validTransition(transition))
                Delta.add(transition);
        }
    }

    private boolean validTransition(Transition transition){
        return  Q.contains(transition.getStartState()) &&
                Q.contains(transition.getEndState()) &&
                Sigma.contains(transition.getToken()) &&
                !transitionAlreadyDefined(transition);
    }

    private boolean transitionAlreadyDefined(Transition transition){
        for (Transition t : Delta
            ) {
            if (t.getStartState() == transition.getStartState() &&
                    t.getToken() == transition.getToken()) {
                return true;
            }
        }
        return false;
    }

    private void addInitialState(String q0){
        if (Q.contains(q0)){
            Q0 = q0;
        }
    }

    private void addFinalStates(List<String> finalStates){
        F = new ArrayList<>();
        for (var finalState: finalStates
             ) {
            if (Q.contains(finalState)){
                F.add(finalState);
            }
        }
    }

    public boolean accepts(String input) {
        var currentState = Q0;
        Transition transition = Delta.get(0);

        for (var symbol: input.toCharArray()
        ) {
            for (Transition t: Delta
            ) {
                if (t.getStartState() == currentState &&
                        t.getToken() == symbol){
                    transition = t;
                    break;
                }
            }
            if (transition == null) {
                return false;
            }
            currentState = transition.getEndState();
        }

        if (F.contains(currentState)) {
            return true;
        }

        return false;
    }
}
