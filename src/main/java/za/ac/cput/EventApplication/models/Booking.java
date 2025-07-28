package za.ac.cput.EventApplication.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Entity
@Table(name = "Booking")
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;

    private long customerID;
    private long ticketID;
    private LocalDateTime bookingDate;
    private String status;

    protected Booking() {

    }

    public Booking( Builder build) {
        this.customerID = build.customerID;;
        this.ticketID = build.ticketID;
        this.bookingDate = build.bookingDate;
        this.status = build.status;
    }

    public long getCustomerID() {
        return customerID;
    }

    public long getTicketID() {
        return ticketID;
    }
    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                ", customerID=" + customerID +
                ", ticketID=" + ticketID +
                ", bookingDate=" + bookingDate +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder{
        private long customerID;
        private long ticketID;
        private LocalDateTime bookingDate  ;
        private String status;

        public Builder(String bookingID, long customerID, long ticketID, LocalDateTime bookingDate, String status) {
            this.customerID = customerID;
            this.ticketID = ticketID;
            this.bookingDate = bookingDate;
            this.status = status;
        }

        public Builder() {

        }



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
            this.customerID = customerID;
            this.ticketID = ticketID;
            this.bookingDate = bookingDate;
            this.status = status;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }


}
