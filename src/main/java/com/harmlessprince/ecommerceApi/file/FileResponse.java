package com.harmlessprince.ecommerceApi.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FileResponse {
    private Integer id;
    private String name;
    private String url;
    private String type;
}
