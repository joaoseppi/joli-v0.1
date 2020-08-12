/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joli;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JGSS
 */
public class CRUDPessoa {
    //SAVE----------------------------------------------------------------------
    
    public void pessoaFisSave(PessoaFis fis){
        Session sessao = null;
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            sessao.save(fis);
            transacao.commit();
            System.out.println("SUCCESS - CRUD.save.pessoaFisica");
        } catch(HibernateException hEx) {
            hEx.printStackTrace();
            System.out.println("ERROR - CRUD.save.pessoaFisica");
        } finally {
            sessao.close();
        }
    }
    
    public void pessoaJurSave(Juridica jur){
        Session sessao = null;
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            sessao.save(jur);
            transacao.commit();
            System.out.println("SUCCESS - CRUD.save.pessoaJuridica");
        } catch(HibernateException hEx) {
            hEx.printStackTrace();
            System.out.println("ERROR - CRUD.save.pessoaJuridica");
        } finally {
            sessao.close();
        }
    }
    
    public void funcionarioSave(Funcionario func, PessoaFis fis){
        Session sessao = null;
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            pessoaFisSave(fis);
            transacao.commit();
            sessao.save(func);
            transacao.commit();
            JOptionPane.showMessageDialog(null, "Funcionario salvo com sucesso");
            System.out.println("SUCCESS - CRUD.save.funcionario");
        } catch(HibernateException hEx) {
            hEx.printStackTrace();
            System.out.println("ERROR - CRUD.save.funcionario");
        } finally {
            sessao.close();
        }
    }
    
    /*
    public void clienteFisSave(Cliente func, PessoaFis cli){
        Session sessao = null;
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            pessoaFisSave(cli);
            transacao.commit();
            sessao.save(func);
            transacao.commit();
            JOptionPane.showMessageDialog(null, "Funcionario salvo com sucesso");
            System.out.println("SUCCESS - CRUD.save.clienteFisico");
        } catch(HibernateException hEx) {
            hEx.printStackTrace();
            System.out.println("ERROR - CRUD.save.clienteFisico");
        } finally {
            sessao.close();
        }
    }
    
    public void clienteJurSave(Cliente func, Juridica cli){
        Session sessao = null;
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            pessoaJurSave(cli);
            sessao.save(func);
            transacao.commit();
            JOptionPane.showMessageDialog(null, "Funcionario salvo com sucesso");
            System.out.println("SUCCESS - CRUD.save.clienteJuridico");
        } catch(HibernateException hEx) {
            hEx.printStackTrace();
            System.out.println("ERROR - CRUD.save.clienteJuridico");
        } finally {
            sessao.close();
        }
    }
*/
    public void pessoaSave(Pessoa_alt p){
        Session sessao = null;
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            sessao.save(p);
            transacao.commit();
            JOptionPane.showMessageDialog(null, "Funcionario salvo com sucesso");
            System.out.println("SUCCESS - CRUD.save.clienteJuridico");
        } catch(HibernateException hEx) {
            hEx.printStackTrace();
            System.out.println("ERROR - CRUD.save.clienteJuridico");
        } finally {
            sessao.close();
        }
    }
    
    //SEARCH--------------------------------------------------------------------
    
    public List<Pessoa_alt> clienteSearch(String sr){
        List<Pessoa_alt> resultado = new ArrayList();
        String sql = "FROM pessoa p, cliente c "
        + "WHERE nome LIKE '%" + sr + "%' "
        + "AND p.codigo = c.codigo"
        + "ORDER BY nome";
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();
            System.out.println("SUCCESS - CRUD.search.cliente");
        } catch (HibernateException hibEx) {
            System.out.println("ERROR - CRUD.search.cliente");
            hibEx.printStackTrace();
        }
        return resultado;
    }
    
    public List<Funcionario> funcionarioSearch(String sr){
        List<Funcionario> resultado = new ArrayList();
        String sql = "FROM pessoa p, funcionario c "
        + "WHERE nome LIKE '%" + sr + "%' "
        + "AND p.codigo = c.codigo"
        + "ORDER BY nome";
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();
            System.out.println("SUCCESS - CRUD.search.funcionario");
        } catch (HibernateException hibEx) {
            System.out.println("ERROR - CRUD.search.funcionario");
            hibEx.printStackTrace();
        }
        return resultado;
    }
    
    public List<Pessoa_alt> pessoaSearch(String sr){
        List<Pessoa_alt> resultado = new ArrayList();
        String sql = "FROM Pessoa_alt "
        + "WHERE nome LIKE '%" + sr + "%' "
        + "ORDER BY nome";
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();
            System.out.println("SUCCESS - CRUD.search.funcionario");
        } catch (HibernateException hibEx) {
            System.out.println("ERROR - CRUD.search.funcionario");
            hibEx.printStackTrace();
        }
        return resultado;
    }
    
    //EDIT--------------------------------------------------------------------
    
    public void clienteEdit(Cliente cli, Pessoa_alt pes){
        List resultado = null;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            int id;
            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Nome do cliente"
            +"a ser ALTERADO:", "Editar", JOptionPane.PLAIN_MESSAGE));

            org.hibernate.Query query = sessao.createQuery("FROM pessoa p, "
            + "cliente c, fisica f WHERE f.cod_pessoa = c.cod_fisica "
            + "AND f.cod_pessoa = p.codigo");

            resultado = query.list();
            for (Object obj : resultado) {
                sessao.update(pes);
                transacao.commit();
                sessao.update(cli);
                transacao.commit();
                JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
            }
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            System.out.println("ERROR - CRUD.update.cliente");
        }
    }
    
    public void funcionarioEdit(Funcionario cli, Pessoa_alt pes){
        List resultado = null;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            int id;
            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Nome do cliente"
            +"a ser ALTERADO:", "Editar", JOptionPane.PLAIN_MESSAGE));

            org.hibernate.Query query = sessao.createQuery("FROM pessoa p, "
            + "funcionario c, fisica f WHERE f.cod_pessoa = c.cod_fisica "
            + "AND f.cod_pessoa = p.codigo");

            resultado = query.list();
            for (Object obj : resultado) {
                sessao.update(pes);
                transacao.commit();
                sessao.update(cli);
                transacao.commit();
                JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
            }
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            System.out.println("ERROR - CRUD.update.funcionario");
        }
    }
    
    public void pessoaEdit(Pessoa_alt pes){
        List resultado = null;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            int id;
            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Nome do cliente"
            +"a ser ALTERADO:", "Editar", JOptionPane.PLAIN_MESSAGE));

            org.hibernate.Query query = sessao.createQuery("FROM Pessoa_alt "
            + "WHERE codigo = " + id);

            resultado = query.list();
            for (Object obj : resultado) {
                Pessoa_alt aux = (Pessoa_alt) obj;
                aux.setCod_cidade(pes.getCod_cidade());
                aux.setEmail(pes.getEmail());
                aux.setEndereco(pes.getEmail());
                aux.setNome(pes.getNome());
                aux.setTelefone(pes.getTelefone());
                sessao.update(aux);
                transacao.commit();
                JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
            }
            sessao.close();
            System.out.println("SUCCESS - CRUD.update.funcionario");
        } catch (HibernateException hibEx) {
            System.out.println("ERROR - CRUD.update.funcionario");
            hibEx.printStackTrace();
        }
    }
}
