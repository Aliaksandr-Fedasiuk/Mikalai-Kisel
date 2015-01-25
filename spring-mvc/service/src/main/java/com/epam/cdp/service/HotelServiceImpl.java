package com.epam.cdp.service;

import com.epam.cdp.dao.HotelRepository;
import com.epam.cdp.model.Hotel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 25 Jan, 2015
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Resource
    private HotelRepository hotelRepository;

    @Override
    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public Hotel findById(Long id) {
        return hotelRepository.findOne(id);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }
}
