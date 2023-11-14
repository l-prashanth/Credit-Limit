package com.prashanth.model.credit;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Credit")
@ToString
public class CreditResponse {
    private long creditLimit;
}
