package ua.lviv.ua.model.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;
import ua.lviv.ua.model.entity.formatter.Formatter;

@Entity
@Table(name = "account", schema = "vysotska")
public class AccountEntity {
	private Integer id;
	private String currentAccountNumber;
	private Integer amount;
	private PinCodeEntity pinCodeByPinCodeId;
	private AccountOwnerEntity accountOwnerByAccountOwnerId;
	private BankEntity bankByBankIdentificationCode;
	private CurrencyEntity currencyByCurrencyId;
	private AccountTypeEntity accountTypeByAccountTypeId;

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
	@Column(name = "current_account_number")
	public String getCurrentAccountNumber() {
		return currentAccountNumber;
	}

	public void setCurrentAccountNumber(String currentAccountNumber) {
		this.currentAccountNumber = currentAccountNumber;
	}

	@Basic
	@Column(name = "amount")
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
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
		AccountEntity other = (AccountEntity) obj;
		if (accountOwnerByAccountOwnerId == null) {
			if (other.accountOwnerByAccountOwnerId != null) {
				return false;
			}
		} else if (!accountOwnerByAccountOwnerId.equals(other.accountOwnerByAccountOwnerId)) {
			return false;
		}
		if (accountTypeByAccountTypeId == null) {
			if (other.accountTypeByAccountTypeId != null) {
				return false;
			}
		} else if (!accountTypeByAccountTypeId.equals(other.accountTypeByAccountTypeId)) {
			return false;
		}
		if (amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!amount.equals(other.amount)) {
			return false;
		}
		if (bankByBankIdentificationCode == null) {
			if (other.bankByBankIdentificationCode != null) {
				return false;
			}
		} else if (!bankByBankIdentificationCode.equals(other.bankByBankIdentificationCode)) {
			return false;
		}
		if (currencyByCurrencyId == null) {
			if (other.currencyByCurrencyId != null) {
				return false;
			}
		} else if (!currencyByCurrencyId.equals(other.currencyByCurrencyId)) {
			return false;
		}
		if (currentAccountNumber == null) {
			if (other.currentAccountNumber != null) {
				return false;
			}
		} else if (!currentAccountNumber.equals(other.currentAccountNumber)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (pinCodeByPinCodeId == null) {
			if (other.pinCodeByPinCodeId != null) {
				return false;
			}
		} else if (!pinCodeByPinCodeId.equals(other.pinCodeByPinCodeId)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountOwnerByAccountOwnerId == null) ? 0 : accountOwnerByAccountOwnerId.hashCode());
		result = prime * result + ((accountTypeByAccountTypeId == null) ? 0 : accountTypeByAccountTypeId.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result
				+ ((bankByBankIdentificationCode == null) ? 0 : bankByBankIdentificationCode.hashCode());
		result = prime * result + ((currencyByCurrencyId == null) ? 0 : currencyByCurrencyId.hashCode());
		result = prime * result + ((currentAccountNumber == null) ? 0 : currentAccountNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pinCodeByPinCodeId == null) ? 0 : pinCodeByPinCodeId.hashCode());
		return result;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pin_code_id", referencedColumnName = "id", nullable = false)
	public PinCodeEntity getPinCodeByPinCodeId() {
		return pinCodeByPinCodeId;
	}

	public void setPinCodeByPinCodeId(PinCodeEntity pinCodeByPinCodeId) {
		this.pinCodeByPinCodeId = pinCodeByPinCodeId;
	}

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(name = "account_owner_id", referencedColumnName = "id", nullable = false)
	public AccountOwnerEntity getAccountOwnerByAccountOwnerId() {
		return accountOwnerByAccountOwnerId;
	}

	public void setAccountOwnerByAccountOwnerId(AccountOwnerEntity accountOwnerByAccountOwnerId) {
		this.accountOwnerByAccountOwnerId = accountOwnerByAccountOwnerId;
	}

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(name = "bank_identification_code", referencedColumnName = "identification_code", nullable = false)
	public BankEntity getBankByBankIdentificationCode() {
		return bankByBankIdentificationCode;
	}

	public void setBankByBankIdentificationCode(BankEntity bankByBankIdentificationCode) {
		this.bankByBankIdentificationCode = bankByBankIdentificationCode;
	}

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(name = "currency_id", referencedColumnName = "id")
	public CurrencyEntity getCurrencyByCurrencyId() {
		return currencyByCurrencyId;
	}

	public void setCurrencyByCurrencyId(CurrencyEntity currencyByCurrencyId) {
		this.currencyByCurrencyId = currencyByCurrencyId;
	}

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(name = "account_type_id", referencedColumnName = "id")
	public AccountTypeEntity getAccountTypeByAccountTypeId() {
		return accountTypeByAccountTypeId;
	}

	public void setAccountTypeByAccountTypeId(AccountTypeEntity accountTypeByAccountTypeId) {
		this.accountTypeByAccountTypeId = accountTypeByAccountTypeId;
	}

	@Override
	public String toString() {
		String[] columnsNames = { "account_id", "pin_code", "current_account_number", "amount", "account_owner",
				"bank", "currency", "account_type" };
		String[] columnValues = { id.toString(), pinCodeByPinCodeId.getPin(), currentAccountNumber, amount.toString(),
				accountOwnerByAccountOwnerId.getName() + " " + accountOwnerByAccountOwnerId.getSurname(),
				bankByBankIdentificationCode.getShortBankName(), currencyByCurrencyId.getName(),
				accountTypeByAccountTypeId.getType() };
		return Formatter.formatRow(columnsNames, columnValues);
	}
}
