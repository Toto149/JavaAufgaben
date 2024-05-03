package string_aufgaben;

public class InputValidation {

    public static void main(String[] args) {
        System.out.println("12(CHEN):   : "   + inputValidation("12(CHEN):"));
        System.out.println("12(cHEN):   : "   + inputValidation("12(cHEN):"));
        System.out.println("1c(cHEN):   : "   + inputValidation("1c(cHEN):"));
        System.out.println("1c(cHEN)d   : "   + inputValidation("1c(cHEN)d"));
        System.out.println("1c)(cHEN)d  : "  + inputValidation("1c)(cHEN)d"));
        System.out.println("12(CHEN))(: : " + inputValidation("12(CHEN))(:"));
        System.out.println("c2(CHEN))(: : " + inputValidation("c2(CHEN))(:"));
        System.out.println("cd(CHEN))(: : " + inputValidation("cd(CHEN))(:"));
    }

    public static String inputValidation(String input){
        final String ERROR = "Input Error";
        if(!hasCorrectLength(input)) return ERROR; //Länge des Inputs
        if(!firstTwoCharactersAreNumbers(input)) return ERROR; //Erste beiden Character Zahlen?
        if(!allCharsAreUpperCase(input)) return ERROR; //Alle Buchstaben UpperCase?
        if(!input.contains("CHEN")) return ERROR; //Enthält "CHEN"?
        if(!input.endsWith(":")) return ERROR; // Endet mit ':'?
        if(!containsBothBracketsAndInOrder(input)) return ERROR; //Gibt es Klammern und sind diese in Reihenfolge?
        return "OK";
    }

    public static boolean hasCorrectLength(String input){
        //Überprüft die länge des input Strings
        if(input.length()<=5){
           return false;
        }
        if(input.length()>10){
            return false;
        }
        return true;
    }

    public static boolean allCharsAreUpperCase(String word){
        //Die einzigen chars die ein UpperCase haben sind Buchstaben (glaube ich), daher überprüfe ich, ob ein kleiner
        //Buchstabe in dem input enthalten ist und wenn das der Fall ist, wird false returned.

        String smallLetters = "abcdefghiklmnopqrstuvwxyz";
        for(char ch : word.toCharArray()){
            if(smallLetters.contains(String.valueOf(ch))){
                return false;
            }
        }
        return true;
    }

    public static boolean containsBothBracketsAndInOrder(String input){
        if(!input.contains("(")) return false; //Überprüft, ob es überhaupt eine linke Klammer gibt.
        if(!input.contains(")")) return false; //Überprüft, ob es überhaupt eine rechte Klammer gibt.

        //Die Idee ist das zu keiner Zeit mehr right brackets ')' gibt als left brackets '(', daher wird später überprüft,
        //ob die Zahl leftBracketCount kleiner ist als rightBracketCount

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
        return leftBracketCount==rightBracketCount; //Überprüft, ob zu jeder linken Klammer eine rechte Klammer gibt
    }
    public static boolean firstTwoCharactersAreNumbers(String input){
        //Die Idee ist das per contains überprüft wird, ob die ersten characters des input strings zahlen sind.
        //Daher wird hier analog wie bei dem UpperCase Fall überprüft, diesmal aber mit Zahlen.
        String numbers = "1234567890";
        if(!(numbers.contains(String.valueOf(input.charAt(0))))) return false;
        return (numbers.contains(String.valueOf(input.charAt(1)))); //Dieser Bool wird nur returned wenn der erste char schon eine Zahl ist.
    }
}
