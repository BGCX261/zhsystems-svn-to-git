/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehs.hiber;

import com.ehs.AppFrame;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author swaram
 */
public class HibernateManager {

    private static HibernateManager hibernateManager;
    private static Logger log = AppFrame.getLogger();

    static {
        hibernateManager = new HibernateManager();
    }

    public static HibernateManager getInstance() {
        return hibernateManager;
    }

    public boolean saveObject(final Object obj) {
        if (obj == null) {
            log.debug("Object is null");
            return false;
        }
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            log.error("Error while saving the object (" + obj.getClass().getSimpleName() + ") :" + ex.toString());
            return false;
        }
        return true;
    }
    
    public boolean updateObject(final Object obj) {
        if (obj == null) {
            log.debug("Object is null");
            return false;
        }
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(obj);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            log.error("Error while updating the object (" + obj.getClass().getSimpleName() + ") :" + ex.toString());
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
	public List<Object> getObjects(final Object obj) {
        List<Object> result = new ArrayList<Object>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = session.createQuery("from " + obj.getClass().getSimpleName()).list();
            session.close();
        } catch (Exception ex) {
            log.error("Error while getting Objects:" + ex.toString());
        }
        return result;
    }

    @SuppressWarnings("unchecked")
	public List<Object> getObjects(final Object obj, final String key, final String value) {
        List<Object> result = new ArrayList<Object>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            result = session.createQuery("from " + obj.getClass().getSimpleName()+" where "+key+"='"+value+"'").list();
            session.close();
        } catch (Exception ex) {
            log.error("Error while getting Objects:" + ex.toString());
        }
        return result;
    }
}
