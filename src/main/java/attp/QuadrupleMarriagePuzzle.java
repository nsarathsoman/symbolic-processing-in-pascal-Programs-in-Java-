package attp;

/**
 * Created by sarath on 5/12/16.
 */
public class QuadrupleMarriagePuzzle {

    /**
     * At a quadruple marriage ceremony four men Arthur, Bill, Charlie and Don were marrying
     * Erica, Fanny, Georgina and Helen, though not necessarily in that order.
     *
     * Consider the following statements:
     * If Fanny is not marrying Arthur, then Georgina is not marrying Charlie.
     * If either Georgina or Helen is marrying Bill, then Arthur is marrying Fanny.
     * If Charlie is not marrying Erica, then Bill is marrying Helen.
     * If Georgina is marrying Don, then Bill is not marrying Fanny.
     * If Don is not marrying Fanny, then Fanny is marrying Bill.
     *
     * Who is marrying whom?
     *
     * Hint: think of the four women as variables, think of the four men as values.
     */
    public static void main(String[] args) {
        /**
         * Let E be Erica
         * Let F be Fanny
         * Let G be Georgina
         * Let H be Helen
         *
         * Let A be Arthur
         * Let B be Bill
         * Let C be Charlie
         * Let D be Don
         *
         * Fanny marrying Arthur => FA
         * Georgina marrying Charlies => GC
         *
         * If Fanny is not marrying Arthur, then Georgina is not marrying Charlie => !FA -> !GC
         * !FA -> !GC = FA || !GC
         *
         * Georgina marrying Bill => GB
         * Helen marrying Bill => HB
         * Fanny Marrying Arthur => FA
         *
         * If either Georgina or Helen is marrying Bill, then Arthur is marrying Fanny => GB || HB -> FA
         * !(GB || HB) || FA
         *
         * Erica marrying Charlie => EC
         * Helen marrying Bill => HB
         *
         * If Charlie is not marrying Erica, then Bill is marrying Helen. =>
         * !EC -> HB = EC || HB
         *
         * Georgina marrying Don => GD
         * Fanny marrying Bill => FB
         *
         * If Georgina is marrying Don, then Bill is not marrying Fanny. =>
         * GD -> !FB = !GD || !FB
         *
         * Fanny marrying Don => FD
         * Fanny marrying Bill => FB
         *
         * If Don is not marrying Fanny, then Fanny is marrying Bill. =>
         * !FD -> FB = FD || FB
         */

        /**
         * Let p = FA
         * q = GC
         * r = GB
         * s = HB
         * t = EC
         * u = GD
         * v = FB
         * w = FD
         *
         * then
         *
         * FA || !GC = p || !q
         * !(GB || HB) || FA = !(r || s) || p
         * EC || HB = t || s
         * !GD || !FB = !u || !v
         * FD || FB = w || v
         */

        char[] men = new char[] {'A', 'B', 'C', 'D'};
        for(char E : men) {
            for(char F : men) {
                //At a time two ladies cannot marry a man
                if(F == E) continue;
                for(char G : men) {
                    //At a time two ladies cannot marry a man
                    if(G == F || G == E) continue;
                    for(char H : men) {
                        //At a time two ladies cannot marry a man
                        if(H == G || H == F || H == E) continue;
                        boolean p = (F == 'A'); //FA
                        boolean q = (G == 'C'); //GC
                        boolean r = (G == 'B'); //GB
                        boolean s = (H == 'B'); //HB
                        boolean t = (E == 'C'); //EC
                        boolean u = (G == 'D'); //GD
                        boolean v = (F == 'B'); //FB
                        boolean w = (F == 'D'); //FD

                        //When the ladies find their exact match all the conditionals will be true
                        // Or the other way around :P
                        if((p || !q) && (!(r || s) || p) && (t || s) && (!u || !v) && (w || v)) {
                            System.out.println("Erica is marrying " + getHusbandsName(E));
                            System.out.println("Fanny is marrying " + getHusbandsName(F));
                            System.out.println("Georgina is marrying " + getHusbandsName(G));
                            System.out.println("Helen is marrying " + getHusbandsName(H));
                        }
                    }
                }
            }
        }
    }

    private static String getHusbandsName(char firstLetter) {
        switch (firstLetter) {
            case 'A':
                return "Arthur";
            case 'B':
                return "Bill";
            case 'C':
                return "Charlie";
            case 'D':
                return "Don";

            default:
                return null;
        }
    }
}
