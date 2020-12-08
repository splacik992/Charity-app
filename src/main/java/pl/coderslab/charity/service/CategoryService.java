package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.mapper.category.CategoryDtoToCategoryMapper;
import pl.coderslab.charity.mapper.category.CategoryToCategoryDtoMapper;
import pl.coderslab.charity.repository.CategoryRepository;

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
}
