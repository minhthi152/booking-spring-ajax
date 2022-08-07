package com.tp.service.booking;

import com.tp.model.Booking;
import com.tp.model.dto.BookingDTO;
import com.tp.model.dto.CreateBookingDTO;
import com.tp.service.IGeneralService;

import java.util.List;

public interface IBookingService extends IGeneralService<Booking> {

    public List<CreateBookingDTO> findAllBookingDTO();

    Booking create(Booking booking);
}
