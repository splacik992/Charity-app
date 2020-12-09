package pl.coderslab.charity.mapper.category;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.dto.CategoryDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryToCategoryDtoMapper {

    public static CategoryDto categoryToCategoryDto(Category category) {
        return new CategoryDto(category.getId(),category.getName());
    }

    public List<CategoryDto> categoryListToDto(List<Category> categories) {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categories) {
            CategoryDto categoryDto = categoryToCategoryDto(category);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

}
