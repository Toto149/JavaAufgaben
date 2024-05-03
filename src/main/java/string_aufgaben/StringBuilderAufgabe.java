package string_aufgaben;

public class StringBuilderAufgabe {
    public static void main(String[] args) {
        String[] strings = {"Hallo", "Welt","LOL","asdasd"};
        System.out.println(table(strings));
    }

    public static String table(String[] inhalte){
        StringBuilder str = new StringBuilder();
        str.append("<table>\n");
        for(int i = 0; i<inhalte.length; i++){
            str.append(trTag(inhalte[i],i+1));
        }
        str.append("</table>");
        return str.toString();
    }


    public static String trTag(String inhalt,int rownumber){
        StringBuilder str = new StringBuilder();
        str.append("\t<tr>\n")
                .append("\t\t" + tdTag(inhalt,rownumber)+ "\n")
                .append("\t</tr>\n");

        return str.toString();
    }
    public static String tdTag(String inhalt,int rownumber){
        StringBuilder str = new StringBuilder();
        str.append("<td>Row " + rownumber +"</td>\n")
                .append("\t\t<td>"+ inhalt +"</td>");
        return str.toString();
    }
}
