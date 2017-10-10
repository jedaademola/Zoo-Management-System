package edu.mum.mpp.exceptions;


public class AbstractException extends RuntimeException {

    public AbstractException(String code, String message) {

        super(message);
        this.setCode(code);
    }


    private String code;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
