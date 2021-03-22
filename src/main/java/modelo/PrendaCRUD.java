/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import javax.persistence.*;
import java.util.List;

/**
 *
 * @author salaz
 */
public class PrendaCRUD {
    static String pom = "com.mycompany_ropaCRUD_war_1.0-SNAPSHOTPU";
    
    public static List<Prenda> getPrendas() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(pom);
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM Prenda";
        Query q = manager.createNativeQuery(sql,Prenda.class); 
        List<Prenda> ropaBD =  q.getResultList();

        return ropaBD;        
        }    
     

        public static void insertaPrenda(Prenda prend) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(pom);
        EntityManager manager = factory.createEntityManager();
         manager.getTransaction().begin();
        manager.merge(prend);
        manager.getTransaction().commit();
        }
        
        public static int borrarPrenda(int id) {
            
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(pom);
        EntityManager manager = factory.createEntityManager();   
        String sql = "DELETE from Prenda p WHERE p.id = " + id;
        Query q = manager.createQuery(sql);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate(); 
        manager.getTransaction().commit();
        return filasAfectadas;  
        
       

    }
        
        public static int actualizaPrenda(Prenda miPrenda) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(pom);
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Prenda p SET p.tipo = :tipo, p.cantidad = :cantidad, p.color = :color WHERE p.id = :id";
        Query q = manager.createQuery(sql,Prenda.class);
        q.setParameter("id", miPrenda.getId());
        q.setParameter("tipo", miPrenda.getTipo());
        q.setParameter("cantidad", miPrenda.getCantidad());
        q.setParameter("color", miPrenda.getColor());
        
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        manager.close();
        return filasAfectadas;      
    }
        
      public static Prenda getPrenda(int id) {  
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(pom);
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT p FROM Prenda p WHERE p.id=" + id;
        Query q = manager.createQuery(sql,Prenda.class); 
        Prenda prend =  ( Prenda ) q.getSingleResult(); 
        manager.close();
        return  prend;
        } 
}
