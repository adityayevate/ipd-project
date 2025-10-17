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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author adity
 */
@Entity
@Table(name = "billing")
@NamedQueries({
    @NamedQuery(name = "Billing.findAll", query = "SELECT b FROM Billing b"),
    @NamedQuery(name = "Billing.findByBillId", query = "SELECT b FROM Billing b WHERE b.billId = :billId"),
    @NamedQuery(name = "Billing.findByBillDate", query = "SELECT b FROM Billing b WHERE b.billDate = :billDate"),
    @NamedQuery(name = "Billing.findByTotalAmount", query = "SELECT b FROM Billing b WHERE b.totalAmount = :totalAmount"),
    @NamedQuery(name = "Billing.findByAmountPaid", query = "SELECT b FROM Billing b WHERE b.amountPaid = :amountPaid"),
    @NamedQuery(name = "Billing.findByPaymentStatus", query = "SELECT b FROM Billing b WHERE b.paymentStatus = :paymentStatus")})
public class Billing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bill_id")
    private Integer billId;
    @Basic(optional = false)
    @Column(name = "bill_date")
    @Temporal(TemporalType.DATE)
    private Date billDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Basic(optional = false)
    @Column(name = "amount_paid")
    private BigDecimal amountPaid;
    @Basic(optional = false)
    @Column(name = "payment_status")
    private String paymentStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billId")
    private Collection<Billitems> billitemsCollection;
    @JoinColumn(name = "admission_id", referencedColumnName = "admission_id")
    @ManyToOne(optional = false)
    private Admissions admissionId;

    public Billing() {
    }

    public Billing(Integer billId) {
        this.billId = billId;
    }

    public Billing(Integer billId, Date billDate, BigDecimal totalAmount, BigDecimal amountPaid, String paymentStatus) {
        this.billId = billId;
        this.billDate = billDate;
        this.totalAmount = totalAmount;
        this.amountPaid = amountPaid;
        this.paymentStatus = paymentStatus;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Collection<Billitems> getBillitemsCollection() {
        return billitemsCollection;
    }

    public void setBillitemsCollection(Collection<Billitems> billitemsCollection) {
        this.billitemsCollection = billitemsCollection;
    }

    public Admissions getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(Admissions admissionId) {
        this.admissionId = admissionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billId != null ? billId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Billing)) {
            return false;
        }
        Billing other = (Billing) object;
        if ((this.billId == null && other.billId != null) || (this.billId != null && !this.billId.equals(other.billId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ipd.com.models.Billing[ billId=" + billId + " ]";
    }
    
}
