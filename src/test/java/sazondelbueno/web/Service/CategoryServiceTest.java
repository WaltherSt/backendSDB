package sazondelbueno.web.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import sazondelbueno.web.Model.Category;
import sazondelbueno.web.Repository.CategoryRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

// listar todas las categorias
@Test
void allCategories_ReturnsCategories() {

    CategoryRepository categoryRepositoryMock = mock(CategoryRepository.class);
    List<Category> categoriasEsperadas = Arrays.asList(
            new Category(1, "Postres", new Date()),
            new Category(2, "Ensaladas", new Date()),
            new Category(3, "carnes", new Date())
    );
    when(categoryRepositoryMock.findAll()).thenReturn(categoriasEsperadas);

    CategoryService categoryService = new CategoryService(categoryRepositoryMock);

    List<Category> categoriasActuales = categoryService.allCategories();

    assertEquals(categoriasEsperadas.size(), categoriasActuales.size());

}
    // guarda la categoria

    @Test
    void saveCategory_ReturnCategory(){
        Category categoriaEsperada = new Category(5, "Carnes", new Date());

        when(categoryRepository.save(any(Category.class))).thenReturn(categoriaEsperada);
        Category categoriaActual = categoryService.saveCategory(categoriaEsperada);
        assertEquals(categoriaEsperada, categoriaActual);
    }

}
