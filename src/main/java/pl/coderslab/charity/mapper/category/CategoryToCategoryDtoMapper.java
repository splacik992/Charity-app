package pl.coderslab.charity.mapper.category;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.dto.CategoryDto;

@Component
public class CategoryToCategoryDtoMapper {

    public CategoryDto categoryToCategoryDto(Category category) {
        return new CategoryDto(category.getName());
    }
}
