package ru.geekbrains;

public class MyArraySizeException extends RuntimeException {
    private String data;

    public String getData() {
        return data;
    }

    public MyArraySizeException(String data) {
        super(data);
        this.data = data;
    }
}
