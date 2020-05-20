package ro.ubb.bookstore.core.model.validation;


import ro.ubb.bookstore.core.model.Book;
import ro.ubb.bookstore.core.model.exceptions.ValidatorException;

public class BookValidator implements Validator<Book> {
    @Override
    public void validate(Book object) throws ValidatorException {
        if (object.getPrice() <= 0.0)
            throw new ValidatorException("Invalid Book Price");
    }
}
