package ro.ubb.bookstore.core.model.validation;


import ro.ubb.bookstore.core.model.exceptions.ValidatorException;

public interface Validator<T> {
    void validate(T object) throws ValidatorException;
}
