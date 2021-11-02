package com.main;

import com.readfiles.ReadFiles;
import com.writefiles.WriteFiles;
import com.atbashcode.AtbashCode;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args)  throws IOException {
        System.out.println("Put in the name of the file where to alphabet from: ");
        Scanner in = new Scanner(System.in);
        String alphabetPath = in.nextLine();
        String alphabetPathFile = alphabetPath + ".txt";
        System.out.println("Put in the name of the file where to read from: ");
        String readPath = in.nextLine();
        String readPathFile = readPath + ".txt";
        System.out.println("Put in the name of the file where to write to: ");
        String writePath = in.nextLine();
        String writePathFile = writePath + ".txt";
        List<String> theEncodedFile = ReadFiles.readFile(readPathFile, false);
        List<String> alphabetList = ReadFiles.readFile(alphabetPathFile, false);
        String alphabet = alphabetList.get(0);
        AtbashCode coder = new AtbashCode(alphabet);
        List<String> result = new ArrayList<String>();
        String currLine = "";
        String decodedBack = "";
        boolean flagWrong = false;
        for(String line: theEncodedFile) {
            currLine = coder.encodeAndDecodeLine(line);
            if (currLine.equals(" ")) {
                flagWrong = true;
                break;
            }
            decodedBack = coder.encodeAndDecodeLine(currLine);
            result.add(currLine);
            result.add(decodedBack);
        }
        if(!flagWrong) {
            WriteFiles.writeFile(writePathFile, result);
        }
        else {
            WriteFiles.writeFile(writePathFile, Arrays.asList("Failed to complete the task"));
        }
    }
}


