/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joli;

import java.util.List;

/**
 *
 * @author JGSS
 */
public class Joli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CRUDPessoa cp = new CRUDPessoa();
        
        Pessoa_alt pa = new Pessoa_alt();
        pa.setCodigo(0);
        pa.setCod_cidade(0);
        pa.setEmail("teste@teste.ts");
        pa.setEndereco("rua edit");
        pa.setNome("fim testado");
        pa.setTelefone("(00)1111-0000");
        
        //cp.pessoaSave(pa);
        
        
        //String l = cp.pessoaSearch("tes").toArray().toString();
        //System.out.println(l);
        
        cp.pessoaEdit(pa);
    }
    
}
