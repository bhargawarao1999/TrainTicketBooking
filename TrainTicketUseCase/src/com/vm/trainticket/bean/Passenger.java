package com.vm.trainticket.bean;

public class Passenger implements Comparable
{
	private String passengerName;
	private int passengerAge;
	private char passengerGender;
	public Passenger() {
		super();
	}
	public Passenger(String passengerName, int passengerAge, char passengerGender) {
		super();
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerGender = passengerGender;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public char getPassengerGender() {
		return passengerGender;
	}
	@Override
	public String toString() {
		return "Passenger [passengerName=" + passengerName + ", passengerAge=" + passengerAge + ", passengerGender="
				+ passengerGender + "]";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.passengerName.compareTo(this.getPassengerName());
	}
	
}