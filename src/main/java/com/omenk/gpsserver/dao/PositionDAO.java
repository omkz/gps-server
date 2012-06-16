/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omenk.gpsserver.dao;

import com.omenk.gpsserver.model.Position;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author omenkzz
 */
public interface PositionDAO {
    
    public Long count();
   
    @Transactional
    public void persist(Position o);
    
}
