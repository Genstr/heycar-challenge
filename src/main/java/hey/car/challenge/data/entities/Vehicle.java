package hey.car.challenge.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(Vehicle.CompositeId.class)
public class Vehicle {

    @Id
    private String dealer;

    @Id
    private String code;

    private String make;
    private String model;

    @JsonProperty("kW")
    private Integer power;
    private Integer year;
    private String color;
    private Double price;

    public static class CompositeId implements Serializable {

        protected String dealer;
        protected String code;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CompositeId that = (CompositeId) o;

            if (!dealer.equals(that.dealer)) return false;
            return code.equals(that.code);
        }

        @Override
        public int hashCode() {
            int result = dealer.hashCode();
            result = 31 * result + code.hashCode();
            return result;
        }
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "dealer='" + dealer + '\'' +
                ", code='" + code + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", kW=" + power +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
