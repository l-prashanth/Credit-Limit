package com.prashanth.model.customer;


import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "CustomerDetails")
@ToString
public class Customer {
    @Id
    private int id;
    private String name;
    private String age;
    private int cibil;
}
