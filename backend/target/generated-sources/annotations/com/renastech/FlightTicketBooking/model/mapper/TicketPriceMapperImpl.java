package com.renastech.FlightTicketBooking.model.mapper;

import com.renastech.FlightTicketBooking.model.dto.TicketPriceDto;
import com.renastech.FlightTicketBooking.model.dto.TicketPriceDto.TicketPriceDtoBuilder;
import com.renastech.FlightTicketBooking.model.entity.TicketPrice;
import com.renastech.FlightTicketBooking.model.entity.TicketPrice.TicketPriceBuilder;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateTicketPriceRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-10T21:31:15-0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class TicketPriceMapperImpl implements TicketPriceMapper {

    @Override
    public TicketPriceDto toTicketPriceDto(TicketPrice ticketPrice) {
        if ( ticketPrice == null ) {
            return null;
        }

        TicketPriceDtoBuilder ticketPriceDto = TicketPriceDto.builder();

        if ( ticketPrice.getId() != null ) {
            ticketPriceDto.id( ticketPrice.getId() );
        }
        if ( ticketPrice.getAmount() != null ) {
            ticketPriceDto.amount( ticketPrice.getAmount() );
        }

        return ticketPriceDto.build();
    }

    @Override
    public List<TicketPriceDto> toTicketPriceDtoList(List<TicketPrice> ticketPriceList) {
        if ( ticketPriceList == null ) {
            return null;
        }

        List<TicketPriceDto> list = new ArrayList<TicketPriceDto>( ticketPriceList.size() );
        for ( TicketPrice ticketPrice : ticketPriceList ) {
            list.add( toTicketPriceDto( ticketPrice ) );
        }

        return list;
    }

    @Override
    public TicketPrice createTicketPrice(CreateUpdateTicketPriceRequest request) {
        if ( request == null ) {
            return null;
        }

        TicketPriceBuilder<?, ?> ticketPrice = TicketPrice.builder();

        ticketPrice.amount( request.getAmount() );

        return ticketPrice.build();
    }

    @Override
    public void updateTicketPrice(TicketPrice ticketPrice, CreateUpdateTicketPriceRequest request) {
        if ( request == null ) {
            return;
        }

        ticketPrice.setAmount( request.getAmount() );
    }
}
