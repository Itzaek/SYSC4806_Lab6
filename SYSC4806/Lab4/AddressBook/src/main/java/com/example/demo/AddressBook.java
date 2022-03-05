package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<BuddyInfo> buddyInfos;
    private String name;

    public static void main(String[] args) {
        BuddyInfo bd1 = new BuddyInfo("Isaac","12 Snow Street","111-111-111");
        BuddyInfo bd2 = new BuddyInfo("Jack","34 Bean Road","123-456-789");
        BuddyInfo bd3 = new BuddyInfo("Jill","54 Acorn Crescent","132-645-978");

        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(bd1);
        addressBook.addBuddy(bd2);
        addressBook.addBuddy(bd3);
        addressBook.toString();
    }

    public AddressBook(String name) {
        this.name = name;
        buddyInfos = new ArrayList<>();
    }

    public AddressBook() {
        name = "Default" + this.getId();
        buddyInfos = new ArrayList<>();
    }

    public List<BuddyInfo> getBuddyInfos() {
        return buddyInfos;
    }

    public void setBuddyInfos(List<BuddyInfo> buddyInfos) {
        this.buddyInfos = buddyInfos;
    }

    public void addBuddy(BuddyInfo buddy) {
        if(buddy != null) {
            buddyInfos.add(buddy);
        }
    }

    public BuddyInfo removeBuddy(int index) {
        if(index >= 0 && index < buddyInfos.size()) {
            return buddyInfos.remove(index);
        }
        return null;
    }

    public String toString() {
        String addressBook = "";
        for(BuddyInfo buddyInfo: buddyInfos) {
            addressBook = addressBook + buddyInfo + "\n";
        }
        return addressBook;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

