package com.liftOff.LiftOff.persistence.dao.jpa;
import com.liftOff.LiftOff.persistence.dao.ReservationDao;
import com.liftOff.LiftOff.persistence.model.Reservation;
import org.springframework.stereotype.Repository;

@Repository
public class JpaReservationDao extends GenericJpaDao<Reservation> implements ReservationDao {
    public JpaReservationDao() {
        super(Reservation.class);
    }

}
