package ru.netology;

import java.util.Objects;

public class CardDeliveryFormData {

    private String city;
    private String date;
    private String name;
    private String phone;

    public CardDeliveryFormData(String city, String date, String name, String phone) {
        this.city = city;
        this.date = date;
        this.name = name;
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ru.netology.CardDeliveryFormData{" +
                "city='" + city + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardDeliveryFormData that = (CardDeliveryFormData) o;
        return city.equals(that.city) && date.equals(that.date) && name.equals(that.name) && phone.equals(that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, date, name, phone);
    }
}
