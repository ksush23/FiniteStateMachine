package com.company;

public class Transition{
    private String StartState;
    private char Token;
    private String EndState;

    public String getStartState() {
        return StartState;
    }

    public void setStartState(String startState) {
        StartState = startState;
    }

    public char getToken() {
        return Token;
    }

    public void setToken(char token) {
        Token = token;
    }

    public String getEndState() {
        return EndState;
    }

    public void setEndState(String endState) {
        EndState = endState;
    }

    public Transition(String startState, char token, String endState){
        StartState = startState;
        Token = token;
        EndState = endState;
    }
}
