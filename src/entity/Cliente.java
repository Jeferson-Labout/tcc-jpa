/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCliid", query = "SELECT c FROM Cliente c WHERE c.cliid = :cliid")
    , @NamedQuery(name = "Cliente.findByClitipo", query = "SELECT c FROM Cliente c WHERE c.clitipo = :clitipo")
    , @NamedQuery(name = "Cliente.findByClitipocad", query = "SELECT c FROM Cliente c WHERE c.clitipocad = 1  ORDER BY c.cliid ")
    , @NamedQuery(name = "Cliente.findByUsuario", query = "SELECT c FROM Cliente c WHERE c.clitipocad = 2  ORDER BY c.cliid ")
    , @NamedQuery(name = "Cliente.findByUsuario2", query = "SELECT c FROM Cliente c WHERE c.clitipocad <>1  ORDER BY c.cliid ")
    , @NamedQuery(name = "Cliente.findByUsuario3", query = "SELECT c FROM Cliente c WHERE c.clitipocad =3  ORDER BY c.cliid ")
    , @NamedQuery(name = "Cliente.findByClirotadescricao", query = "SELECT c FROM Cliente c WHERE c.clirotadescricao = :clirotadescricao")
    , @NamedQuery(name = "Cliente.findByClinome", query = "SELECT c FROM Cliente c WHERE c.clinome = :clinome")
    , @NamedQuery(name = "Cliente.findByClifantasia", query = "SELECT c FROM Cliente c WHERE c.clifantasia = :clifantasia")
    , @NamedQuery(name = "Cliente.findByClicpfcgc", query = "SELECT c FROM Cliente c WHERE c.clicpfcgc = :clicpfcgc")
    , @NamedQuery(name = "Cliente.findByCliendereco", query = "SELECT c FROM Cliente c WHERE c.cliendereco = :cliendereco")
    , @NamedQuery(name = "Cliente.findByClibairro", query = "SELECT c FROM Cliente c WHERE c.clibairro = :clibairro")
    , @NamedQuery(name = "Cliente.findByClinumero", query = "SELECT c FROM Cliente c WHERE c.clinumero = :clinumero")
    , @NamedQuery(name = "Cliente.findByClicidade", query = "SELECT c FROM Cliente c WHERE c.clicidade = :clicidade")
    , @NamedQuery(name = "Cliente.findByCliuf", query = "SELECT c FROM Cliente c WHERE c.cliuf = :cliuf")
    , @NamedQuery(name = "Cliente.findByClilongitude", query = "SELECT c FROM Cliente c WHERE c.clilongitude = :clilongitude")
    , @NamedQuery(name = "Cliente.findByClilatitude", query = "SELECT c FROM Cliente c WHERE c.clilatitude = :clilatitude")
    , @NamedQuery(name = "Cliente.findByClifone", query = "SELECT c FROM Cliente c WHERE c.clifone = :clifone")
    , @NamedQuery(name = "Cliente.findByCliemail", query = "SELECT c FROM Cliente c WHERE c.cliemail = :cliemail")
    , @NamedQuery(name = "Cliente.findByClisenhausuario", query = "SELECT c FROM Cliente c WHERE c.clisenhausuario = :clisenhausuario")
    , @NamedQuery(name = "Cliente.findByClivalorfixo", query = "SELECT c FROM Cliente c WHERE c.clivalorfixo = :clivalorfixo")
    , @NamedQuery(name = "Cliente.findByCliqtdecontratada", query = "SELECT c FROM Cliente c WHERE c.cliqtdecontratada = :cliqtdecontratada")
    , @NamedQuery(name = "Cliente.findByClinumerocontrato", query = "SELECT c FROM Cliente c WHERE c.clinumerocontrato = :clinumerocontrato")
    , @NamedQuery(name = "Cliente.findByClivalorexcedente", query = "SELECT c FROM Cliente c WHERE c.clivalorexcedente = :clivalorexcedente")})
