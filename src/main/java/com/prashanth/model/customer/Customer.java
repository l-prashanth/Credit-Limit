package com.prashanth.model.customer;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Generated;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "CustomerDetails")
@ToString
public class Customer {
    @Id
    @Generated
    @NotNull
    private int customerId;
    @NotNull
    private String name;
    @NotNull
    private int age;
    @NotNull
    private int creditScore;
    @NotNull
    private long salary;
    @NotNull
    private boolean existingCustomer;
}
