package com.liftOff.LiftOff.persistence.dao.jpa;
import com.liftOff.LiftOff.persistence.dao.PassengerDao;
import com.liftOff.LiftOff.persistence.model.Passenger;
import org.springframework.stereotype.Repository;

@Repository
public class JpaPassengerDao extends GenericJpaDao<Passenger> implements PassengerDao {

    public JpaPassengerDao() {
        super(Passenger.class);
    }
}
