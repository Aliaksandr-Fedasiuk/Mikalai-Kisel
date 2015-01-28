package com.epam.cdp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.cdp.model.Hotel;
import com.epam.cdp.service.HotelService;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 25 Jan, 2015
 */
@Controller
@RequestMapping(value = "/hotels")
public class HotelController {

    @Resource
    private HotelService hotelService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showSaveForm(Model model) {
        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);
        return "hotels/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(Hotel hotel) {
        hotelService.save(hotel);
        return "redirect:/hotels";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Hotel> hotels = hotelService.findAll();
        model.addAttribute("hotels", hotels);
        return "hotels/list";
    }

    @RequestMapping(value = "/{hotelId}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable("hotelId") Long id, Model model) {
        Hotel hotel = hotelService.findById(id);
        model.addAttribute("hotel", hotel);
        return "hotels/edit";
    }

    @RequestMapping(value = "/{hotelId}", method = RequestMethod.POST)
    public String update(Hotel hotel, Model model) {
        hotelService.save(hotel);
        return "redirect:/hotels";
    }

}
