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
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@Table(name = "medicalrecords")
@NamedQueries({
    @NamedQuery(name = "Medicalrecords.findAll", query = "SELECT m FROM Medicalrecords m"),
    @NamedQuery(name = "Medicalrecords.findByRecordId", query = "SELECT m FROM Medicalrecords m WHERE m.recordId = :recordId"),
    @NamedQuery(name = "Medicalrecords.findByRecordDatetime", query = "SELECT m FROM Medicalrecords m WHERE m.recordDatetime = :recordDatetime"),
    @NamedQuery(name = "Medicalrecords.findByRecordType", query = "SELECT m FROM Medicalrecords m WHERE m.recordType = :recordType"),
    @NamedQuery(name = "Medicalrecords.findByTemperatureCelsius", query = "SELECT m FROM Medicalrecords m WHERE m.temperatureCelsius = :temperatureCelsius"),
    @NamedQuery(name = "Medicalrecords.findByBpSystolic", query = "SELECT m FROM Medicalrecords m WHERE m.bpSystolic = :bpSystolic"),
    @NamedQuery(name = "Medicalrecords.findByBpDiastolic", query = "SELECT m FROM Medicalrecords m WHERE m.bpDiastolic = :bpDiastolic"),
    @NamedQuery(name = "Medicalrecords.findByHeartRateBpm", query = "SELECT m FROM Medicalrecords m WHERE m.heartRateBpm = :heartRateBpm")})
public class Medicalrecords implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "record_id")
    private Integer recordId;
    @Basic(optional = false)
    @Column(name = "record_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDatetime;
    @Basic(optional = false)
    @Column(name = "record_type")
    private String recordType;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "temperature_celsius")
    private BigDecimal temperatureCelsius;
    @Column(name = "bp_systolic")
    private Integer bpSystolic;
    @Column(name = "bp_diastolic")
    private Integer bpDiastolic;
    @Column(name = "heart_rate_bpm")
    private Integer heartRateBpm;
    @JoinColumn(name = "admission_id", referencedColumnName = "admission_id")
    @ManyToOne(optional = false)
    private Admissions admissionId;
    @JoinColumn(name = "recorded_by_doctor_id", referencedColumnName = "doctor_id")
    @ManyToOne(optional = false)
    private Doctors recordedByDoctorId;

    public Medicalrecords() {
    }

    public Medicalrecords(Integer recordId) {
        this.recordId = recordId;
    }

    public Medicalrecords(Integer recordId, Date recordDatetime, String recordType, String description) {
        this.recordId = recordId;
        this.recordDatetime = recordDatetime;
        this.recordType = recordType;
        this.description = description;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Date getRecordDatetime() {
        return recordDatetime;
    }

    public void setRecordDatetime(Date recordDatetime) {
        this.recordDatetime = recordDatetime;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public void setTemperatureCelsius(BigDecimal temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    public Integer getBpSystolic() {
        return bpSystolic;
    }

    public void setBpSystolic(Integer bpSystolic) {
        this.bpSystolic = bpSystolic;
    }

    public Integer getBpDiastolic() {
        return bpDiastolic;
    }

    public void setBpDiastolic(Integer bpDiastolic) {
        this.bpDiastolic = bpDiastolic;
    }

    public Integer getHeartRateBpm() {
        return heartRateBpm;
    }

    public void setHeartRateBpm(Integer heartRateBpm) {
        this.heartRateBpm = heartRateBpm;
    }

    public Admissions getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(Admissions admissionId) {
        this.admissionId = admissionId;
    }

    public Doctors getRecordedByDoctorId() {
        return recordedByDoctorId;
    }

    public void setRecordedByDoctorId(Doctors recordedByDoctorId) {
        this.recordedByDoctorId = recordedByDoctorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recordId != null ? recordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicalrecords)) {
            return false;
        }
        Medicalrecords other = (Medicalrecords) object;
        if ((this.recordId == null && other.recordId != null) || (this.recordId != null && !this.recordId.equals(other.recordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ipd.com.models.Medicalrecords[ recordId=" + recordId + " ]";
    }
    
}
