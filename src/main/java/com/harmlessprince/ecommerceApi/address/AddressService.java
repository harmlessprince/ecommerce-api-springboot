package com.harmlessprince.ecommerceApi.address;


import com.harmlessprince.ecommerceApi.exceptions.CustomResourceNotFoundException;
import com.harmlessprince.ecommerceApi.exceptions.UserNotfoundException;
import com.harmlessprince.ecommerceApi.lga.LocalGovernment;
import com.harmlessprince.ecommerceApi.lga.LocalGovernmentService;
import com.harmlessprince.ecommerceApi.state.State;
import com.harmlessprince.ecommerceApi.state.StateService;
import com.harmlessprince.ecommerceApi.user.User;
import com.harmlessprince.ecommerceApi.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AddressService {
    private final AddressRepository addressRepository;
    private final UserService userService;
    private final StateService stateService;
    private final LocalGovernmentService localGovernmentService;

    private final AddressMapper addressMapper;

    public List<Address> getUserAddresses(Integer userId) {
        return addressRepository.findByUserId(userId);
    }

    public Address createAddress(AddressRequest request, User user) {
        Optional<State> state = stateService.getStateById(request.stateId());
        if (state.isEmpty()) throw new CustomResourceNotFoundException("State not found");
        Optional<LocalGovernment> localGovernment = localGovernmentService.getLocalGovernmentById(request.localGovernmentId());
        if (localGovernment.isEmpty()) throw new CustomResourceNotFoundException("Local Government not found");
        log.info("localGovernment ID {}", localGovernment.orElse(null).getId());
        if (!localGovernment.get().getState().getId().equals(state.get().getId())) throw new IllegalArgumentException("The local government is not in the state of this address");
        Address address = addressMapper.toAddress(request);
        address.setUser(user);
        address.setState(state.get());
        address.setLocalGovernment(localGovernment.get());
        address.setIsDefault(request.isDefault() == null ? false : request.isDefault());
//        return address;
        return addressRepository.save(address);
    }
}
