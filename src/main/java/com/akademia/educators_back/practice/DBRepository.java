package com.akademia.educators_back.practice;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("DB")
@Primary
public class DBRepository implements Repository{

    public DBRepository(){
        System.out.println("DBrepository");
    }

    public void save(){
        System.out.println("Zapisuje do bazy danych.");
    }

    public void read(){
        System.out.println("Odczytuje z bazy danych.");
    }
}
