package com.atbashcode;

import java.io.*;
import java.util.*;

public class AtbashCode {

    private List<String> alphabetInLowerCase;
    private List<String> alphabetInUpperCase;

    public AtbashCode(String alphabet) {
        this.alphabetInLowerCase = Arrays.asList(alphabet.toLowerCase().split(""));
        this.alphabetInUpperCase = Arrays.asList(alphabet.toUpperCase().split(""));
    }

    public List<String> getAlphabetInLowerCase() {
        return alphabetInLowerCase;
    }

    public List<String> getAlphabetInUpperCase() {
        return alphabetInUpperCase;
    }

    public void setAlphabet(String alphabet) {
        this.alphabetInLowerCase = Arrays.asList(alphabet.toLowerCase().split(""));
        this.alphabetInUpperCase = Arrays.asList(alphabet.toUpperCase().split(""));
    }

    public String encodeAndDecodeLine(String line) {
        String[] symbols = line.split("");
        String result = "";
        for (int i = 0; i < symbols.length; i++) {
            String currSymb = symbols[i];
            String lowerCaseSymb = currSymb.toLowerCase();
            String upperCaseSymb = currSymb.toUpperCase();
            if ((!currSymb.matches("^[._^%$#!~@,-]+$")) && (!currSymb.equals(" "))){
                if ((!alphabetInLowerCase.contains(currSymb)) &&
                   (!alphabetInUpperCase.contains(currSymb))) {
                    return " ";
                }
                else {
                    int indexLower = alphabetInLowerCase.indexOf(lowerCaseSymb);
                    int indexUpper = alphabetInUpperCase.indexOf(upperCaseSymb);
                    if(indexLower != -1) {
                        result += alphabetInLowerCase.get(alphabetInLowerCase.size() - indexLower - 1);
                    }
                    else {
                        result += alphabetInUpperCase.get(alphabetInUpperCase.size() - indexUpper - 1);
                    }
                }
            }
            else {
                result += currSymb;
            }

        }
        return result;
    }
}