package com.wams.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;


@Getter
@Setter
@ToString
public class Exam {
    String examId;
    String examName;
    Timestamp examTime;
}
