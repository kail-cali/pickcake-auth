package co.pickcake.auth.common;


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable @Getter
@NoArgsConstructor
public class Address {

    private String city;
    private String street;
    private String zipcode;



}
