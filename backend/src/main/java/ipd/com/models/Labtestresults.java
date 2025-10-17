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
import java.util.Date;

/**
 *
 * @author adity
 */
@Entity
@Table(name = "labtestresults")
@NamedQueries({
    @NamedQuery(name = "Labtestresults.findAll", query = "SELECT l FROM Labtestresults l"),
    @NamedQuery(name = "Labtestresults.findByResultId", query = "SELECT l FROM Labtestresults l WHERE l.resultId = :resultId"),
    @NamedQuery(name = "Labtestresults.findBySampleCollectedDatetime", query = "SELECT l FROM Labtestresults l WHERE l.sampleCollectedDatetime = :sampleCollectedDatetime"),
    @NamedQuery(name = "Labtestresults.findByResultDatetime", query = "SELECT l FROM Labtestresults l WHERE l.resultDatetime = :resultDatetime"),
    @NamedQuery(name = "Labtestresults.findByStatus", query = "SELECT l FROM Labtestresults l WHERE l.status = :status")})
public class Labtestresults implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "result_id")
    private Integer resultId;
    @Column(name = "sample_collected_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sampleCollectedDatetime;
    @Column(name = "result_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resultDatetime;
    @Lob
    @Column(name = "result_value")
    private String resultValue;
    @Lob
    @Column(name = "notes")
    private String notes;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "admission_id", referencedColumnName = "admission_id")
    @ManyToOne(optional = false)
    private Admissions admissionId;
    @JoinColumn(name = "test_id", referencedColumnName = "test_id")
    @ManyToOne(optional = false)
    private Labtests testId;
    @JoinColumn(name = "ordered_by_staff_id", referencedColumnName = "staff_id")
    @ManyToOne(optional = false)
    private Staff orderedByStaffId;

    public Labtestresults() {
    }

    public Labtestresults(Integer resultId) {
        this.resultId = resultId;
    }

    public Labtestresults(Integer resultId, String status) {
        this.resultId = resultId;
        this.status = status;
    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public Date getSampleCollectedDatetime() {
        return sampleCollectedDatetime;
    }

    public void setSampleCollectedDatetime(Date sampleCollectedDatetime) {
        this.sampleCollectedDatetime = sampleCollectedDatetime;
    }

    public Date getResultDatetime() {
        return resultDatetime;
    }

    public void setResultDatetime(Date resultDatetime) {
        this.resultDatetime = resultDatetime;
    }

    public String getResultValue() {
        return resultValue;
    }

    public void setResultValue(String resultValue) {
        this.resultValue = resultValue;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Admissions getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(Admissions admissionId) {
        this.admissionId = admissionId;
    }

    public Labtests getTestId() {
        return testId;
    }

    public void setTestId(Labtests testId) {
        this.testId = testId;
    }

    public Staff getOrderedByStaffId() {
        return orderedByStaffId;
    }

    public void setOrderedByStaffId(Staff orderedByStaffId) {
        this.orderedByStaffId = orderedByStaffId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resultId != null ? resultId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Labtestresults)) {
            return false;
        }
        Labtestresults other = (Labtestresults) object;
        if ((this.resultId == null && other.resultId != null) || (this.resultId != null && !this.resultId.equals(other.resultId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ipd.com.models.Labtestresults[ resultId=" + resultId + " ]";
    }
    
}
