/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joli;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    
    @Column(name = "cod_pessoa")
    private int cod_pessoa;
    
    @Column(name = "cod_juridica")
    private int cod_juridica;
    
    @Column(name = "cod_fisica")
    private int cod_fisica;

    public int getCodigo() {
        return codigo;
    }

    public Cliente() {
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCod_pessoa() {
        return cod_pessoa;
    }

    public void setCod_pessoa(int cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    public int getCod_juridica() {
        return cod_juridica;
    }

    public void setCod_juridica(int cod_juridica) {
        this.cod_juridica = cod_juridica;
    }

    public int getCod_fisica() {
        return cod_fisica;
    }

    public void setCod_fisica(int cod_fisica) {
        this.cod_fisica = cod_fisica;
    }
    
}
