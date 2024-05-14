package unit_10;

public class Unit10_2 {

    public static void main(String [] args) {
        
        System.out.println(endWithZ("abzcdef"));
        // System.out.println(markChar("abcdef", 'a'));
    }

        public static String strReverse(String str) {

            if (str.length() == 0) {
                return "";
            }

            // save first char
            char tmp = str.charAt(0);
            // get reverse of rest
            String res = strReverse(str.substring(1));
            // return full reveres
            return res + tmp;
        }

        public static String markChar(String str, char ch){
        
            if (str.length() == 0) {
                return str;
            }

            // save first char
            char first = str.charAt(0);
            // padd with # if equals
            String pre = first == ch ? "#" + first + "#" : first + "";
            String rest = markChar(str.substring(1), ch);
            return pre + rest;
        }

        public static String endWithZ(String str) {
            if (str.length() == 0) {
                return str;
            }

            // save first
            char first = str.charAt(0);
            // call to rest
            String res = endWithZ(str.substring(1));

            if (first == 'z' || first == 'Z' ) 
                return  res + first;

            return first + res ;

        }
}


