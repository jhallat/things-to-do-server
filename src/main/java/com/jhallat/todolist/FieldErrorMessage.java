package com.jhallat.todolist;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldErrorMessage {

    private String field;
    private String message;

}
