public class MC3030 extends LogicIC {
    
    public String getTitle() {
        return "RS NOR LATCH";
    }
    
    public void think(LogicChipState chip) {
        boolean set = chip.getIn(1).is();
        boolean reset = chip.getIn(2).is();
        if (set && reset) {
            chip.getOut(1).set(false);
        } else if (set && !reset) {
            chip.getOut(1).set(true);
        } else if (!set && reset) {
            chip.getOut(1).set(false);
        }
    }
}