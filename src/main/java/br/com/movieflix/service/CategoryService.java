package br.com.movieflix.service;
import br.com.movieflix.entity.Category;
import br.com.movieflix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category saveCategory(Category category) {
        return repository.save(category);
    }

    public java.util.Optional<Category> findById(Long id) {
        return repository.findById(id);
    }


    public void deleteByCategoryId(Long id) {
        repository.deleteById(id);
    }


    public List<Category> findAllById(List<Long> ids) {
        return repository.findAllById(ids);
    }
}