public class Cliente implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cliid")
    private Integer cliid;
    @Column(name = "clitipo")
    private Integer clitipo;
    @Column(name = "clitipocad")
    private Integer clitipocad;
    @Column(name = "clirotadescricao")
    private String clirotadescricao;
    @Column(name = "clinome")
    public String clinome;
    @Column(name = "clifantasia")
    private String clifantasia;
    @Column(name = "clicpfcgc")
    private String clicpfcgc;
    @Column(name = "cliendereco")
    private String cliendereco;
    @Column(name = "clibairro")
    private String clibairro;
    @Column(name = "clinumero")
    private String clinumero;
    @Column(name = "clicidade")
    private String clicidade;
    @Column(name = "cliuf")
    private String cliuf;
    @Column(name = "clilongitude")
    private String clilongitude;
    @Column(name = "clilatitude")
    private String clilatitude;
    @Column(name = "clifone")
    private String clifone;
    @Column(name = "cliemail")
    private String cliemail;
    @Column(name = "clisenhausuario")
    public String clisenhausuario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "clivalorfixo")
    private BigDecimal clivalorfixo;
    @Column(name = "cliqtdecontratada")
    private BigDecimal cliqtdecontratada;
    @Column(name = "clinumerocontrato")
    private Integer clinumerocontrato;
    @Column(name = "clivalorexcedente")
    private BigDecimal clivalorexcedente;
    @JoinColumn(name = "clirota", referencedColumnName = "gdrid")
    @ManyToOne
    private Gruporota clirota;

    public Cliente() {
    }

    public Cliente(Integer cliid) {
        this.cliid = cliid;
    }

    public Integer getCliid() {
        return cliid;
    }

    public void setCliid(Integer cliid) {
        Integer oldCliid = this.cliid;
        this.cliid = cliid;
        changeSupport.firePropertyChange("cliid", oldCliid, cliid);
    }

    public Integer getClitipo() {
        return clitipo;
    }

    public void setClitipo(Integer clitipo) {
        Integer oldClitipo = this.clitipo;
        this.clitipo = clitipo;
        changeSupport.firePropertyChange("clitipo", oldClitipo, clitipo);
    }

    public Integer getClitipocad() {
        return clitipocad;
    }

    public void setClitipocad(Integer clitipocad) {
        Integer oldClitipocad = this.clitipocad;
        this.clitipocad = clitipocad;
        changeSupport.firePropertyChange("clitipocad", oldClitipocad, clitipocad);
    }

    public String getClirotadescricao() {
        return clirotadescricao;
    }

    public void setClirotadescricao(String clirotadescricao) {
        String oldClirotadescricao = this.clirotadescricao;
        this.clirotadescricao = clirotadescricao;
        changeSupport.firePropertyChange("clirotadescricao", oldClirotadescricao, clirotadescricao);
    }

    public String getClinome() {
        return clinome;
    }

    public void setClinome(String clinome) {
        String oldClinome = this.clinome;
        this.clinome = clinome;
        changeSupport.firePropertyChange("clinome", oldClinome, clinome);
    }

    public String getClifantasia() {
        return clifantasia;
    }

    public void setClifantasia(String clifantasia) {
        String oldClifantasia = this.clifantasia;
        this.clifantasia = clifantasia;
        changeSupport.firePropertyChange("clifantasia", oldClifantasia, clifantasia);
    }

    public String getClicpfcgc() {
        return clicpfcgc;
    }

    public void setClicpfcgc(String clicpfcgc) {
        String oldClicpfcgc = this.clicpfcgc;
        this.clicpfcgc = clicpfcgc;
        changeSupport.firePropertyChange("clicpfcgc", oldClicpfcgc, clicpfcgc);
    }

    public String getCliendereco() {
        return cliendereco;
    }

    public void setCliendereco(String cliendereco) {
        String oldCliendereco = this.cliendereco;
        this.cliendereco = cliendereco;
        changeSupport.firePropertyChange("cliendereco", oldCliendereco, cliendereco);
    }

    public String getClibairro() {
        return clibairro;
    }

    public void setClibairro(String clibairro) {
        String oldClibairro = this.clibairro;
        this.clibairro = clibairro;
        changeSupport.firePropertyChange("clibairro", oldClibairro, clibairro);
    }

    public String getClinumero() {
        return clinumero;
    }

    public void setClinumero(String clinumero) {
        String oldClinumero = this.clinumero;
        this.clinumero = clinumero;
        changeSupport.firePropertyChange("clinumero", oldClinumero, clinumero);
    }

    public String getClicidade() {
        return clicidade;
    }

    public void setClicidade(String clicidade) {
        String oldClicidade = this.clicidade;
        this.clicidade = clicidade;
        changeSupport.firePropertyChange("clicidade", oldClicidade, clicidade);
    }

    public String getCliuf() {
        return cliuf;
    }

    public void setCliuf(String cliuf) {
        String oldCliuf = this.cliuf;
        this.cliuf = cliuf;
        changeSupport.firePropertyChange("cliuf", oldCliuf, cliuf);
    }

    public String getClilongitude() {
        return clilongitude;
    }

    public void setClilongitude(String clilongitude) {
        String oldClilongitude = this.clilongitude;
        this.clilongitude = clilongitude;
        changeSupport.firePropertyChange("clilongitude", oldClilongitude, clilongitude);
    }

    public String getClilatitude() {
        return clilatitude;
    }

    public void setClilatitude(String clilatitude) {
        String oldClilatitude = this.clilatitude;
        this.clilatitude = clilatitude;
        changeSupport.firePropertyChange("clilatitude", oldClilatitude, clilatitude);
    }

    public String getClifone() {
        return clifone;
    }

    public void setClifone(String clifone) {
        String oldClifone = this.clifone;
        this.clifone = clifone;
        changeSupport.firePropertyChange("clifone", oldClifone, clifone);
    }

    public String getCliemail() {
        return cliemail;
    }

    public void setCliemail(String cliemail) {
        String oldCliemail = this.cliemail;
        this.cliemail = cliemail;
        changeSupport.firePropertyChange("cliemail", oldCliemail, cliemail);
    }

    public String getClisenhausuario() {
        return clisenhausuario;
    }

    public void setClisenhausuario(String clisenhausuario) {
        String oldClisenhausuario = this.clisenhausuario;
        this.clisenhausuario = clisenhausuario;
        changeSupport.firePropertyChange("clisenhausuario", oldClisenhausuario, clisenhausuario);
    }

    public BigDecimal getClivalorfixo() {
        return clivalorfixo;
    }

    public void setClivalorfixo(BigDecimal clivalorfixo) {
        BigDecimal oldClivalorfixo = this.clivalorfixo;
        this.clivalorfixo = clivalorfixo;
        changeSupport.firePropertyChange("clivalorfixo", oldClivalorfixo, clivalorfixo);
    }

    public BigDecimal getCliqtdecontratada() {
        return cliqtdecontratada;
    }

    public void setCliqtdecontratada(BigDecimal cliqtdecontratada) {
        BigDecimal oldCliqtdecontratada = this.cliqtdecontratada;
        this.cliqtdecontratada = cliqtdecontratada;
        changeSupport.firePropertyChange("cliqtdecontratada", oldCliqtdecontratada, cliqtdecontratada);
    }

    public Integer getClinumerocontrato() {
        return clinumerocontrato;
    }

    public void setClinumerocontrato(Integer clinumerocontrato) {
        Integer oldClinumerocontrato = this.clinumerocontrato;
        this.clinumerocontrato = clinumerocontrato;
        changeSupport.firePropertyChange("clinumerocontrato", oldClinumerocontrato, clinumerocontrato);
    }

    public BigDecimal getClivalorexcedente() {
        return clivalorexcedente;
    }

    public void setClivalorexcedente(BigDecimal clivalorexcedente) {
        BigDecimal oldClivalorexcedente = this.clivalorexcedente;
        this.clivalorexcedente = clivalorexcedente;
        changeSupport.firePropertyChange("clivalorexcedente", oldClivalorexcedente, clivalorexcedente);
    }

    public Gruporota getClirota() {
        return clirota;
    }

    public void setClirota(Gruporota clirota) {
        Gruporota oldClirota = this.clirota;
        this.clirota = clirota;
        changeSupport.firePropertyChange("clirota", oldClirota, clirota);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliid != null ? cliid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cliid == null && other.cliid != null) || (this.cliid != null && !this.cliid.equals(other.cliid))) {
            return false;
        }
        return true;
    }

      @Override
    public String toString() {
        return clinome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
