package com.mefis.dao;

import com.mefis.dto.ImageDTO;
import org.hibernate.*;
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
@EnableCaching
public class ImageDAOImpl implements ImageDAO {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public ImageDTO addImage(ImageDTO imageDTO) {
        Session session = getSession();
        try {
            session.save(imageDTO);
            return imageDTO;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Cacheable("images")
    @Override
    public ImageDTO getImage(Long id) {
        Session session = getSession();
        try {
            Query query = session.createQuery("from ImageDTO image where image.id = :id");
            query.setParameter("id", id);
            List<ImageDTO> profileDTOList = query.list();
            if (profileDTOList.size() == 0)throw new RuntimeException("No such Image");
            return profileDTOList.get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
