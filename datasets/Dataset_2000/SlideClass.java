public class SlideClass {
        private ArrayList<ShapeClass> objectList;       private int SlideId;
        public SlideClass()
    {
                objectList = new ArrayList<ShapeClass>();
        SlideId = 0;
    }
        public SlideClass(int id)
    {
        SlideId = id;
                objectList = new ArrayList<ShapeClass>();
    }
        public SlideClass(int id, ArrayList<ShapeClass> importList)
    {
                SlideId = id; 
                objectList = new ArrayList<ShapeClass>();
        objectList.addAll(importList);
    }
    public void addShape(ShapeClass shape)
    {
        objectList.add(shape);
    }
    
    public void removeShape(ShapeClass shape)
    {
        try
        {
            objectList.remove(shape);
        }
        catch(Exception e)
        {
            System.out.println("Object was not in this slide: "+e.getLocalizedMessage());
        }
    }
    public boolean containsShape(ShapeClass shape)
    {
        return objectList.contains(shape);
    }
    public ArrayList<ShapeClass> getObjectList()
    {
        return objectList;
    }
    public void setObjectList(ArrayList<ShapeClass> copyList)
    {
        objectList = copyList; 
    }
    public int getSlideId()
    {
        return SlideId;
    }
    public void setSlideId(int id)
    {
        SlideId = id;
    }
}