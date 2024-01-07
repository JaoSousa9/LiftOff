package com.liftOff;

import com.liftOff.controller.*;
import org.academiadecodigo.bootcamp.Prompt;
import com.liftOff.view.*;

import jakarta.persistence.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        /*ApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-config.xml");
        StartController startController = context.getBean(StartController.class);
        startController.init();*/

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("flight_application");
        EntityManager em = emf.createEntityManager();

        Prompt prompt = new Prompt(System.in, System.out);

        StartView startView = new StartView();
        startView.setPrompt(prompt);
        LoginView loginView = new LoginView();

        StartController startController = new StartController();
        startView.setStartController(startController);
        startController.setView(startView);

        LoginController loginController = new LoginController();
        loginController.setView(loginView);
        loginController.setEm(em);

        MainController mainController = new MainController();
        loginController.setNextController(mainController);
        loginView.setLoginController(loginController);
        loginView.setPrompt(prompt);

        Map<Integer, Controller> startMap = new HashMap<>();
        startMap.put(StartOptions.LOGIN.getOption(), loginController);
        startMap.put(StartOptions.SIGN_IN.getOption(), new SignInController());

        startController.setStartMap(startMap);

        startController.init();
    }
}
