package foobarqix;

public class FooBarQix {


    public String returnAppropriateString(int number){
        StringBuilder returnedString = new StringBuilder();

        checkIsNumberDivisible(returnedString, number);
        checkIsNumberContains0357(returnedString, number);

        // when returnedString is empty or equals asterisk then should return only provided number
        if(returnedString.length() <= 1){
            return String.valueOf(number).replace('0','*');
        }

        return returnedString.toString();
    }

    private void checkIsNumberDivisible(StringBuilder returnedString, int number){

        if(number % 3 == 0){
            returnedString.append("Foo");
        }
        if(number % 5 == 0){
            returnedString.append("Bar");
        }
        if(number % 7 == 0){
            returnedString.append("Qix");
        }

    }

    private void checkIsNumberContains0357(StringBuilder returnedString, int number){
        char[] numbers = String.valueOf(number).toCharArray();

        for (char checkingNumber : numbers ) {

            if(checkingNumber == '3'){
                returnedString.append("Foo");
            }else if(checkingNumber == '5'){
                returnedString.append("Bar");
            }else if(checkingNumber == '7'){
                returnedString.append("Qix");
            }else if(checkingNumber == '0'){
                returnedString.append("*");
            }
        }
    }

}
