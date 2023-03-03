package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.Entities.TheaterEntity;
import com.example.BookMyShow.EntryDtos.TheaterEntryDto;

public class TheaterConvertor {


    public  static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto){

        return TheaterEntity.builder().location(theaterEntryDto.getLocation()).name(theaterEntryDto.getName()).build();

    }
}
