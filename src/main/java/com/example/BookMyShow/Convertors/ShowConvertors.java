package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.Entities.ShowEntity;
import com.example.BookMyShow.EntryDtos.ShowEntryDto;

public class ShowConvertors {

    public  static ShowEntity  convertEntryToEntity(ShowEntryDto showEntryDto){

        ShowEntity showEntity=ShowEntity.builder().showDate(showEntryDto.getLocalDate())
                .showTime(showEntryDto.getLocalTime()).showType(showEntryDto.getShowType())
                .build();

          return  showEntity;

    }
}
