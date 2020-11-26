package ua.lviv.ua.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "pin_code", schema = "vysotska", catalog = "")
public class PinCodeEntity {
	private Integer id;
	private String pin;

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
	@Column(name = "pin")
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		PinCodeEntity that = (PinCodeEntity) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (pin != null ? !pin.equals(that.pin) : that.pin != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (pin != null ? pin.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "PinCodeEntity [id=" + id + ", pin=" + pin + "]";
	}
}
