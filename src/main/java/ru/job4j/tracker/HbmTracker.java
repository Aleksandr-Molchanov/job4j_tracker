package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public void init() {
    }

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        item.setId(id);
        Session session = sf.openSession();
        session.beginTransaction();
        String hql = "update Item i "
                + " SET i.name = :name, "
                + " i.created = :created, "
                + " i.description = :description "
                + " where i.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        query.setParameter("name", item.getName());
        query.setParameter("created", item.getCreated());
        query.setParameter("description", item.getDescription());
        int rsl = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return rsl != 0;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        String hql = "delete Item i "
                + " where i.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        int rsl = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return rsl != 0;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List rsl = session.createQuery("from ru.job4j.tracker.Item").list();
        session.getTransaction().commit();
        session.close();
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();
        List rsl = session.createQuery("from ru.job4j.tracker.Item where name = :name").
                setParameter("name", key).list();
        session.getTransaction().commit();
        session.close();
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item rsl = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return rsl;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}