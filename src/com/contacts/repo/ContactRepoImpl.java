package com.contacts.repo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactRepoImpl implements ContactsRepo {
    private final String url = "jdbc:mysql://localhost:3306/subham";
    private final String username = "root";
    private final String password = "Run@0";

    private Connection con;

    public ContactRepoImpl() throws SQLException {
        con = DriverManager.getConnection(url, username, password);
//        System.out.println("diver connected");
    }

    @Override
    public void save(ContactsEntity contactsEntity) throws SQLException {
        PreparedStatement pst = con.prepareStatement("insert into contacts values(0,?,?,?)");
        pst.setString(1, contactsEntity.getName());
        pst.setString(2, contactsEntity.getPhone());
        pst.setString(3, contactsEntity.getEmail());
        pst.execute();
    }

    @Override
    public ContactsEntity getContactByName(String name) throws SQLException {
        PreparedStatement pst = con.prepareStatement("select phnumber from contacts where name=?");
        pst.setString(1, name);
        ResultSet rs = pst.executeQuery();
        ContactsEntity contactsEntity = new ContactsEntity();
        while (rs.next()) {
            contactsEntity.setPhone(rs.getString("phnumber"));
        }
        return contactsEntity;
    }

    @Override
    public ContactsEntity getContactByPhone(String phone) throws SQLException {
        PreparedStatement pst = con.prepareStatement("select phnumber from contacts where phnumber=?");
        pst.setString(1, phone);
        ResultSet rs = pst.executeQuery();
        ContactsEntity contactsEntity = new ContactsEntity();
        while (rs.next()) {
            contactsEntity.setPhone(rs.getString("phnumber"));
        }
        return contactsEntity;
    }

    @Override
    public List<ContactsEntity> getAll() throws SQLException {
        PreparedStatement pst = con.prepareStatement("select phnumber from contacts");
        ResultSet rs = pst.executeQuery();
        List<ContactsEntity> contactsEntities = new ArrayList<ContactsEntity>();
        while (rs.next()) {
            ContactsEntity contactsEntity = new ContactsEntity();
            contactsEntity.setPhone(rs.getString("phnumber"));
            contactsEntities.add(contactsEntity);
        }
        return contactsEntities;
    }

    @Override
    public void update(ContactsEntity contactsEntity) throws SQLException {
        PreparedStatement pst = con.prepareStatement("update contacts set name =? where phnumber=?");
        pst.setString(1, contactsEntity.getName());
        pst.setString(2, contactsEntity.getPhone());
        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated == 0) {
            throw new SQLException("Update failed: No contact found with phone number " + contactsEntity.getPhone());
        }
        System.out.println("Contact updated successfully");
    }

    @Override
    public void deleteByName(String name) throws SQLException {
        PreparedStatement pst = con.prepareStatement("delete from contacts where name =?");
        pst.setString(1, name);
        int rowsUpdated = pst.executeUpdate();  // ✅ returns number of rows updated
        if (rowsUpdated == 0) {
            throw new SQLException("Update failed: No contact found with name : " +name);
        }

        System.out.println("Contact deleted successfully");
    }

    @Override
    public void deleteByPhone(String phone) throws SQLException {
        PreparedStatement pst = con.prepareStatement("delete from contacts where phnumber =?");
        pst.setString(1, phone);
        int rowsUpdated = pst.executeUpdate();  // ✅ returns number of rows updated
        if (rowsUpdated == 0) {
            throw new SQLException("Update failed: No contact found with phone number : " +phone);
        }
        System.out.println("Contact deleted successfully");
    }
}
