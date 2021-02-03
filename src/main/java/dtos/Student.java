package dtos;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student implements Serializable {
	@XmlElement(name = "name")

	private String name;

	@XmlElement(name = "age")

	private Integer age;

	@XmlElement(name = "avrageMarks")

	private Double avrageMarks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getAvrageMarks() {
		return avrageMarks;
	}

	public void setAvrageMarks(Double avrageMarks) {
		this.avrageMarks = avrageMarks;
	}

}
