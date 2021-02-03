package dtos;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
public class Students {
	@XmlElement(name = "student")
	private List<Student> entries;

	public List<Student> getEntries() {
		return entries;
	}

	public void setEntries(List<Student> entries) {
		this.entries = entries;
	}

}
