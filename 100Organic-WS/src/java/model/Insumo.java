/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 631410038
 */
public class Insumo {

    private Long id;

    private String nomeInsumo;
    private int quantInsumo;
    private double precoInsumo;

    public String getNomeInsumo() {
        return nomeInsumo;
    }

    public void setNomeInsumo(String nomeInsumo) {
        this.nomeInsumo = nomeInsumo;
    }

    public int getQuantInsumo() {
        return quantInsumo;
    }

    public void setQuantInsumo(int quantInsumo) {
        this.quantInsumo = quantInsumo;
    }

    public double getPrecoInsumo() {
        return precoInsumo;
    }

    public void setPrecoInsumo(double precoInsumo) {
        this.precoInsumo = precoInsumo;
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
        if (!(object instanceof Insumo)) {
            return false;
        }
        Insumo other = (Insumo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Insumo[ id=" + id + " ]";
    }

}
