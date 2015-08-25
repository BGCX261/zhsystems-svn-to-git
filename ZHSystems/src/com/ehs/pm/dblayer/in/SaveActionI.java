/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ehs.pm.dblayer.in;

/**
 *
 * @author E15567
 */
public interface SaveActionI {

    public boolean saveToXml();

    public boolean saveToDB();

    public String getFileName();
}
