public class DummyLord3 extends Agent{
    public DummyLord3(int id, int type){
        super(id, type);
        empireName = "DummyEmpire3";
    }
    public void attack(){
        System.out.println("ATTACK!!!!!!!");
        myTerritory.produceSoldiers(myTerritory.getNatRes(), myTerritory.getPeasants());
        attackingSoldiers = myTerritory.getSoldiers();
        attackedTerritoryID = (new Random()).nextInt(myTerritory.getNeighbors().numObjs) + 1;
    }
}