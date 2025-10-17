/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipd.com.models;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author adity
 */
@Entity
@Table(name = "wards")
@NamedQueries({
    @NamedQuery(name = "Wards.findAll", query = "SELECT w FROM Wards w"),
    @NamedQuery(name = "Wards.findByWardId", query = "SELECT w FROM Wards w WHERE w.wardId = :wardId"),
    @NamedQuery(name = "Wards.findByWardName", query = "SELECT w FROM Wards w WHERE w.wardName = :wardName"),
    @NamedQuery(name = "Wards.findByWardType", query = "SELECT w FROM Wards w WHERE w.wardType = :wardType"),
    @NamedQuery(name = "Wards.findByFloorNumber", query = "SELECT w FROM Wards w WHERE w.floorNumber = :floorNumber")})
public class Wards implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ward_id")
    private Integer wardId;
    @Basic(optional = false)
    @Column(name = "ward_name")
    private String wardName;
    @Basic(optional = false)
    @Column(name = "ward_type")
    private String wardType;
    @Column(name = "floor_number")
    private Integer floorNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wardId")
    private Collection<Beds> bedsCollection;

    public Wards() {
    }

    public Wards(Integer wardId) {
        this.wardId = wardId;
    }

    public Wards(Integer wardId, String wardName, String wardType) {
        this.wardId = wardId;
        this.wardName = wardName;
        this.wardType = wardType;
    }

    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getWardType() {
        return wardType;
    }

    public void setWardType(String wardType) {
        this.wardType = wardType;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Collection<Beds> getBedsCollection() {
        return bedsCollection;
    }

    public void setBedsCollection(Collection<Beds> bedsCollection) {
        this.bedsCollection = bedsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wardId != null ? wardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wards)) {
            return false;
        }
        Wards other = (Wards) object;
        if ((this.wardId == null && other.wardId != null) || (this.wardId != null && !this.wardId.equals(other.wardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ipd.com.models.Wards[ wardId=" + wardId + " ]";
    }
    
}
