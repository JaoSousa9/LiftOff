package com.liftOff.LiftOff.persistence.dao.jpa;
import com.liftOff.LiftOff.persistence.dao.FlightDao;
import com.liftOff.LiftOff.persistence.model.Flight;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaFlightDao extends GenericJpaDao<Flight> implements FlightDao {

    public JpaFlightDao() {
        super(Flight.class);
    }
    @PersistenceContext
    protected EntityManager em;

    @Override
    public List<Flight> searchFlightOriginDestinyDate(String origin, String destiny, String date) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Flight> criteria = cb.createQuery(Flight.class);
        Root<Flight> flight = criteria.from(Flight.class);
        Query query = em.createQuery(criteria.select(flight).where(cb.and(cb.equal(flight.get("origin"),origin),cb.equal(flight.get("destiny"),destiny),cb.equal(flight.get("date"),date))));

        return query.getResultList();
    }

    @Override
    public List<Flight> searchFlightOriginDestinyPrice(String origin, String destiny, Integer price) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Flight> criteria = cb.createQuery(Flight.class);
        Root<Flight> flight = criteria.from(Flight.class);
        Query query = em.createQuery(criteria.select(flight).where(cb.and(cb.equal(flight.get("origin"),origin),cb.equal(flight.get("destiny"),destiny),cb.lessThanOrEqualTo(flight.get("price"),price))));

        return query.getResultList();
    }
}
