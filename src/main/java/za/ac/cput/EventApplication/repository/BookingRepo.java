package za.ac.cput.EventApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.EventApplication.models.Booking;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {

    List<Booking> getAllBookingByCustomerName(String customerName);
    List<Booking> getAllBookingByCustomerNameAndDate(String customerName,String date);

}
