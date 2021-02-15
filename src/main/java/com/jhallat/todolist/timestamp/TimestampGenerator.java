package com.jhallat.todolist.timestamp;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimestampGenerator {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.A");

    public String generateFromNow() {
        LocalDateTime time = LocalDateTime.now();
        return formatter.format(time);
    }

}
