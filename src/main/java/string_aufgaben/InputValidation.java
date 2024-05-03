package string_aufgaben;

public class InputValidation {

    public static void main(String[] args) {
        System.out.println(inputValidation("12(CHEN):"));
        System.out.println(inputValidation("12(cHEN):"));
        System.out.println(inputValidation("1c(cHEN):"));
        System.out.println(inputValidation("1c(cHEN)d"));
        System.out.println(inputValidation("1c)(cHEN)d"));
        System.out.println(inputValidation("12(CHEN))(:"));
    }

    public static String inputValidation(String input){
        final String ERROR = "Input Error";
        if(!lengthOfInputStringCorrect(input)) return ERROR;
        if(!firstTwoCharactersAreNumbers(input)) return ERROR;
        if(!allCharsAreUpperCase(input)) return ERROR;
        if(!input.contains("CHEN")) return ERROR;
        if(!input.endsWith(":")) return ERROR;
        if(!containsBothBracketsAndInOrder(input)) return ERROR;
        return "OK";
    }

    public static boolean lengthOfInputStringCorrect(String input){
        if(input.length()<=5){
           return false;
        }
        if(input.length()>12){
            return false;
        }
        return true;
    }

    public static boolean allCharsAreUpperCase(String word){
        String smallLetters = "abcdefghiklmnopqrstuvwxyz";
        for(char ch : word.toCharArray()){
            if(smallLetters.contains(String.valueOf(ch))){
                return false;
            }
        }
        return true;
    }

    public static boolean containsBothBracketsAndInOrder(String input){
        if(!input.contains("(")) return false;
        if(!input.contains(")")) return false;
        int leftBracketCount  = 0;
        int rightBracketCount = 0;
        for(char ch : input.toCharArray()){
            if(ch == '('){
                leftBracketCount++;
            }
            if(ch == ')'){
                rightBracketCount++;
            }
            if(leftBracketCount<rightBracketCount){
                return false;
            }
        }
        return true;
    }
    public static boolean firstTwoCharactersAreNumbers(String input){
        String numbers = "1234567890";
        if(!(numbers.contains(String.valueOf(input.charAt(0))))) return false;
        return (numbers.contains(String.valueOf(input.charAt(1))));
    }
}
