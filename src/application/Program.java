package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat date = new SimpleDateFormat ("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = date.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = date.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.print("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter  data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = date.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = date.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.print("Reservation: "+ reservation);
		}
		catch (ParseException e) {
			System.out.print("Invalid date format");
		}
		catch (DomainExceptions e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}
}
