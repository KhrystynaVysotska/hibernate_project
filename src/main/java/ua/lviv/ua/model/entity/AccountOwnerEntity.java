package ua.lviv.ua.model.entity;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

import java.sql.Date;

@Entity
@Table(name = "account_owner", schema = "vysotska", catalog = "")
public class AccountOwnerEntity {
	private Integer id;
	private String personalIdentificationNumber;
	private String name;
	private String surname;
	private String patronym;
	private String mobileNumber;
	private String email;
	private Date birthDate;
	private AdressEntity adressByAdressId;

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
	@Column(name = "personal_identification_number")
	public String getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}

	public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}

	@Basic
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "surname")
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Basic
	@Column(name = "patronym")
	public String getPatronym() {
		return patronym;
	}

	public void setPatronym(String patronym) {
		this.patronym = patronym;
	}

	@Basic
	@Column(name = "mobile_number")
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Basic
	@Column(name = "email")
	@NaturalId
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic
	@Column(name = "birth_date")
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		AccountOwnerEntity that = (AccountOwnerEntity) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (personalIdentificationNumber != null
				? !personalIdentificationNumber.equals(that.personalIdentificationNumber)
				: that.personalIdentificationNumber != null)
			return false;
		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;
		if (surname != null ? !surname.equals(that.surname) : that.surname != null)
			return false;
		if (patronym != null ? !patronym.equals(that.patronym) : that.patronym != null)
			return false;
		if (mobileNumber != null ? !mobileNumber.equals(that.mobileNumber) : that.mobileNumber != null)
			return false;
		if (email != null ? !email.equals(that.email) : that.email != null)
			return false;
		if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (personalIdentificationNumber != null ? personalIdentificationNumber.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (surname != null ? surname.hashCode() : 0);
		result = 31 * result + (patronym != null ? patronym.hashCode() : 0);
		result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
		return result;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adress_id", referencedColumnName = "id")
	public AdressEntity getAdressByAdressId() {
		return adressByAdressId;
	}

	public void setAdressByAdressId(AdressEntity adressByAdressId) {
		this.adressByAdressId = adressByAdressId;
	}

	@Override
	public String toString() {
		return "AccountOwnerEntity [id=" + id + ", personalIdentificationNumber=" + personalIdentificationNumber
				+ ", name=" + name + ", surname=" + surname + ", patronym=" + patronym + ", mobileNumber="
				+ mobileNumber + ", email=" + email + ", birthDate=" + birthDate + ", adressByAdressId="
				+ adressByAdressId + "]";
	}
}
