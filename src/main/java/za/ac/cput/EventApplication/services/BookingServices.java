package za.ac.cput.EventApplication.services;

import org.springframework.stereotype.Service;
import za.ac.cput.EventApplication.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.EventApplication.repository.BookingRepo;
import java.util.List;

@Service
public class BookingServices implements iService <Booking, Long>{

    private final BookingRepo bookingRepository;

    @Autowired
    BookingServices(BookingRepo bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public BookingServices() {
    }

    @Override
    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking read(Booking booking) {
        Long id = booking.getBookingId();
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking update(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void delete(Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            System.out.println("Booking has been deleted");
        }
        else {
            System.out.println("Booking not found");
        }
        bookingRepository.deleteById(id);
    }

    @Override
    public List<Booking> getAll(Booking booking) {
        return bookingRepository.findAll();
    }
}
