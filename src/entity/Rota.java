/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jefson
 */
@Entity
@Table(name = "rota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rota.findAll", query = "SELECT r FROM Rota r")
    , @NamedQuery(name = "Rota.findByRotaid", query = "SELECT r FROM Rota r WHERE r.rotaid = :rotaid")
    , @NamedQuery(name = "Rota.findByRotagdrid", query = "SELECT r FROM Rota r WHERE r.rotagdrid = :rotagdrid")
    , @NamedQuery(name = "Rota.findByRotagdrdescricao", query = "SELECT r FROM Rota r WHERE r.rotagdrdescricao = :rotagdrdescricao")
    , @NamedQuery(name = "Rota.findByRotacliid", query = "SELECT r FROM Rota r WHERE r.rotacliid = :rotacliid")
    , @NamedQuery(name = "Rota.findByRotacliidmotorista", query = "SELECT r FROM Rota r WHERE r.rotacliidmotorista = :rotacliidmotorista")
    , @NamedQuery(name = "Rota.findByRotaveiid", query = "SELECT r FROM Rota r WHERE r.rotaveiid = :rotaveiid")
    , @NamedQuery(name = "Rota.findByRotaveiplaca", query = "SELECT r FROM Rota r WHERE r.rotaveiplaca = :rotaveiplaca")
    , @NamedQuery(name = "Rota.findByRotaveimodelo", query = "SELECT r FROM Rota r WHERE r.rotaveimodelo = :rotaveimodelo")
    , @NamedQuery(name = "Rota.findByRotaclinomemotorista", query = "SELECT r FROM Rota r WHERE r.rotaclinomemotorista = :rotaclinomemotorista")
    , @NamedQuery(name = "Rota.findByRotaclinome", query = "SELECT r FROM Rota r WHERE r.rotaclinome = :rotaclinome")
    , @NamedQuery(name = "Rota.findByRotaclifantasia", query = "SELECT r FROM Rota r WHERE r.rotaclifantasia = :rotaclifantasia")
    , @NamedQuery(name = "Rota.findByRotaclilongitude", query = "SELECT r FROM Rota r WHERE r.rotaclilongitude = :rotaclilongitude")
    , @NamedQuery(name = "Rota.findByRotaclilatitude", query = "SELECT r FROM Rota r WHERE r.rotaclilatitude = :rotaclilatitude")
    , @NamedQuery(name = "Rota.findByRotadata", query = "SELECT r FROM Rota r WHERE r.rotadata = :rotadata")
    , @NamedQuery(name = "Rota.findByRotadatacoleta", query = "SELECT r FROM Rota r WHERE r.rotadatacoleta = :rotadatacoleta")
    , @NamedQuery(name = "Rota.findByRotastatus", query = "SELECT r FROM Rota r WHERE r.rotastatus = :rotastatus")
    , @NamedQuery(name = "Rota.findByRotatipof", query = "SELECT r FROM Rota r WHERE r.rotatipof = :rotatipof")
    , @NamedQuery(name = "Rota.findByRotaqtdeexcedente", query = "SELECT r FROM Rota r WHERE r.rotaqtdeexcedente = :rotaqtdeexcedente")
    , @NamedQuery(name = "Rota.findByRotaqtde", query = "SELECT r FROM Rota r WHERE r.rotaqtde = :rotaqtde")
    , @NamedQuery(name = "Rota.findByRotavalorfixo", query = "SELECT r FROM Rota r WHERE r.rotavalorfixo = :rotavalorfixo")
    , @NamedQuery(name = "Rota.findByRotacliqtdecontratada", query = "SELECT r FROM Rota r WHERE r.rotacliqtdecontratada = :rotacliqtdecontratada")
    , @NamedQuery(name = "Rota.findByRotavalorexcedente", query = "SELECT r FROM Rota r WHERE r.rotavalorexcedente = :rotavalorexcedente")
    , @NamedQuery(name = "Rota.findByRotavalortotal", query = "SELECT r FROM Rota r WHERE r.rotavalortotal = :rotavalortotal")
    , @NamedQuery(name = "Rota.findByRotaobservacao", query = "SELECT r FROM Rota r WHERE r.rotaobservacao = :rotaobservacao")
    , @NamedQuery(name = "Rota.findByRotaresponsavel", query = "SELECT r FROM Rota r WHERE r.rotaresponsavel = :rotaresponsavel")
    , @NamedQuery(name = "Rota.findByRotaclifone", query = "SELECT r FROM Rota r WHERE r.rotaclifone = :rotaclifone")
    , @NamedQuery(name = "Rota.findByRotacliemail", query = "SELECT r FROM Rota r WHERE r.rotacliemail = :rotacliemail")
    , @NamedQuery(name = "Rota.findByRotaclicpfcgc", query = "SELECT r FROM Rota r WHERE r.rotaclicpfcgc = :rotaclicpfcgc")
    , @NamedQuery(name = "Rota.findByRotacliendereco", query = "SELECT r FROM Rota r WHERE r.rotacliendereco = :rotacliendereco")
    , @NamedQuery(name = "Rota.findByRotaclibairro", query = "SELECT r FROM Rota r WHERE r.rotaclibairro = :rotaclibairro")
    , @NamedQuery(name = "Rota.findByRotaclinumero", query = "SELECT r FROM Rota r WHERE r.rotaclinumero = :rotaclinumero")
    , @NamedQuery(name = "Rota.findByRotaclicidade", query = "SELECT r FROM Rota r WHERE r.rotaclicidade = :rotaclicidade")
    , @NamedQuery(name = "Rota.findByRotacliuf", query = "SELECT r FROM Rota r WHERE r.rotacliuf = :rotacliuf")})
