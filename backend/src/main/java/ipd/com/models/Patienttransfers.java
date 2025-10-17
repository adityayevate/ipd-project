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
@Table(name = "patienttransfers")
@NamedQueries({
    @NamedQuery(name = "Patienttransfers.findAll", query = "SELECT p FROM Patienttransfers p"),
    @NamedQuery(name = "Patienttransfers.findByTransferId", query = "SELECT p FROM Patienttransfers p WHERE p.transferId = :transferId"),
    @NamedQuery(name = "Patienttransfers.findByTransferDatetime", query = "SELECT p FROM Patienttransfers p WHERE p.transferDatetime = :transferDatetime")})
public class Patienttransfers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transfer_id")
    private Integer transferId;
    @Basic(optional = false)
    @Column(name = "transfer_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transferDatetime;
    @Lob
    @Column(name = "reason")
    private String reason;
    @JoinColumn(name = "admission_id", referencedColumnName = "admission_id")
    @ManyToOne(optional = false)
    private Admissions admissionId;
    @JoinColumn(name = "from_bed_id", referencedColumnName = "bed_id")
    @ManyToOne
    private Beds fromBedId;
    @JoinColumn(name = "to_bed_id", referencedColumnName = "bed_id")
    @ManyToOne(optional = false)
    private Beds toBedId;

    public Patienttransfers() {
    }

    public Patienttransfers(Integer transferId) {
        this.transferId = transferId;
    }

    public Patienttransfers(Integer transferId, Date transferDatetime) {
        this.transferId = transferId;
        this.transferDatetime = transferDatetime;
    }

    public Integer getTransferId() {
        return transferId;
    }

    public void setTransferId(Integer transferId) {
        this.transferId = transferId;
    }

    public Date getTransferDatetime() {
        return transferDatetime;
    }

    public void setTransferDatetime(Date transferDatetime) {
        this.transferDatetime = transferDatetime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Admissions getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(Admissions admissionId) {
        this.admissionId = admissionId;
    }

    public Beds getFromBedId() {
        return fromBedId;
    }

    public void setFromBedId(Beds fromBedId) {
        this.fromBedId = fromBedId;
    }

    public Beds getToBedId() {
        return toBedId;
    }

    public void setToBedId(Beds toBedId) {
        this.toBedId = toBedId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transferId != null ? transferId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patienttransfers)) {
            return false;
        }
        Patienttransfers other = (Patienttransfers) object;
        if ((this.transferId == null && other.transferId != null) || (this.transferId != null && !this.transferId.equals(other.transferId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ipd.com.models.Patienttransfers[ transferId=" + transferId + " ]";
    }
    
}
