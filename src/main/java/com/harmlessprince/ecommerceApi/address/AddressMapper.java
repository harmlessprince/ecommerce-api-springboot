package com.harmlessprince.ecommerceApi.address;

import com.harmlessprince.ecommerceApi.auth.UserMapper;
import com.harmlessprince.ecommerceApi.state.State;
import com.harmlessprince.ecommerceApi.state.StateResponse;
import com.harmlessprince.ecommerceApi.user.User;
import com.harmlessprince.ecommerceApi.user.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressMapper {
    private final UserMapper userMapper;
    public  Address fromRequest(AddressRequest request) {
        return Address.
                builder()
                .street(request.street())
                .streetNumber(request.streetNumber())
                .postalCode(request.postalCode())
                .city(request.city())
                .build();
    }

    public  Address toAddress(AddressRequest request) {
        return Address.
                builder()
//                .id(request.id())
                .street(request.street())
                .streetNumber(request.streetNumber())
                .postalCode(request.postalCode())
                .city(request.city())
                .build();
    }

    public  AddressResponse fromAddress(Address address) {
        State state = address.getState();
        return new AddressResponse(
                address.getId(),
                address.getStreet(),
                address.getStreetNumber(),
                address.getPostalCode(),
                address.getCity(),
                userMapper.fromUser(address.getUser()),
                address.getLocalGovernment(),
                new StateResponse(
                        state.getId(),
                        state.getName(),
                        state.getStatus(),
                        state.getCountry()
                ),
                address.getIsDefault()
        );
    }
}
