package by.it.academy.DODO.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClientInvalidDataException extends RuntimeException  {
    public ClientInvalidDataException(String message){
        super(message);
    }

}
