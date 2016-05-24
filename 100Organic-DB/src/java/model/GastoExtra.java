/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 631410038
 */
@Entity
public class GastoExtra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nomeGastoExtra;
    private int quantGastoExtra;
    private double precoGastoExtra;

    public String getNomeGastoExtra() {
        return nomeGastoExtra;
    }

    public void setNomeGastoExtra(String nomeGastoExtra) {
        this.nomeGastoExtra = nomeGastoExtra;
    }

    public int getQuantGastoExtra() {
        return quantGastoExtra;
    }

    public void setQuantGastoExtra(int quantGastoExtra) {
        this.quantGastoExtra = quantGastoExtra;
    }

    public double getPrecoGastoExtra() {
        return precoGastoExtra;
    }

    public void setPrecoGastoExtra(double precoGastoExtra) {
        this.precoGastoExtra = precoGastoExtra;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastoExtra)) {
            return false;
        }
        GastoExtra other = (GastoExtra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.GastoExtra[ id=" + id + " ]";
    }
    
}
