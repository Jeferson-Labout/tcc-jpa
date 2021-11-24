/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jefson
 */
@Entity
@Table(name = "gruporota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gruporota.findAll", query = "SELECT g FROM Gruporota g ORDER BY g.gdrid")
    , @NamedQuery(name = "Gruporota.findByGdrid", query = "SELECT g FROM Gruporota g WHERE g.gdrid = :gdrid")
    , @NamedQuery(name = "Gruporota.findByGdrdescricao", query = "SELECT g FROM Gruporota g WHERE g.gdrdescricao = :gdrdescricao")})
public class Gruporota implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gdrid")
    private Integer gdrid;
    @Basic(optional = false)
    @Column(name = "gdrdescricao")
    private String gdrdescricao;
    @OneToMany(mappedBy = "clirota")
    private Collection<Cliente> clienteCollection;

    public Gruporota() {
    }

    public Gruporota(Integer gdrid) {
        this.gdrid = gdrid;
    }

    public Gruporota(Integer gdrid, String gdrdescricao) {
        this.gdrid = gdrid;
        this.gdrdescricao = gdrdescricao;
    }

    public Integer getGdrid() {
        return gdrid;
    }

    public void setGdrid(Integer gdrid) {
        Integer oldGdrid = this.gdrid;
        this.gdrid = gdrid;
        changeSupport.firePropertyChange("gdrid", oldGdrid, gdrid);
    }

    public String getGdrdescricao() {
        return gdrdescricao;
    }

    public void setGdrdescricao(String gdrdescricao) {
        String oldGdrdescricao = this.gdrdescricao;
        this.gdrdescricao = gdrdescricao;
        changeSupport.firePropertyChange("gdrdescricao", oldGdrdescricao, gdrdescricao);
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gdrid != null ? gdrid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gruporota)) {
            return false;
        }
        Gruporota other = (Gruporota) object;
        if ((this.gdrid == null && other.gdrid != null) || (this.gdrid != null && !this.gdrid.equals(other.gdrid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return gdrdescricao;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
