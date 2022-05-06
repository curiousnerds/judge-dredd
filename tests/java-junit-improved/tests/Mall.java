package tests;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName("mall")
public class Mall {

    private List<Shop> shops;
    private List<Customer> customers;


    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
