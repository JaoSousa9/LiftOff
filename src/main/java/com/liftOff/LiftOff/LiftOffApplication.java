package com.liftOff.LiftOff;

import com.liftOff.LiftOff.controller.*;
import com.liftOff.LiftOff.view.LoginView;
import com.liftOff.LiftOff.view.SignInView;
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

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("liftOff");
		EntityManager em = emf.createEntityManager();

		Prompt prompt = new Prompt(System.in, System.out);

		StartView startView = new StartView();
		startView.setPrompt(prompt);
		LoginView loginView = new LoginView();

		SignInView signInView = new SignInView();
		signInView.setPrompt(prompt);

		StartController startController = new StartController();
		startView.setStartController(startController);
		startController.setView(startView);

		LoginController loginController = new LoginController();
		loginController.setView(loginView);
		loginController.setEm(em);
		loginController.setStartController(startController);

		SignInController signInController = new SignInController();
		signInController.setView(signInView);

		MainController mainController = new MainController();
		loginController.setNextController(mainController);
		loginView.setLoginController(loginController);
		loginView.setPrompt(prompt);

		Map<Integer, Controller> startMap = new HashMap<>();
		startMap.put(StartOptions.LOGIN.getOption(), loginController);
		startMap.put(StartOptions.SIGN_IN.getOption(), signInController);

		startController.setStartMap(startMap);

		startController.init();
	}


}
