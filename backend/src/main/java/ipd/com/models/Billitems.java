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
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author adity
 */
@Entity
@Table(name = "billitems")
@NamedQueries({
    @NamedQuery(name = "Billitems.findAll", query = "SELECT b FROM Billitems b"),
    @NamedQuery(name = "Billitems.findByItemId", query = "SELECT b FROM Billitems b WHERE b.itemId = :itemId"),
    @NamedQuery(name = "Billitems.findByItemDescription", query = "SELECT b FROM Billitems b WHERE b.itemDescription = :itemDescription"),
    @NamedQuery(name = "Billitems.findByItemCost", query = "SELECT b FROM Billitems b WHERE b.itemCost = :itemCost"),
    @NamedQuery(name = "Billitems.findByQuantity", query = "SELECT b FROM Billitems b WHERE b.quantity = :quantity"),
    @NamedQuery(name = "Billitems.findByItemDate", query = "SELECT b FROM Billitems b WHERE b.itemDate = :itemDate")})
public class Billitems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "item_id")
    private Integer itemId;
    @Basic(optional = false)
    @Column(name = "item_description")
    private String itemDescription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "item_cost")
    private BigDecimal itemCost;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "item_date")
    @Temporal(TemporalType.DATE)
    private Date itemDate;
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
    @ManyToOne(optional = false)
    private Billing billId;

    public Billitems() {
    }

    public Billitems(Integer itemId) {
        this.itemId = itemId;
    }

    public Billitems(Integer itemId, String itemDescription, BigDecimal itemCost, int quantity, Date itemDate) {
        this.itemId = itemId;
        this.itemDescription = itemDescription;
        this.itemCost = itemCost;
        this.quantity = quantity;
        this.itemDate = itemDate;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public BigDecimal getItemCost() {
        return itemCost;
    }

    public void setItemCost(BigDecimal itemCost) {
        this.itemCost = itemCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getItemDate() {
        return itemDate;
    }

    public void setItemDate(Date itemDate) {
        this.itemDate = itemDate;
    }

    public Billing getBillId() {
        return billId;
    }

    public void setBillId(Billing billId) {
        this.billId = billId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Billitems)) {
            return false;
        }
        Billitems other = (Billitems) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ipd.com.models.Billitems[ itemId=" + itemId + " ]";
    }
    
}
