package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.dto.CategoryDto;
import pl.coderslab.charity.mapper.category.CategoryDtoToCategoryMapper;
import pl.coderslab.charity.mapper.category.CategoryToCategoryDtoMapper;
import pl.coderslab.charity.repository.CategoryRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryDtoToCategoryMapper categoryDtoToCategoryMapper;
    private final CategoryToCategoryDtoMapper categoryToCategoryDtoMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryDtoToCategoryMapper categoryDtoToCategoryMapper,
                           CategoryToCategoryDtoMapper categoryToCategoryDtoMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryDtoToCategoryMapper = categoryDtoToCategoryMapper;
        this.categoryToCategoryDtoMapper = categoryToCategoryDtoMapper;
    }


    @Transactional
    public List<CategoryDto> getCategoryListFromDB(){
        List<Category> categories = categoryRepository.findAll();
        return categoryToCategoryDtoMapper.categoryListToDto(categories);
    }

    public Category getCategoryByName(String category){
        return categoryRepository.findCategoryByName(category);
    }

    public void saveCategory(CategoryDto categoryDto){
        Category category = categoryDtoToCategoryMapper.categoryDtoToCategory(categoryDto);
        categoryRepository.save(category);
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findCategoryById(id);
    }

}
