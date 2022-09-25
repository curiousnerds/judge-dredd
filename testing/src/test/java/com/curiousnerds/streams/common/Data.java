package com.curiousnerds.streams.common;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.net.*;

public class Data {
    public List<Customer> getCustomers()  {
            Mall onlineShoppingMall = getMall();
        return onlineShoppingMall.getCustomers();
    }

    private Mall getMall(){
        URL resource = Data.class.getResource("../../../../../../resources/test/data.json");
        File f = new File(resource.getFile());

        ObjectMapper objectMapper = new ObjectMapper();
        Mall onlineShoppingMall = null;
        try {
            onlineShoppingMall = objectMapper.readValue(f, Mall.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return onlineShoppingMall;
    }

    public List<Shop> getShops() {
        return getMall().getShops();
    }

}
