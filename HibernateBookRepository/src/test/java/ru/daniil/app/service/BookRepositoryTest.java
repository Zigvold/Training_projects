package ru.daniil.app.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.daniil.app.repositories.BooksRepository;
import ru.daniil.app.services.BooksService;

@ExtendWith(MockitoExtension.class)
class BookRepositoryTest {
    @InjectMocks
    private BooksRepository booksRepository;
    @Mock
    private BooksService booksService;
}
