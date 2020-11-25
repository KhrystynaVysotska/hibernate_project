package ua.lviv.ua.model.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "bank_card", schema = "vysotska", catalog = "")
public class BankCardEntity {
    private Integer id;
    private Integer cvc2;
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
        return dateOfExpire;
    }

    public void setDateOfExpire(Date dateOfExpire) {
        this.dateOfExpire = dateOfExpire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankCardEntity that = (BankCardEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cvc2 != null ? !cvc2.equals(that.cvc2) : that.cvc2 != null) return false;
        if (dateOfExpire != null ? !dateOfExpire.equals(that.dateOfExpire) : that.dateOfExpire != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cvc2 != null ? cvc2.hashCode() : 0);
        result = 31 * result + (dateOfExpire != null ? dateOfExpire.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    public AccountEntity getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(AccountEntity accountByAccountId) {
        this.accountByAccountId = accountByAccountId;
    }

    @ManyToOne
    @JoinColumn(name = "card_type_id", referencedColumnName = "id")
    public CardTypeEntity getCardTypeByCardTypeId() {
        return cardTypeByCardTypeId;
    }

    public void setCardTypeByCardTypeId(CardTypeEntity cardTypeByCardTypeId) {
        this.cardTypeByCardTypeId = cardTypeByCardTypeId;
    }
}
