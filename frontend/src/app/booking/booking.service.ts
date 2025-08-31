import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface BookingService {
  id?: number;
  customerName: string;
  ticketType: string;
}

@Injectable({
  providedIn: 'root'
})
export class Booking {
  private apiUrl = 'http://localhost:8080/api/bookings';

  constructor(private http: HttpClient) { }

  getBookings(): Observable<BookingService[]> {
    return this.http.get<BookingService[]>(this.apiUrl);
  }

  createBooking(booking: BookingService): Observable<BookingService> {
    return this.http.post<BookingService>(this.apiUrl, booking);
  }

  updateBooking(id: number, booking: BookingService): Observable<BookingService> {
    return this.http.put<BookingService>(`${this.apiUrl}/${id}`, booking);
  }

  deleteBooking(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}

