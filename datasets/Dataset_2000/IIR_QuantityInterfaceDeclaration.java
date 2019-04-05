public class IIR_QuantityInterfaceDeclaration extends IIR_InterfaceDeclaration
{
    
    public void accept(IIR_Visitor visitor ){visitor.visit(this);}
    
    public IR_Kind get_kind()
    { return IR_Kind.IR_QUANTITY_INTERFACE_DECLARATION; }
        public IIR_QuantityInterfaceDeclaration() { }
        public IIR_NatureDefinition get_subnature_indication()
    { return _subnature_indication; }
    public void set_subnature_indication(IIR_NatureDefinition subnature)
    { _subnature_indication = subnature; }
        IIR_NatureDefinition _subnature_indication;
}