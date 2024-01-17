package com.liftOff.LiftOff;

import com.liftOff.LiftOff.persistence.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
public class DBOperationRunner implements CommandLineRunner {

    @Autowired
    FlightRepository fRepo;

    @Override
    public void run(String... args) throws Exception {

        fRepo.saveAll(Arrays.asList(
                new Flight("AA342", "ORY","OPO","21:20","10:10", "5 de Fev", "2 h 20 min", "63 €", 20,130,20 ),
                new Flight("LH678","ORY","OPO","21:20","13:10", "5 de Fev", "2 h 20 min", "63 €", 20,130,20 ),
                new Flight("SQ205","ORY","OPO","21:20","16:25", "5 de Fev", "2 h 20 min", "63 €", 20,130,20 ),
                new Flight("DL112","ORY","OPO","21:20","22:35", "5 de Fev", "2 h 20 min", "72 €", 20,130,20 ),
                new Flight("EK431","ORY","OPO","21:20","19:00", "5 de Fev", "2 h 20 min", "111 €",20,130,20)
        ));





    }
}
