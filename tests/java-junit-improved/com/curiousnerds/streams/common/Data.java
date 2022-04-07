package com.curiousnerds.streams.common;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Data {
    public List<Customer> getCustomers()  {
        ClassLoader classLoader= ClassLoader.getSystemClassLoader();
        String name = "data.json";
        URL resource = classLoader.getResource(name);
        File f = new File(resource.getFile());

        ObjectMapper objectMapper = new ObjectMapper();
        Mall onlineShoppingMall = null;
        try {
            onlineShoppingMall = objectMapper.readValue(f, Mall.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return onlineShoppingMall.getCustomers();
    }
}
