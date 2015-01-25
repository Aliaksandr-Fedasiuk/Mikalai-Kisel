package com.epam.cdp.service;

import com.epam.cdp.model.Hotel;

import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 25 Jan, 2015
 */
public interface HotelService {

    public void save(final Hotel hotel);

    public Hotel findById(final Long id);

    public List<Hotel> findAll();
}
