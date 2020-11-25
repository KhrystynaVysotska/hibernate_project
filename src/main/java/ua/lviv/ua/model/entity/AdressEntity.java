package ua.lviv.ua.model.entity;

import javax.persistence.*;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdressEntity that = (AdressEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    public CityEntity getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(CityEntity cityByCityId) {
        this.cityByCityId = cityByCityId;
    }

    @ManyToOne
    @JoinColumn(name = "street_id", referencedColumnName = "id")
    public StreetEntity getStreetByStreetId() {
        return streetByStreetId;
    }

    public void setStreetByStreetId(StreetEntity streetByStreetId) {
        this.streetByStreetId = streetByStreetId;
    }

    @ManyToOne
    @JoinColumn(name = "building_id", referencedColumnName = "id")
    public BuildingEntity getBuildingByBuildingId() {
        return buildingByBuildingId;
    }

    public void setBuildingByBuildingId(BuildingEntity buildingByBuildingId) {
        this.buildingByBuildingId = buildingByBuildingId;
    }
}
