package com.vm.trainricket.service;

import java.time.LocalDate;

import com.vm.trainricket.dao.ITicketDao;
import com.vm.trainricket.dao.TicketDao;

public class TicketService implements ITicketService {
	
	ITicketDao ticketDao;
	public TicketService(LocalDate bookingDate) {
		super();
		this.ticketDao =  new TicketDao(bookingDate);
	}

	@Override
	public void addPassenger(String passengerName, int passengerAge, char passengerGender, int trainNumber) {
		// TODO Auto-generated method stub
		ticketDao.addPassenger(passengerName, passengerAge, passengerGender, trainNumber);
	}

	@Override
	public void issueTicket(String bookingDateString, int trainNumber) throws Exception {
		ticketDao.issueTicket(bookingDateString, trainNumber);
		
	}

}