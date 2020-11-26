package ua.lviv.ua.model.entity;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import ua.lviv.ua.model.entity.formatter.Formatter;

@Entity
@Table(name = "transfer", schema = "vysotska", catalog = "")
public class TransferEntity {
	private Integer id;
	private Integer amount;
	private Date date;
	private Time time;
	private String purposeOfPayment;
	private AccountEntity accountBySenderAccountId;
	private AccountEntity accountByRecipientAccountId;
	private CurrencyEntity currencyByCurrencyId;

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
	@Column(name = "amount")
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Basic
	@Column(name = "date")
	public Date getDate() {
		return (Date) date.clone();
	}

	public void setDate(Date date) {
		this.date = (Date) date.clone();
	}

	@Basic
	@Column(name = "time")
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Basic
	@Column(name = "purpose_of_payment")
	public String getPurposeOfPayment() {
		return purposeOfPayment;
	}

	public void setPurposeOfPayment(String purposeOfPayment) {
		this.purposeOfPayment = purposeOfPayment;
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
		TransferEntity other = (TransferEntity) obj;
		if (accountByRecipientAccountId == null) {
			if (other.accountByRecipientAccountId != null) {
				return false;
			}
		} else if (!accountByRecipientAccountId.equals(other.accountByRecipientAccountId)) {
			return false;
		}
		if (accountBySenderAccountId == null) {
			if (other.accountBySenderAccountId != null) {
				return false;
			}
		} else if (!accountBySenderAccountId.equals(other.accountBySenderAccountId)) {
			return false;
		}
		if (amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!amount.equals(other.amount)) {
			return false;
		}
		if (currencyByCurrencyId == null) {
			if (other.currencyByCurrencyId != null) {
				return false;
			}
		} else if (!currencyByCurrencyId.equals(other.currencyByCurrencyId)) {
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (purposeOfPayment == null) {
			if (other.purposeOfPayment != null) {
				return false;
			}
		} else if (!purposeOfPayment.equals(other.purposeOfPayment)) {
			return false;
		}
		if (time == null) {
			if (other.time != null) {
				return false;
			}
		} else if (!time.equals(other.time)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountByRecipientAccountId == null) ? 0 : accountByRecipientAccountId.hashCode());
		result = prime * result + ((accountBySenderAccountId == null) ? 0 : accountBySenderAccountId.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((currencyByCurrencyId == null) ? 0 : currencyByCurrencyId.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((purposeOfPayment == null) ? 0 : purposeOfPayment.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "sender_account_id", referencedColumnName = "id", nullable = false)
	public AccountEntity getAccountBySenderAccountId() {
		return accountBySenderAccountId;
	}

	public void setAccountBySenderAccountId(AccountEntity accountBySenderAccountId) {
		this.accountBySenderAccountId = accountBySenderAccountId;
	}

	@ManyToOne
	@JoinColumn(name = "recipient_account_id", referencedColumnName = "id", nullable = false)
	public AccountEntity getAccountByRecipientAccountId() {
		return accountByRecipientAccountId;
	}

	public void setAccountByRecipientAccountId(AccountEntity accountByRecipientAccountId) {
		this.accountByRecipientAccountId = accountByRecipientAccountId;
	}

	@ManyToOne
	@JoinColumn(name = "currency_id", referencedColumnName = "id")
	public CurrencyEntity getCurrencyByCurrencyId() {
		return currencyByCurrencyId;
	}

	public void setCurrencyByCurrencyId(CurrencyEntity currencyByCurrencyId) {
		this.currencyByCurrencyId = currencyByCurrencyId;
	}

	@Override
	public String toString() {
		String[] columnsNames = { "transfer_id", "sender_account_number", "recipient_account_number", "amount",
				"currency", "date", "time", "purpose_of_payment" };
		String[] columnValues = { id.toString(), accountBySenderAccountId.getCurrentAccountNumber(),
				accountByRecipientAccountId.getCurrentAccountNumber(), amount.toString(),
				currencyByCurrencyId.getName(), date.toString(), time.toString(),
				purposeOfPayment != null ? purposeOfPayment : "not specified" };
		return Formatter.formatRow(columnsNames, columnValues);
	}
}
