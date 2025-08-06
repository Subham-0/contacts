package com.contacts.tests;

import com.contacts.repo.ContactRepoImpl;
import com.contacts.repo.ContactsEntity;

import java.sql.SQLException;
import java.util.List;

public class ContactRepoTests {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        testGetAll();
//        testSaveContact();
//        testGetContactByName("ABC");
//        testGetContactByPhone("7890678760");
//        ContactsEntity contactsEntity = new ContactsEntity();
//        testUpdate(contactsEntity);
//        testDeleteByName("Subham");
//        testDeleteByPhone("7890678760");
    }

    private static void testSaveContact() {
        try {
            ContactRepoImpl contactRepo = new ContactRepoImpl();
            ContactsEntity contactsEntity = new ContactsEntity();
            contactsEntity.setName("Hari");
            contactsEntity.setEmail("hari223@gmail.com");
            contactsEntity.setPhone("7890678760");

            contactRepo.save(contactsEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testGetContactByName(String name) {
        try {
            ContactRepoImpl contactRepo = new ContactRepoImpl();
            ContactsEntity contactsEntity = contactRepo.getContactByName(name);
            String number = contactsEntity.getPhone();
            if (number == null) {
                System.err.println("No Results");
            } else {
                System.out.println(number);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void testGetContactByPhone(String phone) {
        try {
            ContactRepoImpl contactRepo = new ContactRepoImpl();
            ContactsEntity contactsEntity = contactRepo.getContactByPhone(phone);
            String number = contactsEntity.getPhone();
            if (number == null) {
                System.err.println("No Results");
            } else {
                System.out.println(number);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testGetAll() {
        try {
            ContactRepoImpl contactRepo = new ContactRepoImpl();
            List<ContactsEntity> contactsEntities = contactRepo.getAll();
            contactsEntities.forEach(contactsEntity -> System.out.println(contactsEntity.getPhone()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testUpdate(ContactsEntity contactsEntity) {
        try {
            ContactRepoImpl contactRepo = new ContactRepoImpl();
            contactsEntity.setName("Subham");
            contactsEntity.setPhone("8989786791");
            contactRepo.update(contactsEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testDeleteByName(String name) {
        try {
            ContactRepoImpl contactRepo = new ContactRepoImpl();
            contactRepo.deleteByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testDeleteByPhone(String phone) {
        try {
            ContactRepoImpl contactRepo = new ContactRepoImpl();
            contactRepo.deleteByPhone(phone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
