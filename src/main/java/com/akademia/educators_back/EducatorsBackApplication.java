package com.akademia.educators_back;

import com.akademia.educators_back.practice.Application;
import com.akademia.educators_back.practice.DBRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EducatorsBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducatorsBackApplication.class, args);
		//Application application = new Application(new DBRepository());
		//application.start();
		//application.stop();
	}

}
