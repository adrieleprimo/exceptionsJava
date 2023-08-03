package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat date = new SimpleDateFormat ("dd/MM/yyyy");
		System.out.print("Room number: ");
		Integer number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = date.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = date.parse(sc.next());
		if(!checkOut.after(checkIn)) {
			System.out.print("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.print("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter  data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = date.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = date.parse(sc.next());
			
			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.print("Error in reservation: " + error);
			}
			else {
				System.out.print("Reservation: "+ reservation);
			}
			
		}
		sc.close();
	}
}
