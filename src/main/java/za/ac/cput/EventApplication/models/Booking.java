package za.ac.cput.EventApplication.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Booking")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;

    private long customerID;
    private long ticketID;
    private LocalDateTime bookingDate;
    private String status;

    public Booking(Builder builder) {
        this.customerID = builder.customerID;
        this.ticketID = builder.ticketID;
        this.bookingDate = builder.bookingDate;
        this.status = builder.status;
    }

    public static class Builder {
        private long customerID;
        private long ticketID;
        private LocalDateTime bookingDate;
        private String status;

        public Builder setCustomerID(long customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setTicketID(long ticketID) {
            this.ticketID = ticketID;
            return this;
        }

        public Builder setBookingDate(LocalDateTime bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(Booking booking) {
            this.customerID = booking.getCustomerID();
            this.ticketID = booking.getTicketID();
            this.bookingDate = booking.getBookingDate();
            this.status = booking.getStatus();
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }

    @Override
    public String toString() {
        return "BookingService{" +
                "bookingId=" + bookingId +
                ", customerID=" + customerID +
                ", ticketID=" + ticketID +
                ", bookingDate=" + bookingDate +
                ", status='" + status + '\'' +
                '}';
    }
}
