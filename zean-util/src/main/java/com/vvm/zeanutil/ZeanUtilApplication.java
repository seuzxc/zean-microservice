package com.vvm.zeanutil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class ZeanUtilApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZeanUtilApplication.class, args);
        try {
            //URL url  = new URL("http://localhost:12001/api/third/config");
            URL url  = new URL("http://www.google.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            System.err.println(bis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

