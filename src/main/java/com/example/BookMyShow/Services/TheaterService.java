package com.example.BookMyShow.Services;

import com.example.BookMyShow.Convertors.TheaterConvertor;
import com.example.BookMyShow.Entities.TheaterEntity;
import com.example.BookMyShow.Entities.TheaterSeatEntity;
import com.example.BookMyShow.EntryDtos.TheaterEntryDto;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.Repository.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {


    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    @Autowired
    TheaterRepository theaterRepository;

    public  String addTheater(TheaterEntryDto theaterEntryDto) throws  Exception{
        /*
        1->created theater
        2-> i need to save theater :I need theaterEntity
        3->Always set the attribute before saving.
         */

           if(theaterEntryDto.getName()==null || theaterEntryDto.getLocation()==null){
               throw  new Exception("name and location should valid");
           }


        TheaterEntity theaterEntity= TheaterConvertor.convertDtoToEntity(theaterEntryDto);

        List<TheaterSeatEntity> theaterSeatEntityList=createTheaterSeats(theaterEntryDto,theaterEntity);


        theaterEntity.setTheaterSeatEntityList(theaterSeatEntityList);

        theaterRepository.save(theaterEntity);

        return "Theater added successfully";
    }

      private  List<TheaterSeatEntity> createTheaterSeats(TheaterEntryDto theaterEntryDto,TheaterEntity theaterEntity){

        int noClassicSeat=theaterEntryDto.getClassicSeatCount();
        int noPremiumSeat= theaterEntryDto.getPremiumSeatCount();

        List<TheaterSeatEntity> theaterSeatEntitiesList=new ArrayList<>();


        //  CLASSIC

        for(int count=1;count<=noClassicSeat;count++){

            // we need to make a new TheaterSeatEntity

            TheaterSeatEntity theaterSeatEntity= TheaterSeatEntity.builder().seatType(SeatType.CLASSIC)
                     .seatNo(count+"C").theaterEntity(theaterEntity).build();

            theaterSeatEntitiesList.add(theaterSeatEntity);

        }

        // PREMIUM

          for(int count=1;count<=noPremiumSeat;count++){

              TheaterSeatEntity theaterSeatEntity=TheaterSeatEntity.builder().seatType(SeatType.PREMIUM)
                      .seatNo(count+"P").theaterEntity(theaterEntity).build();

                 theaterSeatEntitiesList.add(theaterSeatEntity);
          }

                 return  theaterSeatEntitiesList;

      }
}
