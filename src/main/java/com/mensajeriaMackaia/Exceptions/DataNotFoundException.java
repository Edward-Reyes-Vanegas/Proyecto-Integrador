package com.mensajeriaMackaia.Exceptions;

public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(){}
    public DataNotFoundException(String messageError){
        super(messageError);
    }
}