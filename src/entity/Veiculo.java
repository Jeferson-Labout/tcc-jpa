/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jefson
 */
@Entity
@Table(name = "veiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Veiculo.findAll", query = "SELECT v FROM Veiculo v")
    , @NamedQuery(name = "Veiculo.findByVeiid", query = "SELECT v FROM Veiculo v WHERE v.veiid = :veiid")
    , @NamedQuery(name = "Veiculo.findByVeiplaca", query = "SELECT v FROM Veiculo v WHERE v.veiplaca = :veiplaca")
    , @NamedQuery(name = "Veiculo.findByVeimarca", query = "SELECT v FROM Veiculo v WHERE v.veimarca = :veimarca")
    , @NamedQuery(name = "Veiculo.findByVeimodelo", query = "SELECT v FROM Veiculo v WHERE v.veimodelo = :veimodelo")
    , @NamedQuery(name = "Veiculo.findByVeicor", query = "SELECT v FROM Veiculo v WHERE v.veicor = :veicor")})
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "veiid")
    private Integer veiid;
    @Column(name = "veiplaca",unique = true)
    private String veiplaca;
    @Column(name = "veimarca")
    private String veimarca;
    @Column(name = "veimodelo")
    private String veimodelo;
    @Column(name = "veicor")
    private String veicor;

    public Veiculo() {
    }

    public Integer getVeiid() {
        return veiid;
    }

    public void setVeiid(Integer veiid) {
        this.veiid = veiid;
    }

    public String getVeiplaca() {
        return veiplaca;
    }

    public void setVeiplaca(String veiplaca) {
        this.veiplaca = veiplaca;
    }

    public String getVeimarca() {
        return veimarca;
    }

    public void setVeimarca(String veimarca) {
        this.veimarca = veimarca;
    }

    public String getVeimodelo() {
        return veimodelo;
    }

    public void setVeimodelo(String veimodelo) {
        this.veimodelo = veimodelo;
    }

    public String getVeicor() {
        return veicor;
    }

    public void setVeicor(String veicor) {
        this.veicor = veicor;
    }

    

}
