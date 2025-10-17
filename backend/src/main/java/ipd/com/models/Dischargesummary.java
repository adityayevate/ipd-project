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
import jakarta.persistence.OneToOne;
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
@Table(name = "dischargesummary")
@NamedQueries({
    @NamedQuery(name = "Dischargesummary.findAll", query = "SELECT d FROM Dischargesummary d"),
    @NamedQuery(name = "Dischargesummary.findBySummaryId", query = "SELECT d FROM Dischargesummary d WHERE d.summaryId = :summaryId"),
    @NamedQuery(name = "Dischargesummary.findBySummaryDate", query = "SELECT d FROM Dischargesummary d WHERE d.summaryDate = :summaryDate")})
public class Dischargesummary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "summary_id")
    private Integer summaryId;
    @Basic(optional = false)
    @Column(name = "summary_date")
    @Temporal(TemporalType.DATE)
    private Date summaryDate;
    @Basic(optional = false)
    @Lob
    @Column(name = "final_diagnosis")
    private String finalDiagnosis;
    @Basic(optional = false)
    @Lob
    @Column(name = "treatment_provided_summary")
    private String treatmentProvidedSummary;
    @Lob
    @Column(name = "follow_up_instructions")
    private String followUpInstructions;
    @JoinColumn(name = "admission_id", referencedColumnName = "admission_id")
    @OneToOne(optional = false)
    private Admissions admissionId;
    @JoinColumn(name = "discharging_staff_id", referencedColumnName = "staff_id")
    @ManyToOne(optional = false)
    private Staff dischargingStaffId;

    public Dischargesummary() {
    }

    public Dischargesummary(Integer summaryId) {
        this.summaryId = summaryId;
    }

    public Dischargesummary(Integer summaryId, Date summaryDate, String finalDiagnosis, String treatmentProvidedSummary) {
        this.summaryId = summaryId;
        this.summaryDate = summaryDate;
        this.finalDiagnosis = finalDiagnosis;
        this.treatmentProvidedSummary = treatmentProvidedSummary;
    }

    public Integer getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(Integer summaryId) {
        this.summaryId = summaryId;
    }

    public Date getSummaryDate() {
        return summaryDate;
    }

    public void setSummaryDate(Date summaryDate) {
        this.summaryDate = summaryDate;
    }

    public String getFinalDiagnosis() {
        return finalDiagnosis;
    }

    public void setFinalDiagnosis(String finalDiagnosis) {
        this.finalDiagnosis = finalDiagnosis;
    }

    public String getTreatmentProvidedSummary() {
        return treatmentProvidedSummary;
    }

    public void setTreatmentProvidedSummary(String treatmentProvidedSummary) {
        this.treatmentProvidedSummary = treatmentProvidedSummary;
    }

    public String getFollowUpInstructions() {
        return followUpInstructions;
    }

    public void setFollowUpInstructions(String followUpInstructions) {
        this.followUpInstructions = followUpInstructions;
    }

    public Admissions getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(Admissions admissionId) {
        this.admissionId = admissionId;
    }

    public Staff getDischargingStaffId() {
        return dischargingStaffId;
    }

    public void setDischargingStaffId(Staff dischargingStaffId) {
        this.dischargingStaffId = dischargingStaffId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (summaryId != null ? summaryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dischargesummary)) {
            return false;
        }
        Dischargesummary other = (Dischargesummary) object;
        if ((this.summaryId == null && other.summaryId != null) || (this.summaryId != null && !this.summaryId.equals(other.summaryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ipd.com.models.Dischargesummary[ summaryId=" + summaryId + " ]";
    }
    
}
