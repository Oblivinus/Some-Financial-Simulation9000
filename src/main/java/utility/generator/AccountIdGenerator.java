package utility.generator;

import utility.VinesUtil;
import static utility.generator.Generator.isAlreadyExist;
import static utility.generator.Generator.rand;

public class AccountIdGenerator extends Generator {

    static final String baseId = "012";

    public static String generate() {
        String result = baseId;
        result += VinesUtil.getDate("ddMMyy");

        String temp;

        do {
            String padded = String.format("%03d", rand.nextInt(0, 999));
            temp = result + padded;
        } while( isAlreadyExist(temp) );

        addToGenerated(temp);
        return temp;
    }
}
