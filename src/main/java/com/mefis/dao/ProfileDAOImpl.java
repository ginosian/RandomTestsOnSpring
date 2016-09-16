package com.mefis.dao;

import com.mefis.dto.ProfileDTO;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lion on 7/28/16.
 */
@Repository
@Transactional
public class ProfileDAOImpl implements ProfileDAO {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public ProfileDTO addProfile(ProfileDTO profileDTO) {
        Session session = getSession();
        try {
            session.save(profileDTO);
            return profileDTO;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Cacheable("profiles")
    @Override
    public ProfileDTO getProfile(Long id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Session session = getSession();
        try{
            Query query = session.createQuery("from ProfileDTO profile where profile.id = :id");
            query.setParameter("id", id);
            List<ProfileDTO> profileDTOList = query.list();
            if (profileDTOList.size() == 0)throw new RuntimeException("No such Profile");
            return profileDTOList.get(0);
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
