package main.java.bsuirlab.model.service;

public class NullStringException extends Exception{

    public NullStringException(){
        super("Введите корректные данные");
    }
}
