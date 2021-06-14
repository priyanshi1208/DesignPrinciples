package com.magic.csvdesignprinciple;

public class CustomExceptionsCsvFile extends RuntimeException {
    public enum ExceptionType{
        Invalid_FilePath,Invalid_FileType,Invalid_Type_InputOutput;
    }
    public ExceptionType exceptionType;
    public CustomExceptionsCsvFile(ExceptionType exceptionType,String message) {
        super(message);
        this.exceptionType=exceptionType;
    }
}
