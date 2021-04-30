package hey.car.challenge.service.csv;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import hey.car.challenge.data.entities.Vehicle;

import java.util.List;

public class VehicleCSVEntry {

    @CsvBindByName(column = "code")
    private String code;

    @CsvBindAndSplitByName(column = "make/model", elementType = String.class, splitOn="/")
    private List<String> makeAndModel;

    @CsvBindByName(column = "power-in-ps")
    private Integer power;

    @CsvBindByName(column = "year")
    private Integer year;

    @CsvBindByName(column = "color")
    private String color;

    @CsvBindByName(column = "price")
    private Double price;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getMakeAndModel() {
        return makeAndModel;
    }

    public void setMakeAndModel(List<String> makeAndModel) {
        this.makeAndModel = makeAndModel;
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

    public Vehicle toVehicle() {
        var result = new Vehicle();

        result.setCode(code);
        result.setMake(makeAndModel.get(0));
        result.setModel(makeAndModel.get(1));
        result.setPower(power);
        result.setYear(year);
        result.setColor(color);
        result.setPrice(price);

        return result;
    }
}
