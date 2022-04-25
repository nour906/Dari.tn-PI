package com.example.newD.Exceptions;

public class DariException extends RuntimeException{

    public DariException(String s, Exception e) {
        super(s);
    }
    public DariException(String s) {
        super(s);
    }
}
