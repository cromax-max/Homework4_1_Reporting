package ru.netology.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardDeliveryFormData {

    private String city;
    private String name;
    private String phone;
}
