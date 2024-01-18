package com.liftOff.LiftOff.persistence.dao.jpa;
import com.liftOff.LiftOff.exceptions.PassengerNotFoundException;
import com.liftOff.LiftOff.persistence.dao.PassengerDao;
import com.liftOff.LiftOff.persistence.model.Passenger;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class JpaPassengerDao extends GenericJpaDao<Passenger> implements PassengerDao {

    public JpaPassengerDao() {
        super(Passenger.class);
    }

    @Override
    public Passenger findByUsername(String username) throws PassengerNotFoundException {
        String jpql = "SELECT p FROM Passenger p WHERE p.username = :username";
        Query query = em.createQuery(jpql, Passenger.class);
        query.setParameter("username", username);
        try {
            return (Passenger) query.getSingleResult();
        } catch (NoResultException e) {
           throw new PassengerNotFoundException();
        }
    }
}
