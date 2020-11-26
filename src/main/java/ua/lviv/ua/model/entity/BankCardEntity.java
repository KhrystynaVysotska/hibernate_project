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
import ua.lviv.ua.model.entity.formatter.Formatter;

@Entity
@Table(name = "bank_card", schema = "vysotska", catalog = "")
public class BankCardEntity {
	private Integer id;
	private Integer cvc2 = 0;
	private Date dateOfExpire;
	private AccountEntity accountByAccountId;
	private CardTypeEntity cardTypeByCardTypeId;

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
	@Column(name = "cvc2")
	public Integer getCvc2() {
		return cvc2;
	}

	public void setCvc2(Integer cvc2) {
		this.cvc2 = cvc2;
	}

	@Basic
	@Column(name = "date_of_expire")
	public Date getDateOfExpire() {
		return (Date) dateOfExpire.clone();
	}

	public void setDateOfExpire(Date dateOfExpire) {
		this.dateOfExpire = (Date) dateOfExpire.clone();
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
		BankCardEntity other = (BankCardEntity) obj;
		if (accountByAccountId == null) {
			if (other.accountByAccountId != null) {
				return false;
			}
		} else if (!accountByAccountId.equals(other.accountByAccountId)) {
			return false;
		}
		if (cardTypeByCardTypeId == null) {
			if (other.cardTypeByCardTypeId != null) {
				return false;
			}
		} else if (!cardTypeByCardTypeId.equals(other.cardTypeByCardTypeId)) {
			return false;
		}
		if (cvc2 == null) {
			if (other.cvc2 != null) {
				return false;
			}
		} else if (!cvc2.equals(other.cvc2)) {
			return false;
		}
		if (dateOfExpire == null) {
			if (other.dateOfExpire != null) {
				return false;
			}
		} else if (!dateOfExpire.equals(other.dateOfExpire)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountByAccountId == null) ? 0 : accountByAccountId.hashCode());
		result = prime * result + ((cardTypeByCardTypeId == null) ? 0 : cardTypeByCardTypeId.hashCode());
		result = prime * result + ((cvc2 == null) ? 0 : cvc2.hashCode());
		result = prime * result + ((dateOfExpire == null) ? 0 : dateOfExpire.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
	public AccountEntity getAccountByAccountId() {
		return accountByAccountId;
	}

	public void setAccountByAccountId(AccountEntity accountByAccountId) {
		this.accountByAccountId = accountByAccountId;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "card_type_id", referencedColumnName = "id")
	public CardTypeEntity getCardTypeByCardTypeId() {
		return cardTypeByCardTypeId;
	}

	public void setCardTypeByCardTypeId(CardTypeEntity cardTypeByCardTypeId) {
		this.cardTypeByCardTypeId = cardTypeByCardTypeId;
	}

	@Override
	public String toString() {
		String[] columnsNames = { "bank_card_id", "account_number", "card_type", "cvc2", "date_of_expire" };
		String[] columnValues = { id.toString(), accountByAccountId.getCurrentAccountNumber(),
				cardTypeByCardTypeId.getName(), cvc2 == null ? "null" : cvc2.toString(), dateOfExpire.toString() };
		return Formatter.formatRow(columnsNames, columnValues);
	}
}
