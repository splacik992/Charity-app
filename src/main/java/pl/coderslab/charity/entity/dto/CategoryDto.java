package pl.coderslab.charity.entity.dto;

public class CategoryDto {

    private String name;

    public CategoryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
