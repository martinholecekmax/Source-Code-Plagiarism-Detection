public class OneOfConstraint
    implements Constraint<OneOf, String>
{
    public boolean isValid( OneOf oneOf, String value )
    {
        for( int i = 0; i < oneOf.value().length; i++ )
        {
            String possibleValue = oneOf.value()[ i ];
            if( possibleValue.equals( value ) )
            {
                return true;
            }
        }
        return false;
    }
}