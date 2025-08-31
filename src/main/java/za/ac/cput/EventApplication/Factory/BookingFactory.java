package za.ac.cput.EventApplication.Factory;
import za.ac.cput.EventApplication.models.Booking;
import za.ac.cput.EventApplication.util.Helper;

import java.time.LocalDateTime;


public class BookingFactory {

        public static  Booking createBooking(long customerID, long ticketID, LocalDateTime bookingDate,
                                             String status){
            if (Helper.isZeroOrNullLong(customerID)
                    || Helper.isZeroOrNullLong(ticketID) || Helper.isNullorEmpty(status))
                    throw new IllegalArgumentException("Invalid input for creating a booking");
            return new Booking.Builder().setCustomerID(customerID).setTicketID(ticketID)
                    .setBookingDate(bookingDate).setStatus(status).build();


        }
}
