package com.prashanth.model.credit;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Credit")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreditResponse {

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
    @NotNull
    private long creditLimit;
}
