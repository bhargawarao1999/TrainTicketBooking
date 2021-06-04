package com.vm.trainricket.service;

public interface ITicketService {

	public void addPassenger(String passengerName,int passengerAge,char passengerGender,int trainNumber);
	public void issueTicket(String bookingDateString,int trainNumber) throws Exception;
}