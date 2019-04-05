public class MoveqInstruction extends Instruction {
   public static Integer operandCount = 2;
   public MoveqInstruction() {
      super();sparcs.add("move");
   }
   public String toString() { return this.toILOC(); }
   public String toILOC() {
      String classPattern = new String("Immediate Register");
      String[] pattern = classPattern.split(" ");
      String ret = "moveq ";
      int operandCount = this.getOperands().size();
      if ((operandCount != 0) && (operandCount != pattern.length)) {
         Evil.error(ret + ": Found " + operandCount + " operands, ILOC expecting " + pattern.length);
      }
      for (Operand r : this.getOperands()) {
         if (!r.toString().equals(""))
            ret = ret + r.toILOC() + ", ";
      }
      ret = ret.trim();
      if (ret.lastIndexOf(",") == ret.length()-1)
         ret = ret.substring(0, ret.length()-1);
      for (int i = 0; i < this.getOperands().size(); i++) {
         Operand o = this.getOperands().get(i);
         String oper = "null";
         if (o != null) { oper = o.getClass().getName(); }
         if (!oper.equals(pattern[i])) {
            Evil.error(ret + ": ILOC expecting " + classPattern + ". Found " + oper);
         }
      }
      return ret;
   }
}