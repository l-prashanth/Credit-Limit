package com.prashanth.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class Errors {

    protected Error errors;
}
