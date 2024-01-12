package com.liftOff.LiftOff.persistence.dao.jpa;
import com.liftOff.LiftOff.persistence.dao.SeatDao;
import com.liftOff.LiftOff.persistence.model.Seat;
import org.springframework.stereotype.Repository;

@Repository
public class JpaSeatDao extends GenericJpaDao<Seat> implements SeatDao {
    public JpaSeatDao() {
        super(Seat.class);
    }
}
