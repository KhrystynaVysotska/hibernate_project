package ua.lviv.ua.model.entity;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "account_type", schema = "vysotska", catalog = "")
public class AccountTypeEntity {
	private Integer id;
	private String type;

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
	@Column(name = "type")
	@NaturalId(mutable = true)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		AccountTypeEntity that = (AccountTypeEntity) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (type != null ? !type.equals(that.type) : that.type != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (type != null ? type.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "AccountTypeEntity [id=" + id + ", type=" + type + "]";
	}
}
