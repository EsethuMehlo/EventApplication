// booking-form.ts
import { Component, Input } from '@angular/core';
import { Booking, BookingService } from '../booking.service';

@Component({
  selector: 'app-booking-form',
  templateUrl: './booking-form.html'
})
export class BookingFormComponent {

  booking: Booking = { customerName: '', ticketType: '' };
  @Input() editingBooking: Booking | null = null;

  constructor(private bookingService: BookingService) {}

  submit(): void {
    if (this.editingBooking) return;
    this.bookingService.createBooking(this.booking)
      .subscribe(() => this.booking = { customerName: '', ticketType: '' });
  }
}
