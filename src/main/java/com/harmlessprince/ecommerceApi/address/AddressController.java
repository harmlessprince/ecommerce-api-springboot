package com.harmlessprince.ecommerceApi.address;

import com.harmlessprince.ecommerceApi.exceptions.CustomResourceNotFoundException;
import com.harmlessprince.ecommerceApi.exceptions.UserNotfoundException;
import com.harmlessprince.ecommerceApi.handler.CustomErrorResponse;
import com.harmlessprince.ecommerceApi.handler.CustomSuccessResponse;
import com.harmlessprince.ecommerceApi.user.User;
import com.harmlessprince.ecommerceApi.user.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/addresses")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;
    private final UserService userService;
    private final AddressMapper addressMapper;

    @GetMapping
    @Transactional
    public ResponseEntity<CustomSuccessResponse<List<AddressResponse>>> getUserAddresses() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        List<Address> addresses = addressService.getUserAddresses(currentUser.getId());
        List<AddressResponse> addressResponses = new ArrayList<>();
        for(Address address : addresses) {
            addressResponses.add(addressMapper.fromAddress(address));
        }
        return ResponseEntity.ok(new CustomSuccessResponse<>(addressResponses));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CustomSuccessResponse<AddressResponse>>store(@RequestBody @Valid AddressRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        Address address = addressService.createAddress(request, currentUser);
        return ResponseEntity.ok(new CustomSuccessResponse<>(addressMapper.fromAddress(address)));
    }

    @PatchMapping("/{addressId}/default")
    public ResponseEntity<CustomSuccessResponse<Object>> makeAddressDefault(@PathVariable Integer addressId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        Address address = addressService.findById(addressId);
        if(!Objects.equals(address.getUser().getId(), currentUser.getId())) {
            throw new CustomResourceNotFoundException("Address not found");
        }
        if (address.getIsDefault()){
            return ResponseEntity.ok(new CustomSuccessResponse<>(null, "Address is already default"));
        }
        addressService.setAddressAsDefault(address);
        return ResponseEntity.ok(new CustomSuccessResponse<>(null, "Address set has default successfully"));
    }
}
