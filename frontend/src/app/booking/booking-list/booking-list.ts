// booking-list.ts
import { Component, OnInit } from '@angular/core';
import { Booking, BookingService } from '../booking.service';

@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list'
})
export class BookingListComponent implements OnInit {

  bookings: Booking[] = [];
  editingBooking: Booking | null = null;

  constructor(private bookingService: BookingService) {}

  ngOnInit(): void {
    this.loadBookings();
  }

  loadBookings() {
    this.bookingService.getBookings().subscribe(data => this.bookings = data);
  }

  editBooking(booking: Booking) {
    this.editingBooking = { ...booking };
  }

  saveBooking() {
    if (this.editingBooking && this.editingBooking.id) {
      this.bookingService.updateBooking(this.editingBooking.id, this.editingBooking)
        .subscribe(() => {
          this.editingBooking = null;
          this.loadBookings();
        });
    }
  }

  deleteBooking(id: number) {
    if (confirm('Are you sure you want to delete this booking?')) {
      this.bookingService.deleteBooking(id).subscribe(() => this.loadBookings());
    }
  }
}
