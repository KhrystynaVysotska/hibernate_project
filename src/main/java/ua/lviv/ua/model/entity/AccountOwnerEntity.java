package ua.lviv.ua.model.entity;

import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;

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
		return (Date) birthDate.clone();
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = (Date) birthDate.clone();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AccountOwnerEntity other = (AccountOwnerEntity) obj;
		if (adressByAdressId == null) {
			if (other.adressByAdressId != null) {
				return false;
			}
		} else if (!adressByAdressId.equals(other.adressByAdressId)) {
			return false;
		}
		if (birthDate == null) {
			if (other.birthDate != null) {
				return false;
			}
		} else if (!birthDate.equals(other.birthDate)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (mobileNumber == null) {
			if (other.mobileNumber != null) {
				return false;
			}
		} else if (!mobileNumber.equals(other.mobileNumber)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (patronym == null) {
			if (other.patronym != null) {
				return false;
			}
		} else if (!patronym.equals(other.patronym)) {
			return false;
		}
		if (personalIdentificationNumber == null) {
			if (other.personalIdentificationNumber != null) {
				return false;
			}
		} else if (!personalIdentificationNumber.equals(other.personalIdentificationNumber)) {
			return false;
		}
		if (surname == null) {
			if (other.surname != null) {
				return false;
			}
		} else if (!surname.equals(other.surname)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adressByAdressId == null) ? 0 : adressByAdressId.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((patronym == null) ? 0 : patronym.hashCode());
		result = prime * result
				+ ((personalIdentificationNumber == null) ? 0 : personalIdentificationNumber.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
