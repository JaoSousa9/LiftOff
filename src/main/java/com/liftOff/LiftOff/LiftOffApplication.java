package com.liftOff.LiftOff;

import com.liftOff.LiftOff.controller.*;
import com.liftOff.LiftOff.view.LoginView;
import com.liftOff.LiftOff.view.SignUpView;
import com.liftOff.LiftOff.view.StartOptions;
import com.liftOff.LiftOff.view.StartView;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.academiadecodigo.bootcamp.Prompt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class LiftOffApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiftOffApplication.class, args);

	}


}
