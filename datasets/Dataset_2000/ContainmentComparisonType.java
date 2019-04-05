@XmlType(name = "ContainmentComparisonType")
@XmlEnum
public enum ContainmentComparisonType {
    @XmlEnumValue("Exact")
    EXACT("Exact"),
    @XmlEnumValue("IgnoreCase")
    IGNORE_CASE("IgnoreCase"),
    @XmlEnumValue("IgnoreNonSpacingCharacters")
    IGNORE_NON_SPACING_CHARACTERS("IgnoreNonSpacingCharacters"),
    @XmlEnumValue("Loose")
    LOOSE("Loose"),
    @XmlEnumValue("IgnoreCaseAndNonSpacingCharacters")
    IGNORE_CASE_AND_NON_SPACING_CHARACTERS("IgnoreCaseAndNonSpacingCharacters"),
    @XmlEnumValue("LooseAndIgnoreCase")
    LOOSE_AND_IGNORE_CASE("LooseAndIgnoreCase"),
    @XmlEnumValue("LooseAndIgnoreNonSpace")
    LOOSE_AND_IGNORE_NON_SPACE("LooseAndIgnoreNonSpace"),
    @XmlEnumValue("LooseAndIgnoreCaseAndIgnoreNonSpace")
    LOOSE_AND_IGNORE_CASE_AND_IGNORE_NON_SPACE("LooseAndIgnoreCaseAndIgnoreNonSpace");
    private final String value;
    ContainmentComparisonType(String v) {
        value = v;
    }
    public String value() {
        return value;
    }
    public static ContainmentComparisonType fromValue(String v) {
        for (ContainmentComparisonType c: ContainmentComparisonType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}