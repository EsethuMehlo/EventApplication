package za.ac.cput.EventApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.EventApplication.models.Booking;
import za.ac.cput.EventApplication.repository.BookingRepo;
import za.ac.cput.EventApplication.services.BookingServices;
import za.ac.cput.EventApplication.services.iService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookingController extends BookingServices {

    @Autowired
    private BookingRepo bookingRepo;
    private BookingServices bookingServices;

    public ResponseEntity<List<Booking>> getAllBookings(){
        try {

            List<Booking> bookingList = new ArrayList<>();
            bookingRepo.findAll().forEach(bookingList::add);

            if (bookingList.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            return new ResponseEntity<>(HttpStatus.OK);

        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getBookingById")
    public ResponseEntity<Booking> getAllBookingByCustomerName(@PathVariable Long
                                                               bookingId) {

        Optional<Booking> bookingData = bookingRepo.findById(bookingId);

        if (bookingData.isPresent()) {
            return new ResponseEntity<>(bookingData.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {

        return new ResponseEntity<>(bookingServices.create(booking), HttpStatus.OK);


    }

    @PostMapping("/updateBookById/{id}")
    public ResponseEntity<Booking> updateBookingByID(@PathVariable Long id, @RequestBody Booking bookingdata) {
        Optional<Booking> bookingData = bookingRepo.findById(id);
        if (bookingData.isPresent()) {
            Booking updatedBookingData = bookingData.get();
            updatedBookingData.setBookingDate(bookingdata.getBookingDate());
            updatedBookingData.setTicketID(bookingdata.getTicketID());
            updatedBookingData.setCustomerID(bookingdata.getCustomerID());
            Booking bookingObj = bookingRepo.save(updatedBookingData);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("deleteBookingById/{id}")
    public ResponseEntity<HttpStatus> deleteBookingById(@PathVariable Long id) {
        bookingRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
