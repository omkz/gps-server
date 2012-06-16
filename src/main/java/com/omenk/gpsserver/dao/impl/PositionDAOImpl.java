/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omenk.gpsserver.dao.impl;

import com.omenk.gpsserver.dao.PositionDAO;
import com.omenk.gpsserver.model.Position;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author omenkzz
 */

@Transactional
@Repository("positionDAOImpl")
public class PositionDAOImpl implements PositionDAO{
    
    
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public Long count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void persist(Position o) {
        this.entityManager.persist(o);
    }
    
}
