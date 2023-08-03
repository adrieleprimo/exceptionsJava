package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExceptions;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout){
		if(!checkout.after(checkin)) {
			throw new DomainExceptions("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public static SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy");

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	public long duration() {
		long diff = checkout.getTime()-checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	
	
	public void updateDates(Date checkin, Date checkout){
		Date now = new Date();
		if(checkin.before(now) || checkout.before(now)) {
			throw new DomainExceptions("Reservation dates for update must be future dates");
		}
		if(!checkout.after(checkin)) {
			throw new DomainExceptions("Check-out date must be after check-in date");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "Room " +
	roomNumber +
	", check-in: " +
	dates.format(checkin) + ", check-out: " + dates.format(checkout) +
	", " + duration() + " nights\n";
	}
	
	
	
	
	
}
