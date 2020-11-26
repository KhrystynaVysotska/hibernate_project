package ua.lviv.ua.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adress", schema = "vysotska", catalog = "")
public class AdressEntity {
	private Integer id;
	private CityEntity cityByCityId;
	private StreetEntity streetByStreetId;
	private BuildingEntity buildingByBuildingId;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		AdressEntity other = (AdressEntity) obj;
		if (buildingByBuildingId == null) {
			if (other.buildingByBuildingId != null) {
				return false;
			}
		} else if (!buildingByBuildingId.equals(other.buildingByBuildingId)) {
			return false;
		}
		if (cityByCityId == null) {
			if (other.cityByCityId != null) {
				return false;
			}
		} else if (!cityByCityId.equals(other.cityByCityId)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (streetByStreetId == null) {
			if (other.streetByStreetId != null) {
				return false;
			}
		} else if (!streetByStreetId.equals(other.streetByStreetId)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buildingByBuildingId == null) ? 0 : buildingByBuildingId.hashCode());
		result = prime * result + ((cityByCityId == null) ? 0 : cityByCityId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((streetByStreetId == null) ? 0 : streetByStreetId.hashCode());
		return result;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
	public CityEntity getCityByCityId() {
		return cityByCityId;
	}

	public void setCityByCityId(CityEntity cityByCityId) {
		this.cityByCityId = cityByCityId;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "street_id", referencedColumnName = "id")
	public StreetEntity getStreetByStreetId() {
		return streetByStreetId;
	}

	public void setStreetByStreetId(StreetEntity streetByStreetId) {
		this.streetByStreetId = streetByStreetId;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "building_id", referencedColumnName = "id")
	public BuildingEntity getBuildingByBuildingId() {
		return buildingByBuildingId;
	}

	public void setBuildingByBuildingId(BuildingEntity buildingByBuildingId) {
		this.buildingByBuildingId = buildingByBuildingId;
	}

	@Override
	public String toString() {
		return "AdressEntity [id=" + id + ", cityByCityId=" + cityByCityId + ", streetByStreetId=" + streetByStreetId
				+ ", buildingByBuildingId=" + buildingByBuildingId + "]";
	}
}
