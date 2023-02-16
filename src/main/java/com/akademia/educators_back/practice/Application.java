package com.akademia.educators_back.practice;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Application {

    private Repository repo;
    @Autowired
    private FileRepository repo2;

    @Autowired //wstrzykiwanie zaleznosci
    public Application(@Qualifier("File") Repository repo) {
        this.repo = repo;
        System.out.println("aplikacja");
        System.out.println(repo2);
        System.out.println(repo.getClass());
    }

    @PostConstruct
    public void start() {
        System.out.println("Uruchamiam.");
        repo.read();
        System.out.println(repo2);
    }

    public void stop() {
        System.out.println("Zamykam.");
        repo.save();
    }


}
