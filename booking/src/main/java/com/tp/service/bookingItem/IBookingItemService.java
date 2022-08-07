package com.tp.service.bookingItem;

import com.tp.model.BookingItem;
import com.tp.model.dto.BookingItemDTO;
import com.tp.service.IGeneralService;

import java.util.List;

public interface IBookingItemService extends IGeneralService<BookingItem> {

    public List<BookingItemDTO> findAllBookingItemDTO(Long id);

    List<BookingItemDTO> findAllBookingItemDTOs();
}
