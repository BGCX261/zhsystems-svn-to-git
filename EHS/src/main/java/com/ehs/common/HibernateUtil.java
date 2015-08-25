/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ehs.common;

import com.ehs.AppFrame;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author swaram
 */
public class HibernateUtil {
    private static  final Logger log = AppFrame.getLogger();
    private static final SessionFactory sessionFactory;

    static{
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();

        }catch(Throwable th) {
            log.error("Initial Session Factory creation failed."+th);
            throw new ExceptionInInitializerError(th);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
