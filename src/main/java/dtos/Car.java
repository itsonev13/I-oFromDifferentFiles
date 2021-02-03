package dtos;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car implements Serializable {
	@XmlElement(name = "brand")
	private String brand;

	@XmlElement(name = "model")
	private String model;

	@XmlElement(name = "yearOfProduction")
	private Integer yearOfProduction;

	@XmlElement(name = "engine")
	private Engine engine;

	@XmlElement(name = "zerotosixty")
	private Double zeroToSixty;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(Integer yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Double getZeroToSixty() {
		return zeroToSixty;
	}

	public void setZeroToSixty(Double zeroToSixty) {
		this.zeroToSixty = zeroToSixty;
	}

}
