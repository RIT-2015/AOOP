class OnceOrMany {

    /**
     * This function compares two strings with '==' operator
     * @param   literal     String variable to store a string
     * @param aNewString    String variable to store a string
     * @return              It returns a boolean after comparing both string
     *                      arguments
     */
    public static boolean singelton(String literal, String aNewString)	{
        return ( literal == aNewString );
    }
    public static void main( String args[] ) {

        //String variable aString holds string literal "xyz"
        String aString = "xyz";

        /* Following line will print false as first it concatenates
         * "1.	xyz == aString:	" to string "xyz" and then compares it with
         * string literal "xyz"
         */
        System.out.println("1.	xyz == aString:	" +     "xyz" == aString   );

        /* Following line will print "2.	xyz == aString:  true"
         * as it is comparing literal "xyz" with aString which also stores
         * literal "xyz"
         */
        System.out.println("2.	xyz == aString:	" +   ( "xyz" == aString ) );

        // Creating new object of String which holds value "xyz"
        String newString = new String("xyz");

        /* Following line will print
         * "xyz == new String(xyz) {add new line}
         * false"
         * "xyz" == newString is false as it tries to compare literal "xyz" with
         * String object.
         */
        System.out.println("xyz == new String(xyz)\n	" + ("xyz" == newString) );

        /* Following line will print "1: true"
         * as it is comparing "xyz" with other literal "xyz"
         */
        System.out.println("1: " + singelton("xyz", "xyz"));

        /* Following line will print "2: false"
         * as it is comparing string literal "xyz" with String object.
         */
        System.out.println("2: " + singelton("xyz", new String("xyz") ));

        /* Following line will print "3: true"
         * strings "xy" and "z" will be concatenated to give literal "xyz"
         * which gives true after comparing with other literal "xyz"
         */
        System.out.println("3: " + singelton("xyz", "xy" + "z"));

        /* Following line will print "4: true"
         * strings "x","y" and "z" will be concatenated to give literal "xyz"
         * which gives true after comparing with other literal "xyz"
         */
        System.out.println("4: " + singelton("x" + "y" + "z", "xyz"));

        /* Following line will print "5: false"
         * string literal "xy" will be concatenated with String object and will
         * give new object that holds "xyz". On comparing this with literal "xyz"
         * gives false
         */
        System.out.println("5: " + singelton("x" + "y" + new String("z"), "xyz"));

        /* Following line will print "6: true"
         * strings "y" and "z" will be concatenated to give literal "yz" which
         * will be concatenated with "x" to produce "xyz". It gives true after
         * comparing with other literal "xyz"
         */
        System.out.println("6: " + singelton("x" + ( "y" + "z"), "xyz"));

        /* Following line will print "7: true"
         * strings "y" and "z" will be concatenated to give literal "yz" which
         * will be concatenated with char 'x' to produce "xyz". It gives true after
         * comparing with other literal "xyz"
         */
        System.out.println("7: " + singelton('x' + ( "y" + "z"), "xyz"));
    }
}
