package main.java.bsuirlab.model.service;

public class WrongIDException extends Exception{

    public WrongIDException(){
        super("Введите существующий ID");
    }
}
