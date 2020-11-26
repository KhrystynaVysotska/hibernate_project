package ua.lviv.ua.model.entity;

import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank", schema = "vysotska", catalog = "")
public class BankEntity {
	private Integer identificationCode;
	private Integer stateRegistrationCode;
	private String fullBankName;
	private String shortBankName;
	private Integer bankLicenseNumber;
	private Date bankLicenseDate;

	@Id
	@Column(name = "identification_code")
	public Integer getIdentificationCode() {
		return identificationCode;
	}

	public void setIdentificationCode(Integer identificationCode) {
		this.identificationCode = identificationCode;
	}

	@Basic
	@Column(name = "state_registration_code")
	public Integer getStateRegistrationCode() {
		return stateRegistrationCode;
	}

	public void setStateRegistrationCode(Integer stateRegistrationCode) {
		this.stateRegistrationCode = stateRegistrationCode;
	}

	@Basic
	@Column(name = "full_bank_name")
	public String getFullBankName() {
		return fullBankName;
	}

	public void setFullBankName(String fullBankName) {
		this.fullBankName = fullBankName;
	}

	@Basic
	@Column(name = "short_bank_name")
	public String getShortBankName() {
		return shortBankName;
	}

	public void setShortBankName(String shortBankName) {
		this.shortBankName = shortBankName;
	}

	@Basic
	@Column(name = "bank_license_number")
	public Integer getBankLicenseNumber() {
		return bankLicenseNumber;
	}

	public void setBankLicenseNumber(Integer bankLicenseNumber) {
		this.bankLicenseNumber = bankLicenseNumber;
	}

	@Basic
	@Column(name = "bank_license_date")
	public Date getBankLicenseDate() {
		return (Date) bankLicenseDate.clone();
	}

	public void setBankLicenseDate(Date bankLicenseDate) {
		this.bankLicenseDate = (Date) bankLicenseDate.clone();
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
		BankEntity other = (BankEntity) obj;
		if (bankLicenseDate == null) {
			if (other.bankLicenseDate != null) {
				return false;
			}
		} else if (!bankLicenseDate.equals(other.bankLicenseDate)) {
			return false;
		}
		if (bankLicenseNumber == null) {
			if (other.bankLicenseNumber != null) {
				return false;
			}
		} else if (!bankLicenseNumber.equals(other.bankLicenseNumber)) {
			return false;
		}
		if (fullBankName == null) {
			if (other.fullBankName != null) {
				return false;
			}
		} else if (!fullBankName.equals(other.fullBankName)) {
			return false;
		}
		if (identificationCode == null) {
			if (other.identificationCode != null) {
				return false;
			}
		} else if (!identificationCode.equals(other.identificationCode)) {
			return false;
		}
		if (shortBankName == null) {
			if (other.shortBankName != null) {
				return false;
			}
		} else if (!shortBankName.equals(other.shortBankName)) {
			return false;
		}
		if (stateRegistrationCode == null) {
			if (other.stateRegistrationCode != null) {
				return false;
			}
		} else if (!stateRegistrationCode.equals(other.stateRegistrationCode)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankLicenseDate == null) ? 0 : bankLicenseDate.hashCode());
		result = prime * result + ((bankLicenseNumber == null) ? 0 : bankLicenseNumber.hashCode());
		result = prime * result + ((fullBankName == null) ? 0 : fullBankName.hashCode());
		result = prime * result + ((identificationCode == null) ? 0 : identificationCode.hashCode());
		result = prime * result + ((shortBankName == null) ? 0 : shortBankName.hashCode());
		result = prime * result + ((stateRegistrationCode == null) ? 0 : stateRegistrationCode.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "BankEntity [identificationCode=" + identificationCode + ", stateRegistrationCode="
				+ stateRegistrationCode + ", fullBankName=" + fullBankName + ", shortBankName=" + shortBankName
				+ ", bankLicenseNumber=" + bankLicenseNumber + ", bankLicenseDate=" + bankLicenseDate + "]";
	}
}
