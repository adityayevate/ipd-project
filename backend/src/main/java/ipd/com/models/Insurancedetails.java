/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipd.com.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author adity
 */
@Entity
@Table(name = "insurancedetails")
@NamedQueries({
    @NamedQuery(name = "Insurancedetails.findAll", query = "SELECT i FROM Insurancedetails i"),
    @NamedQuery(name = "Insurancedetails.findByInsuranceId", query = "SELECT i FROM Insurancedetails i WHERE i.insuranceId = :insuranceId"),
    @NamedQuery(name = "Insurancedetails.findByProviderName", query = "SELECT i FROM Insurancedetails i WHERE i.providerName = :providerName"),
    @NamedQuery(name = "Insurancedetails.findByPolicyNumber", query = "SELECT i FROM Insurancedetails i WHERE i.policyNumber = :policyNumber"),
    @NamedQuery(name = "Insurancedetails.findByValidUntil", query = "SELECT i FROM Insurancedetails i WHERE i.validUntil = :validUntil"),
    @NamedQuery(name = "Insurancedetails.findByCoverageAmount", query = "SELECT i FROM Insurancedetails i WHERE i.coverageAmount = :coverageAmount")})
public class Insurancedetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "insurance_id")
    private Integer insuranceId;
    @Basic(optional = false)
    @Column(name = "provider_name")
    private String providerName;
    @Basic(optional = false)
    @Column(name = "policy_number")
    private String policyNumber;
    @Basic(optional = false)
    @Column(name = "valid_until")
    @Temporal(TemporalType.DATE)
    private Date validUntil;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "coverage_amount")
    private BigDecimal coverageAmount;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @OneToOne(optional = false)
    private Patients patientId;

    public Insurancedetails() {
    }

    public Insurancedetails(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public Insurancedetails(Integer insuranceId, String providerName, String policyNumber, Date validUntil, BigDecimal coverageAmount) {
        this.insuranceId = insuranceId;
        this.providerName = providerName;
        this.policyNumber = policyNumber;
        this.validUntil = validUntil;
        this.coverageAmount = coverageAmount;
    }

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public BigDecimal getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(BigDecimal coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public Patients getPatientId() {
        return patientId;
    }

    public void setPatientId(Patients patientId) {
        this.patientId = patientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insuranceId != null ? insuranceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insurancedetails)) {
            return false;
        }
        Insurancedetails other = (Insurancedetails) object;
        if ((this.insuranceId == null && other.insuranceId != null) || (this.insuranceId != null && !this.insuranceId.equals(other.insuranceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ipd.com.models.Insurancedetails[ insuranceId=" + insuranceId + " ]";
    }
    
}
