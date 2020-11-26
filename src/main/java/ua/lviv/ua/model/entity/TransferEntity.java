package ua.lviv.ua.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

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
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		TransferEntity that = (TransferEntity) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (amount != null ? !amount.equals(that.amount) : that.amount != null)
			return false;
		if (date != null ? !date.equals(that.date) : that.date != null)
			return false;
		if (time != null ? !time.equals(that.time) : that.time != null)
			return false;
		if (purposeOfPayment != null ? !purposeOfPayment.equals(that.purposeOfPayment) : that.purposeOfPayment != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (amount != null ? amount.hashCode() : 0);
		result = 31 * result + (date != null ? date.hashCode() : 0);
		result = 31 * result + (time != null ? time.hashCode() : 0);
		result = 31 * result + (purposeOfPayment != null ? purposeOfPayment.hashCode() : 0);
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
		return "TransferEntity [id=" + id + ", amount=" + amount + ", date=" + date + ", time=" + time
				+ ", purposeOfPayment=" + purposeOfPayment + ", accountBySenderAccountId=" + accountBySenderAccountId
				+ ", accountByRecipientAccountId=" + accountByRecipientAccountId + ", currencyByCurrencyId="
				+ currencyByCurrencyId + "]";
	}
}
