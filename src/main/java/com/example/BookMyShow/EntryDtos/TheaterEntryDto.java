package com.example.BookMyShow.EntryDtos;

import lombok.Data;



@Data
public class TheaterEntryDto {


    private String   name;
    private String   location;
    private int classicSeatCount;
    private  int premiumSeatCount;
}
