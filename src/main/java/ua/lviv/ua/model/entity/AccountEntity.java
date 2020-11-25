package ua.lviv.ua.model.entity;

import javax.persistence.*;

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
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		AccountEntity that = (AccountEntity) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (currentAccountNumber != null ? !currentAccountNumber.equals(that.currentAccountNumber)
				: that.currentAccountNumber != null)
			return false;
		if (amount != null ? !amount.equals(that.amount) : that.amount != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (currentAccountNumber != null ? currentAccountNumber.hashCode() : 0);
		result = 31 * result + (amount != null ? amount.hashCode() : 0);
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

	@ManyToOne
	@JoinColumn(name = "account_owner_id", referencedColumnName = "id", nullable = false)
	public AccountOwnerEntity getAccountOwnerByAccountOwnerId() {
		return accountOwnerByAccountOwnerId;
	}

	public void setAccountOwnerByAccountOwnerId(AccountOwnerEntity accountOwnerByAccountOwnerId) {
		this.accountOwnerByAccountOwnerId = accountOwnerByAccountOwnerId;
	}

	@ManyToOne
	@JoinColumn(name = "bank_identification_code", referencedColumnName = "identification_code", nullable = false)
	public BankEntity getBankByBankIdentificationCode() {
		return bankByBankIdentificationCode;
	}

	public void setBankByBankIdentificationCode(BankEntity bankByBankIdentificationCode) {
		this.bankByBankIdentificationCode = bankByBankIdentificationCode;
	}

	@ManyToOne
	@JoinColumn(name = "currency_id", referencedColumnName = "id")
	public CurrencyEntity getCurrencyByCurrencyId() {
		return currencyByCurrencyId;
	}

	public void setCurrencyByCurrencyId(CurrencyEntity currencyByCurrencyId) {
		this.currencyByCurrencyId = currencyByCurrencyId;
	}

	@ManyToOne
	@JoinColumn(name = "account_type_id", referencedColumnName = "id")
	public AccountTypeEntity getAccountTypeByAccountTypeId() {
		return accountTypeByAccountTypeId;
	}

	public void setAccountTypeByAccountTypeId(AccountTypeEntity accountTypeByAccountTypeId) {
		this.accountTypeByAccountTypeId = accountTypeByAccountTypeId;
	}
}
