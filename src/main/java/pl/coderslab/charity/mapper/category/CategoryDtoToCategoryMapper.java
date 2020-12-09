package pl.coderslab.charity.mapper.category;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.dto.CategoryDto;

@Component
public class CategoryDtoToCategoryMapper {

    public Category categoryDtoToCategory(CategoryDto categoryDto) {
        String name = categoryDto.getName();
        Long id = categoryDto.getId();
        return new Category(id,name);
    }


}
