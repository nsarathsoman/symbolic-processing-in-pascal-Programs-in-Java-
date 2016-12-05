package attp;

/**
 * Created by sarath on 5/12/16.
 */
public class MaterialImplicationAndEquivalence {

    public static void main(String[] args) {

        boolean[] truthValues = new boolean[] {true, false};

        /**
         * Truth table for p -> q and p <-> q
         */
        System.out.println(" p q  p -> q  p <-> q");
        for (boolean p : truthValues) {
            for (boolean q : truthValues) {

                // p -> q = !p || q
                boolean pImpQ = !p || q;

                // p <-> q = p = q
                boolean pBiImpQ = p == q;

                System.out.printf(" %d %d    %d        %d",
                        p ? 1 : 0,
                        q ? 1 : 0,
                        pImpQ ? 1 : 0,
                        pBiImpQ ? 1 : 0);
                System.out.println();
            }
        }

    }

}
