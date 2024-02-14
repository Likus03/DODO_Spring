package by.it.academy.DODO.exceptions;

import lombok.NoArgsConstructor;

/**
 * Custom exception thrown when client data is invalid.
 */
@NoArgsConstructor
public class ClientInvalidDataException extends RuntimeException  {

    /**
     * Constructs a new ClientInvalidDataException with the specified detail message.
     *
     * @param message the detail message.
     */
    public ClientInvalidDataException(String message){
        super(message);
    }

}
