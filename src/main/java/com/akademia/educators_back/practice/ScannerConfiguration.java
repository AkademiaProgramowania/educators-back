package com.akademia.educators_back.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerConfiguration {
    @Bean
    public Scanner createScanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
}


//SOLID