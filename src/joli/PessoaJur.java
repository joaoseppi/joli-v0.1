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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "juridica")
@SecondaryTable(name = "pessoa", pkJoinColumns = @PrimaryKeyJoinColumn(name = "cod_pessoa", referencedColumnName = "codigo"))
public class PessoaJur implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int codigo;
    
    @Version
    private String cnpj;
    private String natureza_jur;
    private String abertura; 
    private String cnae;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "endereco")
    private String endereco;

    public PessoaJur() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNatureza_jur() {
        return natureza_jur;
    }

    public void setNatureza_jur(String natureza_jur) {
        this.natureza_jur = natureza_jur;
    }

    public String getAbertura() {
        return abertura;
    }

    public void setAbertura(String abertura) {
        this.abertura = abertura;
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}
