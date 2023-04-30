package com.mensajeriaMackaia.Exceptions;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException() {


    }

    public InvalidDataException(String messageError){

        super(messageError);
    }

}