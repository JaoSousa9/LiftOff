package com.liftOff.LiftOff.persistence.dao.jpa;
import com.liftOff.LiftOff.persistence.dao.AssignedSeatDao;
import com.liftOff.LiftOff.persistence.model.AssignedSeat;
import org.springframework.stereotype.Repository;

@Repository
public class JpaAssignedSeatDao extends GenericJpaDao<AssignedSeat> implements AssignedSeatDao {

    public JpaAssignedSeatDao() {super(AssignedSeat.class);}

}
