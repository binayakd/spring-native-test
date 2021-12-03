package com.digitlabeans.springnativetest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Data {
    Integer id;
    Integer delay;
    String currentTime;
}
