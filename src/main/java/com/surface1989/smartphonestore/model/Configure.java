package com.surface1989.smartphonestore.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Configure {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "configureId")
	private Long id;
	
	@JoinColumn(name = "display")
	private String display;
	
	@JoinColumn(name = "os")
	private String os;
	
	@JoinColumn(name = "frontCamera")
	private String frontCamera;
	
	@JoinColumn(name = "rearCamera")
	private String rearCamera;
	
	@JoinColumn(name = "ram")
	private String ram;
	
	@JoinColumn(name = "rom")
	private String rom;
	
	@JoinColumn(name = "sim")
	private String sim;
	
	@JoinColumn(name = "battery")
	private String battery;
	
	@OneToOne(mappedBy = "configureOfProduct", fetch = FetchType.LAZY)
	private Product product;

	public Configure() {
		super();
	}

	public Configure(String display, String os, String frontCamera, String rearCamera, String ram, String rom,
			String sim, String battery, Product product) {
		super();
		this.display = display;
		this.os = os;
		this.frontCamera = frontCamera;
		this.rearCamera = rearCamera;
		this.ram = ram;
		this.rom = rom;
		this.sim = sim;
		this.battery = battery;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getFrontCamera() {
		return frontCamera;
	}

	public void setFrontCamera(String frontCamera) {
		this.frontCamera = frontCamera;
	}

	public String getRearCamera() {
		return rearCamera;
	}

	public void setRearCamera(String rearCamera) {
		this.rearCamera = rearCamera;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
