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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author adity
 */
@Entity
@Table(name = "prescriptions")
@NamedQueries({
    @NamedQuery(name = "Prescriptions.findAll", query = "SELECT p FROM Prescriptions p"),
    @NamedQuery(name = "Prescriptions.findByPrescriptionId", query = "SELECT p FROM Prescriptions p WHERE p.prescriptionId = :prescriptionId"),
    @NamedQuery(name = "Prescriptions.findByDosage", query = "SELECT p FROM Prescriptions p WHERE p.dosage = :dosage"),
    @NamedQuery(name = "Prescriptions.findByFrequency", query = "SELECT p FROM Prescriptions p WHERE p.frequency = :frequency"),
    @NamedQuery(name = "Prescriptions.findByStartDate", query = "SELECT p FROM Prescriptions p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Prescriptions.findByEndDate", query = "SELECT p FROM Prescriptions p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "Prescriptions.findByPrescriptionStatus", query = "SELECT p FROM Prescriptions p WHERE p.prescriptionStatus = :prescriptionStatus")})
public class Prescriptions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prescription_id")
    private Integer prescriptionId;
    @Basic(optional = false)
    @Column(name = "dosage")
    private String dosage;
    @Basic(optional = false)
    @Column(name = "frequency")
    private String frequency;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "prescription_status")
    private String prescriptionStatus;
    @JoinColumn(name = "admission_id", referencedColumnName = "admission_id")
    @ManyToOne(optional = false)
    private Admissions admissionId;
    @JoinColumn(name = "medication_id", referencedColumnName = "medication_id")
    @ManyToOne(optional = false)
    private Medications medicationId;
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    @ManyToOne(optional = false)
    private Staff staffId;

    public Prescriptions() {
    }

    public Prescriptions(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Prescriptions(Integer prescriptionId, String dosage, String frequency, Date startDate, String prescriptionStatus) {
        this.prescriptionId = prescriptionId;
        this.dosage = dosage;
        this.frequency = frequency;
        this.startDate = startDate;
        this.prescriptionStatus = prescriptionStatus;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPrescriptionStatus() {
        return prescriptionStatus;
    }

    public void setPrescriptionStatus(String prescriptionStatus) {
        this.prescriptionStatus = prescriptionStatus;
    }

    public Admissions getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(Admissions admissionId) {
        this.admissionId = admissionId;
    }

    public Medications getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Medications medicationId) {
        this.medicationId = medicationId;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prescriptionId != null ? prescriptionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prescriptions)) {
            return false;
        }
        Prescriptions other = (Prescriptions) object;
        if ((this.prescriptionId == null && other.prescriptionId != null) || (this.prescriptionId != null && !this.prescriptionId.equals(other.prescriptionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ipd.com.models.Prescriptions[ prescriptionId=" + prescriptionId + " ]";
    }
    
}
