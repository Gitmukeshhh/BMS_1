package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.Entities.UserEntity;
import com.example.BookMyShow.EntryDtos.UserEntryDto;

public class UserConvertor {

    // static is kept to avoid calling it via obj
    // Again use
    public  static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){



        UserEntity userEntity=  UserEntity.builder().age(userEntryDto.getAge()).address(userEntryDto.getAddress()).email(userEntryDto.getEmail())
                .name(userEntryDto.getName()).mobNo(userEntryDto.getMobNo()).build();

        return userEntity;
    }
}
