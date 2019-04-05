abstract public class CustomFilterCriterion implements Parcelable {
    
    public String identifier;
    
    public String text;
    
    public String sql;
    
    public ContentValues valuesForNewTasks = null;
    
    public Bitmap icon;
    
    public String name;
        
    public void writeToParcel(Parcel dest) {
        dest.writeString(identifier);
        dest.writeString(text);
        dest.writeString(sql);
        dest.writeParcelable(valuesForNewTasks, 0);
        dest.writeParcelable(icon, 0);
        dest.writeString(name);
    }
    
    public void readFromParcel(Parcel source) {
        identifier = source.readString();
        text = source.readString();
        sql = source.readString();
        valuesForNewTasks = (ContentValues)source.readParcelable(ContentValues.class.getClassLoader());
        icon = (Bitmap)source.readParcelable(Bitmap.class.getClassLoader());
        name = source.readString();
    }
}