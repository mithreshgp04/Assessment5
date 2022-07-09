package com.prodapt.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class BusinessLogic {
	public void createRecord() {
        //your responsibility is to retrieve session object
    	Session session = HelperDBConnect.setup();{
        Product e1 = new Product(1, "Insulation Tape",45);

        Product e2 = new Product(2, "Screws",60);

        Product e3 = new Product(3, "Fan",200); // By constructor
        
        Product e4 = new Product(4,"Switch Board Set",120);
        
        Product e5 = new Product(5,"2-Pin Wires",80);

        session.save(e1);
        session.save(e2);
        session.save(e3);
        session.save(e4);
        session.save(e5);
        System.out.println("records got completed succesfully");
    	}
    	session.close();
	}
        
        public void readrecord() {
        Session session = HelperDBConnect.setup();{
        List libs = session.createQuery("from Product").list();//this represents HQL,similar to select * from Customer in SQL
        for (Iterator iterator = libs.iterator(); iterator.hasNext();){


        Product lib = (Product) iterator.next();

        System.out.println(lib.getId() + " " + lib.getName() +lib.getCost()+" ");
        }

    }
    	session.close();
    }
	
//update
	public void updaterecord(){
	Session session = HelperDBConnect.setup();{
	Transaction tx=session.beginTransaction();
    Query q=session.createQuery("update Product set name=:nn where id=:oo");
    q.setParameter("nn","3-pin connector");     //record 10
    q.setParameter("oo",6);

    int status=q.executeUpdate();
    System.out.println(status);
    tx.commit();
	}
	session.close();
	}
	
	//delete
	public void deleterecord() {
		Session session = HelperDBConnect.setup();{
			Transaction tx2=session.beginTransaction();
			Query q1=session.createQuery("delete Product  where id=:p2");
            //q.setParameter("p1","Sujith");     //record 10
            q1.setParameter("p2",10);

            int status1=q1.executeUpdate();
            System.out.println(status1);
           tx2.commit();

             //t.commit();
             session.close();
		}
	}
}
