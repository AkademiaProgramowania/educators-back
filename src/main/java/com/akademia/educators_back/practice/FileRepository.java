package com.akademia.educators_back.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("File")
public class FileRepository implements Repository {
    private Scanner scanner;
    @Autowired
    public FileRepository(Scanner scanner) {
        this.scanner = scanner;
        System.out.println(scanner);
    }

    public FileRepository() {
        System.out.println("file repo");
    }

    public void save() {
        System.out.println("Zapisuje do pliku.");
    }

    public void read() {
        System.out.println("Odczytuje z pliku.");
    }
}
