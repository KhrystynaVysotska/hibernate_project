package ua.lviv.ua.model.entity;

import javax.persistence.*;
import java.sql.Date;

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
		return bankLicenseDate;
	}

	public void setBankLicenseDate(Date bankLicenseDate) {
		this.bankLicenseDate = bankLicenseDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		BankEntity that = (BankEntity) o;

		if (identificationCode != null ? !identificationCode.equals(that.identificationCode)
				: that.identificationCode != null)
			return false;
		if (stateRegistrationCode != null ? !stateRegistrationCode.equals(that.stateRegistrationCode)
				: that.stateRegistrationCode != null)
			return false;
		if (fullBankName != null ? !fullBankName.equals(that.fullBankName) : that.fullBankName != null)
			return false;
		if (shortBankName != null ? !shortBankName.equals(that.shortBankName) : that.shortBankName != null)
			return false;
		if (bankLicenseNumber != null ? !bankLicenseNumber.equals(that.bankLicenseNumber)
				: that.bankLicenseNumber != null)
			return false;
		if (bankLicenseDate != null ? !bankLicenseDate.equals(that.bankLicenseDate) : that.bankLicenseDate != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = identificationCode != null ? identificationCode.hashCode() : 0;
		result = 31 * result + (stateRegistrationCode != null ? stateRegistrationCode.hashCode() : 0);
		result = 31 * result + (fullBankName != null ? fullBankName.hashCode() : 0);
		result = 31 * result + (shortBankName != null ? shortBankName.hashCode() : 0);
		result = 31 * result + (bankLicenseNumber != null ? bankLicenseNumber.hashCode() : 0);
		result = 31 * result + (bankLicenseDate != null ? bankLicenseDate.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "BankEntity [identificationCode=" + identificationCode + ", stateRegistrationCode="
				+ stateRegistrationCode + ", fullBankName=" + fullBankName + ", shortBankName=" + shortBankName
				+ ", bankLicenseNumber=" + bankLicenseNumber + ", bankLicenseDate=" + bankLicenseDate + "]";
	}
}
