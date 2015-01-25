package com.epam.cdp.dao;

import com.epam.cdp.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 25 Jan, 2015
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
