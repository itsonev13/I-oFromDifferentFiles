package dtos;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cars {
	@XmlElement(name = "car")
	private List<Car> entries;

	public List<Car> getEntries() {
		return entries;
	}

	public void setEntries(List<Car> entries) {
		this.entries = entries;
	}

}