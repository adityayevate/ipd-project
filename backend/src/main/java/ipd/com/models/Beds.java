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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "beds")
@NamedQueries({
    @NamedQuery(name = "Beds.findAll", query = "SELECT b FROM Beds b"),
    @NamedQuery(name = "Beds.findByBedId", query = "SELECT b FROM Beds b WHERE b.bedId = :bedId"),
    @NamedQuery(name = "Beds.findByBedNumber", query = "SELECT b FROM Beds b WHERE b.bedNumber = :bedNumber"),
    @NamedQuery(name = "Beds.findByIsOccupied", query = "SELECT b FROM Beds b WHERE b.isOccupied = :isOccupied")})
public class Beds implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bed_id")
    private Integer bedId;
    @Basic(optional = false)
    @Column(name = "bed_number")
    private String bedNumber;
    @Basic(optional = false)
    @Column(name = "is_occupied")
    private boolean isOccupied;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bedId")
    private Collection<Admissions> admissionsCollection;
    @OneToMany(mappedBy = "fromBedId")
    private Collection<Patienttransfers> patienttransfersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toBedId")
    private Collection<Patienttransfers> patienttransfersCollection1;
    @JoinColumn(name = "ward_id", referencedColumnName = "ward_id")
    @ManyToOne(optional = false)
    private Wards wardId;

    public Beds() {
    }

    public Beds(Integer bedId) {
        this.bedId = bedId;
    }

    public Beds(Integer bedId, String bedNumber, boolean isOccupied) {
        this.bedId = bedId;
        this.bedNumber = bedNumber;
        this.isOccupied = isOccupied;
    }

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Collection<Admissions> getAdmissionsCollection() {
        return admissionsCollection;
    }

    public void setAdmissionsCollection(Collection<Admissions> admissionsCollection) {
        this.admissionsCollection = admissionsCollection;
    }

    public Collection<Patienttransfers> getPatienttransfersCollection() {
        return patienttransfersCollection;
    }

    public void setPatienttransfersCollection(Collection<Patienttransfers> patienttransfersCollection) {
        this.patienttransfersCollection = patienttransfersCollection;
    }

    public Collection<Patienttransfers> getPatienttransfersCollection1() {
        return patienttransfersCollection1;
    }

    public void setPatienttransfersCollection1(Collection<Patienttransfers> patienttransfersCollection1) {
        this.patienttransfersCollection1 = patienttransfersCollection1;
    }

    public Wards getWardId() {
        return wardId;
    }

    public void setWardId(Wards wardId) {
        this.wardId = wardId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bedId != null ? bedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beds)) {
            return false;
        }
        Beds other = (Beds) object;
        if ((this.bedId == null && other.bedId != null) || (this.bedId != null && !this.bedId.equals(other.bedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ipd.com.models.Beds[ bedId=" + bedId + " ]";
    }
    
}
