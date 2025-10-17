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
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author adity
 */
@Entity
@Table(name = "medications")
@NamedQueries({
    @NamedQuery(name = "Medications.findAll", query = "SELECT m FROM Medications m"),
    @NamedQuery(name = "Medications.findByMedicationId", query = "SELECT m FROM Medications m WHERE m.medicationId = :medicationId"),
    @NamedQuery(name = "Medications.findByBrandName", query = "SELECT m FROM Medications m WHERE m.brandName = :brandName"),
    @NamedQuery(name = "Medications.findByGenericName", query = "SELECT m FROM Medications m WHERE m.genericName = :genericName"),
    @NamedQuery(name = "Medications.findByManufacturer", query = "SELECT m FROM Medications m WHERE m.manufacturer = :manufacturer"),
    @NamedQuery(name = "Medications.findByStockQuantity", query = "SELECT m FROM Medications m WHERE m.stockQuantity = :stockQuantity"),
    @NamedQuery(name = "Medications.findByUnitOfMeasure", query = "SELECT m FROM Medications m WHERE m.unitOfMeasure = :unitOfMeasure"),
    @NamedQuery(name = "Medications.findByUnitPrice", query = "SELECT m FROM Medications m WHERE m.unitPrice = :unitPrice")})
public class Medications implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medication_id")
    private Integer medicationId;
    @Basic(optional = false)
    @Column(name = "brand_name")
    private String brandName;
    @Basic(optional = false)
    @Column(name = "generic_name")
    private String genericName;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Basic(optional = false)
    @Column(name = "stock_quantity")
    private int stockQuantity;
    @Basic(optional = false)
    @Column(name = "unit_of_measure")
    private String unitOfMeasure;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicationId")
    private Collection<Prescriptions> prescriptionsCollection;

    public Medications() {
    }

    public Medications(Integer medicationId) {
        this.medicationId = medicationId;
    }

    public Medications(Integer medicationId, String brandName, String genericName, int stockQuantity, String unitOfMeasure, BigDecimal unitPrice) {
        this.medicationId = medicationId;
        this.brandName = brandName;
        this.genericName = genericName;
        this.stockQuantity = stockQuantity;
        this.unitOfMeasure = unitOfMeasure;
        this.unitPrice = unitPrice;
    }

    public Integer getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Integer medicationId) {
        this.medicationId = medicationId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Collection<Prescriptions> getPrescriptionsCollection() {
        return prescriptionsCollection;
    }

    public void setPrescriptionsCollection(Collection<Prescriptions> prescriptionsCollection) {
        this.prescriptionsCollection = prescriptionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicationId != null ? medicationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medications)) {
            return false;
        }
        Medications other = (Medications) object;
        if ((this.medicationId == null && other.medicationId != null) || (this.medicationId != null && !this.medicationId.equals(other.medicationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ipd.com.models.Medications[ medicationId=" + medicationId + " ]";
    }
    
}
