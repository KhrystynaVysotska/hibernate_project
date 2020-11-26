package ua.lviv.ua.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import ua.lviv.ua.model.entity.formatter.Formatter;

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
		PinCodeEntity other = (PinCodeEntity) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (pin == null) {
			if (other.pin != null) {
				return false;
			}
		} else if (!pin.equals(other.pin)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pin == null) ? 0 : pin.hashCode());
		return result;
	}

	@Override
	public String toString() {
		String[] columnsNames = { "pin_code_id", "pin" };
		String[] columnValues = { id.toString(), pin };
		return Formatter.formatRow(columnsNames, columnValues);
	}
}
