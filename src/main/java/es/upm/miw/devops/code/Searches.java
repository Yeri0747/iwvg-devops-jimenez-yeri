package es.upm.miw.devops.code;

import java.util.stream.Stream;

public class Searches {

    public Fraction findHighestFraction() {
        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream()
                        .filter(f -> f != null && f.getDenominator() != 0))
                .max((f1, f2) -> Double.compare(f1.decimal(), f2.decimal()))
                .orElse(null);
    }

    public Fraction findFractionSubtractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .flatMap(user -> user.getFractions().stream())
                .filter(f -> f != null && f.getDenominator() != 0)
                .reduce((f1, f2) -> {
                    Fraction negativeF2 = new Fraction(-f2.getNumerator(), f2.getDenominator());
                    return f1.add(negativeF2);
                })
                .orElse(null);
    }

    public Stream<String> findUserFamilyNameBySomeImproperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions()
                        .stream()
                        .anyMatch(f -> f != null && f.getDenominator() != 0 && f.isImproper())
                )
                .map(User::getFamilyName);
    }

    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {
        return new UsersDatabase().findAll()
                .filter(user -> familyName.equals(user.getFamilyName()))
                .flatMap(user -> user.getFractions().stream())
                .filter(f -> f != null && f.getDenominator() != 0)
                .reduce((f1, f2) -> f1.multiply(f2))
                .orElse(null);
    }

}