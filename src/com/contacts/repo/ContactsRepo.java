package com.contacts.repo;

import java.sql.SQLException;
import java.util.List;

public interface ContactsRepo {
    void save(ContactsEntity contactsEntity) throws SQLException;

    ContactsEntity getContactByName(String name) throws SQLException;

    ContactsEntity getContactByPhone(String phone) throws SQLException;

    List<ContactsEntity> getAll() throws SQLException;

    void update(ContactsEntity contactsEntity) throws SQLException;

    void deleteByName(String name) throws SQLException;

    void deleteByPhone(String phone) throws SQLException;
}
