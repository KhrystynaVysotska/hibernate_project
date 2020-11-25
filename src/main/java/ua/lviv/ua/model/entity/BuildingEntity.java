package ua.lviv.ua.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "building", schema = "vysotska", catalog = "")
public class BuildingEntity {
	private Integer id;
	private String houseNumber;
	private String flatNumber;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "house_number")
	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	@Basic
	@Column(name = "flat_number")
	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		BuildingEntity that = (BuildingEntity) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (houseNumber != null ? !houseNumber.equals(that.houseNumber) : that.houseNumber != null)
			return false;
		if (flatNumber != null ? !flatNumber.equals(that.flatNumber) : that.flatNumber != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (houseNumber != null ? houseNumber.hashCode() : 0);
		result = 31 * result + (flatNumber != null ? flatNumber.hashCode() : 0);
		return result;
	}
}
