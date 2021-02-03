package dtos;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "engine")
@XmlAccessorType(XmlAccessType.FIELD)
public class Engine implements Serializable {
	@XmlElement(name = "cubature")
	private Double cubature;

	@XmlAttribute(name = "code")
	private String code;

	public Double getCubature() {
		return cubature;
	}

	public void setCubature(Double cubature) {
		this.cubature = cubature;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}