package ua.ppadalka.webstore.account.model;

public enum Role {

    SYSADMIN(1), SALESMANAGER(2), CUSTOMER(3);

    private Integer id;

    Role(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
