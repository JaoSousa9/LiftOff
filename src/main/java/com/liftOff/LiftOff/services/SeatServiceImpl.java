package com.liftOff.LiftOff.services;

import com.liftOff.LiftOff.exceptions.SeatNotFoundException;
import com.liftOff.LiftOff.persistence.dao.SeatDao;
import com.liftOff.LiftOff.persistence.model.Seat;

import java.util.List;
import java.util.Optional;

// @Service
public class SeatServiceImpl implements SeatService {

    SeatDao seatDao;

    // @Autowired
    public void setSeatDao(SeatDao seatDao) {
        this.seatDao = seatDao;
    }

    @Override
    public Seat get(Integer id) {
        return seatDao.findById(id);
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatDao.findAll();
    }

    @Override
    public Seat saveOrUpdate(Seat seat) {
        return seatDao.saveOrUpdate(seat);
    }

    @Override
    public void delete(Integer id) throws SeatNotFoundException {
        Seat seat = Optional.ofNullable(seatDao.findById(id))
                .orElseThrow(SeatNotFoundException::new);

        seatDao.delete(id);
    }
}
