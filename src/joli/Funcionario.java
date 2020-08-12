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

public class Funcionario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    
    @Column(name = "cod_pessoa")
    private int cod_pessoa;
    
    @Column(name = "cod_fisica")
    private int cod_fisica;
    
    @Column(name = "cargo")
    private String cargo;
    
    @Column(name = "data_contrato")
    private String data_contrato;
    
    @Column(name = "senha")
    private String senha;

    public Funcionario() {
    }

    public int getCodigo() {
        return codigo;
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

    public int getCod_fisica() {
        return cod_fisica;
    }

    public void setCod_fisica(int cod_fisica) {
        this.cod_fisica = cod_fisica;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getData_contrato() {
        return data_contrato;
    }

    public void setData_contrato(String data_contrato) {
        this.data_contrato = data_contrato;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
