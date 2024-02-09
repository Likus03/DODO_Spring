package by.it.academy.DODO.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmptyObjectException extends RuntimeException  {
    public EmptyObjectException(String message){
        super(message);
    }

}
