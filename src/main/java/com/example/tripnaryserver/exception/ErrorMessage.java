package com.example.tripnaryserver.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorMessage {
    private String message;
    private Boolean value;

    public void setMessageError(int tipo) {
        boolean tempValue = false;
        switch (tipo) {
            case 1:
                this.message = "La entidad no existe";
                tempValue = false;
                break;
            case 2:
                this.message = "La entidad ya existe";
                tempValue = true;
                break;

            case 3:
                this.message = "La entidad ya se eliminó";
                tempValue = true;
                break;

            default:
                this.message = "Ocurrió un error";
        }
        this.value = tempValue;
    }
}
