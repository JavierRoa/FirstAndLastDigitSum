// Aclaración: Cuando se usa un número de un solo dígito, este ejercicio solicita
// que el mismo dígito se considere como primer y último dígito, dando como resultado
// el número multiplicado por 2. Al final del ejercicio, se puede ver una función
// modificada para que esto no ocurra.

public class FirstAndLastDigitSum {
    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigitSimplified(252));
        System.out.println(sumFirstAndLastDigitSimplified(257));
        System.out.println(sumFirstAndLastDigitSimplified(0));
        System.out.println(sumFirstAndLastDigitSimplified(5));
        System.out.println(sumFirstAndLastDigitSimplified(-10));
    }
    // Solución (menos eficiente):
    private static int sumFirstAndLastDigit(int number) {
        if(number<0) {  // Valido que number sea positivo.
            return -1;
        }
        int lastDigit = number % 10;  // Creo la variable lastDigit, cuyo valor es el mod 10 de number.
        int firstDigit = 0;  // Creo la variable firstDigit, iniciada en 0.

        // Uso un bucle while, en el que en cada iteración:
        while (number>0) {
            firstDigit = number % 10;  // - Reasigno firstDigit con el valor del mod 10 de number.
            number/= 10;  // - Divido number / 10, para remover el último dígito. Así, firstDigit tiene el primer dígito de number.
        }
        return firstDigit + lastDigit;  // Retorno la suma de firstDigit y lastDigit.
    }
    // Solución (más eficiente):
    private static int sumFirstAndLastDigitSimplified(int number) {
        if(number<0) { // Valido que number sea positivo.
            return -1;
        }
        // Creo condición donde si el número tiene solo un dígito,
        // se multiplica por 2 (evitando operaciones innecesarias y mejorando la eficiencia).
        else if(number<10) {
            return number * 2;
        }
        int lastDigit = number % 10;  // Creo la variable lastDigit, cuyo valor es el mod 10 de number.
        while (number>=10) {  // Uso un bucle while, en el que mientras number sea mayor o igual a 10, el número será dividido por 10 (terminando como valor final, el primer dígito).
            number/= 10;
        }
        return number + lastDigit;  // Retorno la suma del valor final de number (el primer dígito), y lastDigit.
    }
    // Función modificada para que no duplique números de un solo dígito.
    // Solo hace un cambio con respecto a la versión simplificada.
    private static int sumFirstAndLastDigitModified(int number) {
        if(number<0) {
            return -1;
        }
        int lastDigit = number % 10;
        while (number>0) { // Cambia condición de number>=10 a number>0, dándole a number el valor final de 0.
            number/= 10;
        }
        return number + lastDigit;
    }
}
