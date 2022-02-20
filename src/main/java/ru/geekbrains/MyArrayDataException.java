package ru.geekbrains;

public class MyArrayDataException extends RuntimeException{
    private String data;

    public String getData() {
        return data;
    }

    public MyArrayDataException(String data) {
        super(data);
        this.data = data;
    }
}
