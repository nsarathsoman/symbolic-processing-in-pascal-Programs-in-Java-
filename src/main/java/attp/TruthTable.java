package attp;

/**
 * Created by sarath on 5/12/16.
 */
public class TruthTable {


    /**
     * Logical expression in Pascal -> NOT (p OR q AND r)  OR  q AND (r OR p)
     *
     * Given below is a table of logical operators in Pascal and their corresponding operators in Java
     * Pascal -> Java
     * NOT    -> !
     * OR     -> ||
     * AND    -> &&
     *
     * So the logical expression NOT (p OR q AND r)  OR  q AND (r OR p) in Pascal can be written as
     * ! (p || q && r)  ||  q && (r || p) in Java
     */

    public static void main(String[] args) {
        boolean[] truthValues = new boolean[] {true, false};

        final String blankSpace = "                    ";

        System.out.println(" p q r   NOT (p OR q AND r)  OR  q AND (r OR p)");

        // We have 3 propositions p, q and r in the given logical expression
        // So we require 3 loops to see all the combinations
        for(boolean p : truthValues) {
            for(boolean q : truthValues) {
                for(boolean r : truthValues) {
                    Character pChar = String.valueOf(p).charAt(0);
                    Character qChar = String.valueOf(q).charAt(0);
                    Character rChar = String.valueOf(r).charAt(0);
                    boolean result = ! (p || q && r)  ||  q && (r || p);
                    Character resultChar = String.valueOf(result).charAt(0);
                    System.out.printf(" %c %c %c %s  %c %s",
                            pChar, qChar, rChar, blankSpace,
                            resultChar, System.lineSeparator());
                }
            }
        }
    }
}
