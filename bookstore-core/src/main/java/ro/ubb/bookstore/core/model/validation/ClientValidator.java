package ro.ubb.bookstore.core.model.validation;


import ro.ubb.bookstore.core.model.Client;
import ro.ubb.bookstore.core.model.exceptions.ValidatorException;

public class ClientValidator implements Validator<Client> {
    @Override
    public void validate(Client object) throws ValidatorException {
        if (object.getFirstName().equals(""))
            throw new ValidatorException("Invalid First Name");
        if (object.getLastName().equals(""))
            throw new ValidatorException("Invalid Last Name");
    }
}
