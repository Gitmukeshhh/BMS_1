package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.Entities.TicketEntity;
import com.example.BookMyShow.EntryDtos.TicketEntryDto;

public class TicketConverter {


 public  static TicketEntity convertEntryToEntity(TicketEntryDto ticketEntryDto){

       TicketEntity ticketEntity=new TicketEntity();
       return  ticketEntity;

 }

}
