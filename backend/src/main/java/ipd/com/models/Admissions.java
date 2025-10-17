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
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author adity
 */
@Entity
@Table(name = "admissions")
@NamedQueries({
    @NamedQuery(name = "Admissions.findAll", query = "SELECT a FROM Admissions a"),
    @NamedQuery(name = "Admissions.findByAdmissionId", query = "SELECT a FROM Admissions a WHERE a.admissionId = :admissionId"),
    @NamedQuery(name = "Admissions.findByAdmissionDate", query = "SELECT a FROM Admissions a WHERE a.admissionDate = :admissionDate"),
    @NamedQuery(name = "Admissions.findByDischargeDate", query = "SELECT a FROM Admissions a WHERE a.dischargeDate = :dischargeDate"),
    @NamedQuery(name = "Admissions.findByStatus", query = "SELECT a FROM Admissions a WHERE a.status = :status")})
public class Admissions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "admission_id")
    private Integer admissionId;
    @Basic(optional = false)
    @Column(name = "admission_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date admissionDate;
    @Column(name = "discharge_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dischargeDate;
    @Basic(optional = false)
    @Lob
    @Column(name = "reason_for_admission")
    private String reasonForAdmission;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "bed_id", referencedColumnName = "bed_id")
    @ManyToOne(optional = false)
    private Beds bedId;
    @JoinColumn(name = "admitting_doctor_id", referencedColumnName = "doctor_id")
    @ManyToOne(optional = false)
    private Doctors admittingDoctorId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patients patientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admissionId")
    private Collection<Billing> billingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admissionId")
    private Collection<Patienttransfers> patienttransfersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admissionId")
    private Collection<Labtestresults> labtestresultsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "admissionId")
    private Dischargesummary dischargesummary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admissionId")
    private Collection<Medicalrecords> medicalrecordsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admissionId")
    private Collection<Prescriptions> prescriptionsCollection;

    public Admissions() {
    }

    public Admissions(Integer admissionId) {
        this.admissionId = admissionId;
    }

    public Admissions(Integer admissionId, Date admissionDate, String reasonForAdmission, String status) {
        this.admissionId = admissionId;
        this.admissionDate = admissionDate;
        this.reasonForAdmission = reasonForAdmission;
        this.status = status;
    }

    public Integer getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(Integer admissionId) {
        this.admissionId = admissionId;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getReasonForAdmission() {
        return reasonForAdmission;
    }

    public void setReasonForAdmission(String reasonForAdmission) {
        this.reasonForAdmission = reasonForAdmission;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Beds getBedId() {
        return bedId;
    }

    public void setBedId(Beds bedId) {
        this.bedId = bedId;
    }

    public Doctors getAdmittingDoctorId() {
        return admittingDoctorId;
    }

    public void setAdmittingDoctorId(Doctors admittingDoctorId) {
        this.admittingDoctorId = admittingDoctorId;
    }

    public Patients getPatientId() {
        return patientId;
    }

    public void setPatientId(Patients patientId) {
        this.patientId = patientId;
    }

    public Collection<Billing> getBillingCollection() {
        return billingCollection;
    }

    public void setBillingCollection(Collection<Billing> billingCollection) {
        this.billingCollection = billingCollection;
    }

    public Collection<Patienttransfers> getPatienttransfersCollection() {
        return patienttransfersCollection;
    }

    public void setPatienttransfersCollection(Collection<Patienttransfers> patienttransfersCollection) {
        this.patienttransfersCollection = patienttransfersCollection;
    }

    public Collection<Labtestresults> getLabtestresultsCollection() {
        return labtestresultsCollection;
    }

    public void setLabtestresultsCollection(Collection<Labtestresults> labtestresultsCollection) {
        this.labtestresultsCollection = labtestresultsCollection;
    }

    public Dischargesummary getDischargesummary() {
        return dischargesummary;
    }

    public void setDischargesummary(Dischargesummary dischargesummary) {
        this.dischargesummary = dischargesummary;
    }

    public Collection<Medicalrecords> getMedicalrecordsCollection() {
        return medicalrecordsCollection;
    }

    public void setMedicalrecordsCollection(Collection<Medicalrecords> medicalrecordsCollection) {
        this.medicalrecordsCollection = medicalrecordsCollection;
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
        hash += (admissionId != null ? admissionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admissions)) {
            return false;
        }
        Admissions other = (Admissions) object;
        if ((this.admissionId == null && other.admissionId != null) || (this.admissionId != null && !this.admissionId.equals(other.admissionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ipd.com.models.Admissions[ admissionId=" + admissionId + " ]";
    }
    
}
