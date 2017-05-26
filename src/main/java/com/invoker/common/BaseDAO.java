package com.invoker.common;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24 at 23:52
 */
@Repository
public abstract class BaseDAO<T extends Object>{
    @PersistenceContext
    private EntityManager entityManager;
    private Integer id;

    private T entity;
    private Class<T> entityClass;
    public void clear(){
        entity=null;
        entityClass=null;
        id=null;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        clear();
        this.id = id;
    }
    @SuppressWarnings("unchecked")
    public void setEntity(T entity) {
        this.entity = entity;
        this.entityClass= (Class<T>) entity.getClass();
    }
    @SuppressWarnings("unchecked")
    public T getEntity(){
        if (entity != null) {
            return entity;
        }
        /**
         * 通过反射机制得到相应的实体对象T
         */
        if (entityClass == null) {
            Type type=getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType=(ParameterizedType)type;
                entityClass=(Class<T>)parameterizedType.getActualTypeArguments()[0];
            }else{
                throw new IllegalArgumentException("无法通过映射找到对应的管理实体对象");
            }
        }
        entity=find();
        return entity;

    }
    /**
     * 根据主键查找指定实体
     * @return
     */
    @Transactional(readOnly = true)
    private T find() {
        if (null == id) {
            throw new RuntimeException("未指定实体id");
        }

        return entityManager.find(entityClass, id);
    }
    /**
     * 以下的方法为共用的方法
     *
     * **/


    @Transactional(readOnly = true)
    public T findById(Integer id) {
        if (null == id) {
            throw new RuntimeException("未指定实体id");
        }

        return entityManager.find(entityClass, id);
    }
    @Transactional()
    public void save(T entity) {
         entityManager.persist(entity);
        entityManager.flush();
    }
    @Transactional()
    public void save(List<T> entities){
        for (T t : entities) {
            entityManager.persist(t);
            entityManager.flush();
        }
    }
    @Transactional()
    public void update(T entity){
        entityManager.merge(entity);
        entityManager.flush();
    }
    @Transactional()
    public void update(List<T> entities){
        for (T t : entities) {
            entityManager.merge(t);
            entityManager.flush();
        }
    }
    @Transactional(readOnly = true)
    public void list(){
        Query nativeQuery = entityManager.createNativeQuery("select * from game_info",entityClass);

    }
}
