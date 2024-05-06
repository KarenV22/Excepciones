/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

class PasswordLengthException extends Exception {
    public PasswordLengthException() {
        super("La contraseña debe tener al menos 8 caracteres.");
    }
}

class PasswordSpaceException extends Exception {
    public PasswordSpaceException() {
        super("La contraseña no puede contener espacios en blanco.");
    }
}

class PasswordRequirementsException extends Exception {
    public PasswordRequirementsException() {
        super("La contraseña debe contener al menos un carácter en mayúscula, un número y un carácter especial.");
    }
}

class PasswordMismatchException extends Exception {
    public PasswordMismatchException() {
        super("Las contraseñas ingresadas no coinciden.");
    }
}

class PasswordValidator {
    public void validate(String password1, String password2) throws PasswordLengthException, PasswordSpaceException, PasswordRequirementsException, PasswordMismatchException {
        if (password1.length() < 8) {
            throw new PasswordLengthException();
        }

        if (password1.contains(" ")) {
            throw new PasswordSpaceException();
        }

        if (!password1.matches(".*[A-Z].*") || !password1.matches(".*\\d.*") || !password1.matches(".*[!@#$%^&*()-_+=\\[\\]].*")) {
            throw new PasswordRequirementsException();
        }

        if (!password1.equals(password2)) {
            throw new PasswordMismatchException();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();

        while (true) {
            try {
                java.util.Scanner scanner = new java.util.Scanner(System.in);
                System.out.print("Ingrese la contraseña: ");
                String password1 = scanner.nextLine();
                System.out.print("Ingrese la contraseña nuevamente para confirmar: ");
                String password2 = scanner.nextLine();

                validator.validate(password1, password2);
                System.out.println("La contraseña es válida.");
                break;
            } catch (PasswordLengthException | PasswordSpaceException | PasswordRequirementsException | PasswordMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
