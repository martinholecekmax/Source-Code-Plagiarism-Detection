public class WhiteSpaceShorthandParser implements ShorthandParser {
    
    public Property getValueForProperty(int propId, Property property,
            PropertyMaker maker, PropertyList propertyList)
            throws PropertyException {
        switch (property.getEnum()) {
        case Constants.EN_PRE:
            switch (propId) {
            case Constants.PR_LINEFEED_TREATMENT:
            case Constants.PR_WHITE_SPACE_TREATMENT:
                return EnumProperty.getInstance(Constants.EN_PRESERVE, "PRESERVE");
            case Constants.PR_WHITE_SPACE_COLLAPSE:
                return EnumProperty.getInstance(Constants.EN_FALSE, "FALSE");
            case Constants.PR_WRAP_OPTION:
                return EnumProperty.getInstance(Constants.EN_NO_WRAP, "NO_WRAP");
            default:
                            }
        case Constants.EN_NO_WRAP:
            if (propId == Constants.PR_WRAP_OPTION) {
                return EnumProperty.getInstance(Constants.EN_NO_WRAP, "NO_WRAP");
            }
        case Constants.EN_NORMAL:
        default:
                    }
        return null;
    }
}