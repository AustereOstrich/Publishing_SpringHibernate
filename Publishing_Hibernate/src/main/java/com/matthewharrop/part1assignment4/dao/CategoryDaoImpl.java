package com.matthewharrop.part1assignment4.dao;

import com.matthewharrop.part1assignment4.domain.Book;
import com.matthewharrop.part1assignment4.domain.Category;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("CategoryDaoImpl")
public class CategoryDaoImpl {

        private static final Log logger = LogFactory.getLog(com.matthewharrop.part1assignment4.dao.CategoryDaoImpl.class);
        private SessionFactory sessionFactory;

        @Transactional(readOnly = true)
        public List<Category> findAll() {
            return sessionFactory.getCurrentSession().createQuery("from Category b", Category.class).list();
        }


}
