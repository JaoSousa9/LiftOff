package com.liftOff.LiftOff.persistence.dao.jpa;
import com.liftOff.LiftOff.persistence.dao.FlightDao;
import com.liftOff.LiftOff.persistence.model.Flight;
import org.springframework.stereotype.Repository;

@Repository
public class JpaFlightDao extends GenericJpaDao<Flight> implements FlightDao {
    public JpaFlightDao() {
        super(Flight.class);
    }
}
