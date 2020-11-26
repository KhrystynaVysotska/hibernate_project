package ua.lviv.ua.model.entity;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "city", schema = "vysotska", catalog = "")
public class CityEntity {
	private Integer id;
	private String name;
	private Integer zipCode;
	private String phoneCode;

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
	@NaturalId(mutable = true)
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "zip_code")
	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	@Basic
	@Column(name = "phone_code")
	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		CityEntity that = (CityEntity) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;
		if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null)
			return false;
		if (phoneCode != null ? !phoneCode.equals(that.phoneCode) : that.phoneCode != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
		result = 31 * result + (phoneCode != null ? phoneCode.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "CityEntity [id=" + id + ", name=" + name + ", zipCode=" + zipCode + ", phoneCode=" + phoneCode + "]";
	}
}
