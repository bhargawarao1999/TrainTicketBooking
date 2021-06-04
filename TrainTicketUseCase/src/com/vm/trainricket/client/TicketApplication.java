package com.vm.trainricket.client;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.vm.trainricket.service.ITicketService;
import com.vm.trainricket.service.TicketService;
import com.vm.trainricket.util.DBConnection;
import com.vm.trainticket.bean.Passenger;
import com.vm.trainticket.bean.Ticket;
import com.vm.trainticket.bean.TrainAvailability;
import com.vm.trainticket.bean.TravelDate;

public class TicketApplication 
{
	public static void main(String[] args) throws Exception
	{
		Connection con = DBConnection.getConnection();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter The Train Number ");
		int trainNumber = input.nextInt();
		int numberOfPassengers;
		int passengerAge;
		String passengerName;
		char gender;
		if(TrainAvailability.trainPresent(con, trainNumber))
		{
			System.out.println("Enter Travel Date: ");
			String bookingDateString=input.next();
			LocalDate today = LocalDate.now();
			if(TravelDate.travelDate(bookingDateString))
			{
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate bookingDate = LocalDate.parse(bookingDateString,dtf);
				ITicketService ticketService = new TicketService(bookingDate);
				System.out.println("Enter Number of Passengers: ");
				numberOfPassengers=input.nextInt();
				while(numberOfPassengers--!=0)
				{
					System.out.println("Enter Passenger Name: ");
					passengerName=input.next();
					System.out.println("Enter Age: ");
					passengerAge=input.nextInt();
					System.out.println("Enter Gender(M/F)");
					gender=input.next().charAt(0);
					ticketService.addPassenger(passengerName, passengerAge, gender, trainNumber);
				}
				ticketService.issueTicket(bookingDateString, trainNumber);
			}
			else
				System.out.println("Travel Date is before current date");
		}
		else
			System.out.println("Train with given train number does not exist");
	}
}