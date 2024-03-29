package by.it.academy.dodo.dto.response.worker;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for representing worker information in a response.
 */
@Data
@NoArgsConstructor
public class WorkerResponseDto {

   /**
    * First name of the worker.
    */
   private String firstname;

   /**
    * Phone number of the worker.
    */
   private String phoneNumber;
}

