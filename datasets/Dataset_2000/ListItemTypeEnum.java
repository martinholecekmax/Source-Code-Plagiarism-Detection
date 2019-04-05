@XmlEnum
public enum ListItemTypeEnum {
    @XmlEnumValue("radioFolder")
    RADIO_FOLDER("radioFolder"),
    @XmlEnumValue("check")
    CHECK("check"),
    @XmlEnumValue("checkHideChildren")
    CHECK_HIDE_CHILDREN("checkHideChildren"),
    @XmlEnumValue("checkOffOnly")
    CHECK_OFF_ONLY("checkOffOnly");
    private final String value;
    ListItemTypeEnum(String v) {
        value = v;
    }
    public String value() {
        return value;
    }
    public static ListItemTypeEnum fromValue(String v) {
        for (ListItemTypeEnum c: ListItemTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }
}