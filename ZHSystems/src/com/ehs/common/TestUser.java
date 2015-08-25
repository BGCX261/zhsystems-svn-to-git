/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehs.common;

import com.ehs.hiber.HibernateManager;
import com.ehs.hiber.beans.Huser;
import java.util.List;

/**
 *
 * @author swaram
 */
public class TestUser {

    public static void main(String args[]) {

      List<Object> result =   HibernateManager.getInstance().getObjects(new Huser());

      System.out.println(result.size());
    }
}
