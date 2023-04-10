package com.renastech.FlightTicketBooking.model.mapper;

import com.renastech.FlightTicketBooking.model.dto.AddressDto;
import com.renastech.FlightTicketBooking.model.dto.AddressDto.AddressDtoBuilder;
import com.renastech.FlightTicketBooking.model.entity.Address;
import com.renastech.FlightTicketBooking.model.entity.Address.AddressBuilder;
import com.renastech.FlightTicketBooking.model.request.CreateUpdateAddressRequest;
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
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDto toAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDtoBuilder addressDto = AddressDto.builder();

        if ( address.getId() != null ) {
            addressDto.id( address.getId() );
        }
        if ( address.getCityId() != null ) {
            addressDto.cityId( address.getCityId() );
        }
        addressDto.address( address.getAddress() );
        addressDto.addressRegion( address.getAddressRegion() );
        addressDto.addressPostalcode( address.getAddressPostalcode() );

        return addressDto.build();
    }

    @Override
    public List<AddressDto> toAddressDtoList(List<Address> addressList) {
        if ( addressList == null ) {
            return null;
        }

        List<AddressDto> list = new ArrayList<AddressDto>( addressList.size() );
        for ( Address address : addressList ) {
            list.add( toAddressDto( address ) );
        }

        return list;
    }

    @Override
    public Address createAddress(CreateUpdateAddressRequest request) {
        if ( request == null ) {
            return null;
        }

        AddressBuilder<?, ?> address = Address.builder();

        address.cityId( request.getCityId() );
        address.address( request.getAddress() );
        address.addressRegion( request.getAddressRegion() );
        address.addressPostalcode( request.getAddressPostalcode() );

        return address.build();
    }

    @Override
    public void updateAddress(Address address, CreateUpdateAddressRequest request) {
        if ( request == null ) {
            return;
        }

        address.setCityId( request.getCityId() );
        address.setAddress( request.getAddress() );
        address.setAddressRegion( request.getAddressRegion() );
        address.setAddressPostalcode( request.getAddressPostalcode() );
    }
}
