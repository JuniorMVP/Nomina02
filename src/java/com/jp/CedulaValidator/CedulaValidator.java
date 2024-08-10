package com.jp.CedulaValidator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.jp.CedulaValidator")
public class CedulaValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String cedula = (String) value;

        if (!validarCedula(cedula)) {
            FacesMessage msg = new FacesMessage("Cédula inválida", "La cédula ingresada no es válida.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

    public static boolean validarCedula(String cedula) {
        int totalSum = 0;
        String cleanCedula = cedula.replace("-", "").trim(); 

        if (cleanCedula.length() != 11) {
            return false; // Longitud inválida
        }

        int[] weight = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1}; 

        for (int i = 0; i < 11; i++) {
            int digit = Character.getNumericValue(cleanCedula.charAt(i)); 
            int calculation = digit * weight[i];

            if (calculation < 10) {
                totalSum += calculation;
            } else {
                totalSum += Character.getNumericValue(String.valueOf(calculation).charAt(0)) + 
                             Character.getNumericValue(String.valueOf(calculation).charAt(1));
            }
        }

        return totalSum % 10 == 0; // Cédula válida si el resto es cero
    }
}