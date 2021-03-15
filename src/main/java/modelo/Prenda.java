/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author salaz
 */
@Entity
@Table(name = "prenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prenda.findAll", query = "SELECT p FROM Prenda p"),
    @NamedQuery(name = "Prenda.findById", query = "SELECT p FROM Prenda p WHERE p.id = :id"),
    @NamedQuery(name = "Prenda.findByCantidad", query = "SELECT p FROM Prenda p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Prenda.findByTipo", query = "SELECT p FROM Prenda p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Prenda.findByColor", query = "SELECT p FROM Prenda p WHERE p.color = :color")})
public class Prenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "color")
    private String color;

    public Prenda() {
    }

    public Prenda(Integer id) {
        this.id = id;
    }

    public Prenda(Integer id, int cantidad, String tipo, String color) {
        this.id = id;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        if (!(object instanceof Prenda)) {
            return false;
        }
        Prenda other = (Prenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Prenda[ id=" + id + " ]";
    }
    
}
