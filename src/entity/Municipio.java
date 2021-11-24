/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jefson
 */
@Entity
@Table(name = "municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m ORDER BY m.munid")
    , @NamedQuery(name = "Municipio.findByMunid", query = "SELECT m FROM Municipio m WHERE m.munid = :munid")
    , @NamedQuery(name = "Municipio.findByMundescricao", query = "SELECT m FROM Municipio m WHERE m.mundescricao = :mundescricao")
    , @NamedQuery(name = "Municipio.findByMunestado", query = "SELECT m FROM Municipio m WHERE m.munestado = :munestado")})
public class Municipio implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "munid")
    private Integer munid;
    @Column(name = "mundescricao")
    private String mundescricao;
    @Column(name = "munestado")
    private String munestado;

    public Municipio() {
    }

    public Municipio(Integer munid) {
        this.munid = munid;
    }

    public Integer getMunid() {
        return munid;
    }

    public void setMunid(Integer munid) {
        Integer oldMunid = this.munid;
        this.munid = munid;
        changeSupport.firePropertyChange("munid", oldMunid, munid);
    }

    public String getMundescricao() {
        return mundescricao;
    }

    public void setMundescricao(String mundescricao) {
        String oldMundescricao = this.mundescricao;
        this.mundescricao = mundescricao;
        changeSupport.firePropertyChange("mundescricao", oldMundescricao, mundescricao);
    }

    public String getMunestado() {
        return munestado;
    }

    public void setMunestado(String munestado) {
        String oldMunestado = this.munestado;
        this.munestado = munestado;
        changeSupport.firePropertyChange("munestado", oldMunestado, munestado);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (munid != null ? munid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.munid == null && other.munid != null) || (this.munid != null && !this.munid.equals(other.munid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return mundescricao;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
