package za.ac.cput.EventApplication.services;

import org.springframework.stereotype.Service;
import za.ac.cput.EventApplication.models.Booking;

import java.util.List;

@Service
public interface iService <Booking, Long>{


    Booking create(Booking booking);

    Booking read(Booking booking);

    Booking update(Booking booking);

    void delete(Long id);

    List<Booking> getAll(Booking booking);
}
