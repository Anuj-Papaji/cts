package com.model;

public class Package {
	private String packageId, source, destination;
	private double basicFare,package_cost;
	private int noOFDays;
	
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getBasicFare() {
		return basicFare;
	}
	public void setBasicFare(double basicFare) {
		this.basicFare = basicFare;
	}
	public int getNoOFDays() {
		return noOFDays;
	}
	public void setNoOFDays(int noOFDays) {
		this.noOFDays = noOFDays;
	}
	public double getPackage_cost() {
		return package_cost;
	}
	public void setPackage_cost(double package_cost) {
		this.package_cost = package_cost;
	}
	public Package(String packageId, String source, String destination, double basicFare, int noOFDays, double package_cost) {
		super();
		this.packageId = packageId;
		this.source = source;
		this.destination = destination;
		this.basicFare = basicFare;
		this.package_cost = package_cost;
		this.noOFDays = noOFDays;
	}
	
	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", source=" + source + ", destination=" + destination
				+ ", basicFare=" + basicFare + ", package_cost=" + package_cost + ", noOFDays=" + noOFDays + "]";
	}
	
	
	
}
