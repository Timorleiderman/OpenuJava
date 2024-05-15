package unit_10;

public class Unit10_2 {

    public static void main(String [] args) {
        
        System.out.println(getNumber("abzcdeaa1234af"));
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

        public static String startWithA(String str) {
            if (str.length() == 0) 
                return str;

            char last = str.charAt(str.length() - 1);
            String rest = startWithA( str.substring(0, str.length() - 1) );

            if (last == 'a' || last == 'A')
                return last + rest;

            return rest + last;

        }

        public static String getNumber(String str) {
            if (str.length() == 0){
                return str;
            }

            char first = str.charAt(0);
            char last = str.charAt(str.length() - 1);

            boolean isFirstDig = (first >= '0' && first <= '9');
            boolean isLastDig = (last >= '0' && last <= '9');
            if (isFirstDig && isLastDig)
                return str;

            if (isLastDig)
                return getNumber(str.substring(1));

            return getNumber(str.substring(0, str.length() - 1));
        }
}