public class Rota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rotaid")
    private Integer rotaid;
    @Column(name = "rotagdrid")
    private Integer rotagdrid;
    @Column(name = "rotagdrdescricao")
    private String rotagdrdescricao;
    @Column(name = "rotacliid")
    private Integer rotacliid;
    @Column(name = "rotacliidmotorista")
    private Integer rotacliidmotorista;
    @Column(name = "rotaveiid")
    private Integer rotaveiid;
    @Column(name = "rotaveiplaca")
    private String rotaveiplaca;
    @Column(name = "rotaveimodelo")
    private String rotaveimodelo;
    @Column(name = "rotaclinomemotorista")
    private String rotaclinomemotorista;
    @Column(name = "rotaclinome")
    private String rotaclinome;
    @Column(name = "rotaclifantasia")
    private String rotaclifantasia;
    @Column(name = "rotaclilongitude")
    private String rotaclilongitude;
    @Column(name = "rotaclilatitude")
    private String rotaclilatitude;
    @Column(name = "rotadata")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rotadata;
    @Column(name = "rotadatacoleta")
    @Temporal(TemporalType.DATE)
    private Date rotadatacoleta;
    @Column(name = "rotastatus")
    private String rotastatus;
    @Column(name = "rotatipof")
    private String rotatipof;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rotaqtdeexcedente")
    private BigDecimal rotaqtdeexcedente;
    @Column(name = "rotaqtde")
    private BigDecimal rotaqtde;
    @Column(name = "rotavalorfixo")
    private BigDecimal rotavalorfixo;
    @Column(name = "rotacliqtdecontratada")
    private BigDecimal rotacliqtdecontratada;
    @Column(name = "rotavalorexcedente")
    private BigDecimal rotavalorexcedente;
    @Column(name = "rotavalortotal")
    private BigDecimal rotavalortotal;
    @Column(name = "rotaobservacao")
    private String rotaobservacao;
    @Column(name = "rotaresponsavel")
    private String rotaresponsavel;
    @Column(name = "rotaclifone")
    private String rotaclifone;
    @Column(name = "rotacliemail")
    private String rotacliemail;
    @Column(name = "rotaclicpfcgc")
    private String rotaclicpfcgc;
    @Column(name = "rotacliendereco")
    private String rotacliendereco;
    @Column(name = "rotaclibairro")
    private String rotaclibairro;
    @Column(name = "rotaclinumero")
    private String rotaclinumero;
    @Column(name = "rotaclicidade")
    private String rotaclicidade;
    @Column(name = "rotacliuf")
    private String rotacliuf;

    public Rota() {
    }

    public Rota(Integer rotaid) {
        this.rotaid = rotaid;
    }

    public Integer getRotaid() {
        return rotaid;
    }

    public void setRotaid(Integer rotaid) {
        this.rotaid = rotaid;
    }

    public Integer getRotagdrid() {
        return rotagdrid;
    }

    public void setRotagdrid(Integer rotagdrid) {
        this.rotagdrid = rotagdrid;
    }

    public String getRotagdrdescricao() {
        return rotagdrdescricao;
    }

    public void setRotagdrdescricao(String rotagdrdescricao) {
        this.rotagdrdescricao = rotagdrdescricao;
    }

    public Integer getRotacliid() {
        return rotacliid;
    }

    public void setRotacliid(Integer rotacliid) {
        this.rotacliid = rotacliid;
    }

    public Integer getRotacliidmotorista() {
        return rotacliidmotorista;
    }

    public void setRotacliidmotorista(Integer rotacliidmotorista) {
        this.rotacliidmotorista = rotacliidmotorista;
    }

    public Integer getRotaveiid() {
        return rotaveiid;
    }

    public void setRotaveiid(Integer rotaveiid) {
        this.rotaveiid = rotaveiid;
    }

    public String getRotaveiplaca() {
        return rotaveiplaca;
    }

    public void setRotaveiplaca(String rotaveiplaca) {
        this.rotaveiplaca = rotaveiplaca;
    }

    public String getRotaveimodelo() {
        return rotaveimodelo;
    }

    public void setRotaveimodelo(String rotaveimodelo) {
        this.rotaveimodelo = rotaveimodelo;
    }

    public String getRotaclinomemotorista() {
        return rotaclinomemotorista;
    }

    public void setRotaclinomemotorista(String rotaclinomemotorista) {
        this.rotaclinomemotorista = rotaclinomemotorista;
    }

    public String getRotaclinome() {
        return rotaclinome;
    }

    public void setRotaclinome(String rotaclinome) {
        this.rotaclinome = rotaclinome;
    }

    public String getRotaclifantasia() {
        return rotaclifantasia;
    }

    public void setRotaclifantasia(String rotaclifantasia) {
        this.rotaclifantasia = rotaclifantasia;
    }

    public String getRotaclilongitude() {
        return rotaclilongitude;
    }

    public void setRotaclilongitude(String rotaclilongitude) {
        this.rotaclilongitude = rotaclilongitude;
    }

    public String getRotaclilatitude() {
        return rotaclilatitude;
    }

    public void setRotaclilatitude(String rotaclilatitude) {
        this.rotaclilatitude = rotaclilatitude;
    }

    public Date getRotadata() {
        return rotadata;
    }

    public void setRotadata(Date rotadata) {
        this.rotadata = rotadata;
    }

    public Date getRotadatacoleta() {
        return rotadatacoleta;
    }

    public void setRotadatacoleta(Date rotadatacoleta) {
        this.rotadatacoleta = rotadatacoleta;
    }

    public String getRotastatus() {
        return rotastatus;
    }

    public void setRotastatus(String rotastatus) {
        this.rotastatus = rotastatus;
    }

    public String getRotatipof() {
        return rotatipof;
    }

    public void setRotatipof(String rotatipof) {
        this.rotatipof = rotatipof;
    }

    public BigDecimal getRotaqtdeexcedente() {
        return rotaqtdeexcedente;
    }

    public void setRotaqtdeexcedente(BigDecimal rotaqtdeexcedente) {
        this.rotaqtdeexcedente = rotaqtdeexcedente;
    }

    public BigDecimal getRotaqtde() {
        return rotaqtde;
    }

    public void setRotaqtde(BigDecimal rotaqtde) {
        this.rotaqtde = rotaqtde;
    }

    public BigDecimal getRotavalorfixo() {
        return rotavalorfixo;
    }

    public void setRotavalorfixo(BigDecimal rotavalorfixo) {
        this.rotavalorfixo = rotavalorfixo;
    }

    public BigDecimal getRotacliqtdecontratada() {
        return rotacliqtdecontratada;
    }

    public void setRotacliqtdecontratada(BigDecimal rotacliqtdecontratada) {
        this.rotacliqtdecontratada = rotacliqtdecontratada;
    }

    public BigDecimal getRotavalorexcedente() {
        return rotavalorexcedente;
    }

    public void setRotavalorexcedente(BigDecimal rotavalorexcedente) {
        this.rotavalorexcedente = rotavalorexcedente;
    }

    public BigDecimal getRotavalortotal() {
        return rotavalortotal;
    }

    public void setRotavalortotal(BigDecimal rotavalortotal) {
        this.rotavalortotal = rotavalortotal;
    }

    public String getRotaobservacao() {
        return rotaobservacao;
    }

    public void setRotaobservacao(String rotaobservacao) {
        this.rotaobservacao = rotaobservacao;
    }

    public String getRotaresponsavel() {
        return rotaresponsavel;
    }

    public void setRotaresponsavel(String rotaresponsavel) {
        this.rotaresponsavel = rotaresponsavel;
    }

    public String getRotaclifone() {
        return rotaclifone;
    }

    public void setRotaclifone(String rotaclifone) {
        this.rotaclifone = rotaclifone;
    }

    public String getRotacliemail() {
        return rotacliemail;
    }

    public void setRotacliemail(String rotacliemail) {
        this.rotacliemail = rotacliemail;
    }

    public String getRotaclicpfcgc() {
        return rotaclicpfcgc;
    }

    public void setRotaclicpfcgc(String rotaclicpfcgc) {
        this.rotaclicpfcgc = rotaclicpfcgc;
    }

    public String getRotacliendereco() {
        return rotacliendereco;
    }

    public void setRotacliendereco(String rotacliendereco) {
        this.rotacliendereco = rotacliendereco;
    }

    public String getRotaclibairro() {
        return rotaclibairro;
    }

    public void setRotaclibairro(String rotaclibairro) {
        this.rotaclibairro = rotaclibairro;
    }

    public String getRotaclinumero() {
        return rotaclinumero;
    }

    public void setRotaclinumero(String rotaclinumero) {
        this.rotaclinumero = rotaclinumero;
    }

    public String getRotaclicidade() {
        return rotaclicidade;
    }

    public void setRotaclicidade(String rotaclicidade) {
        this.rotaclicidade = rotaclicidade;
    }

    public String getRotacliuf() {
        return rotacliuf;
    }

    public void setRotacliuf(String rotacliuf) {
        this.rotacliuf = rotacliuf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rotaid != null ? rotaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rota)) {
            return false;
        }
        Rota other = (Rota) object;
        if ((this.rotaid == null && other.rotaid != null) || (this.rotaid != null && !this.rotaid.equals(other.rotaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Rota[ rotaid=" + rotaid + " ]";
    }
    
}
