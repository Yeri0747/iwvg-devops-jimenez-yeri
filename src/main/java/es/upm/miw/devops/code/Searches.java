package es.upm.miw.devops.code;

public class Searches {

    public Fraction findHighestFraction() {
        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream()
                        .filter(f -> f != null && f.getDenominator() != 0))
                .max((f1, f2) -> Double.compare(f1.decimal(), f2.decimal()))
                .orElse(null);
    }

}