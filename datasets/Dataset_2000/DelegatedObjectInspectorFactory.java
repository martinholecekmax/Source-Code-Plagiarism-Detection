public class DelegatedObjectInspectorFactory {
  public static ObjectInspector wrap(ObjectInspector inspector) {
    switch (inspector.getCategory()) {
      case PRIMITIVE:
        return inspector;
      case LIST:
        return new DelegatedListObjectInspector((ListObjectInspector) inspector);
      case MAP:
        return new DelegatedMapObjectInspector((MapObjectInspector) inspector);
      case STRUCT:
        return new DelegatedStructObjectInspector((StructObjectInspector) inspector);
      case UNION:
        return new DelegatedUnionObjectInspector((UnionObjectInspector) inspector);
      default:
        throw new RuntimeException("invalid category " + inspector.getCategory());
    }
  }
  public static ObjectInspector reset(ObjectInspector prev, ObjectInspector current) {
    switch (current.getCategory()) {
      case PRIMITIVE:
        break;
      case LIST:
        ((DelegatedListObjectInspector)prev).reset((ListObjectInspector) current);
        break;
      case MAP:
        ((DelegatedMapObjectInspector)prev).reset((MapObjectInspector) current);
        break;
      case STRUCT:
        ((DelegatedStructObjectInspector)prev).reset((StructObjectInspector) current);
        break;
      case UNION:
        ((DelegatedUnionObjectInspector)prev).reset((UnionObjectInspector) current);
        break;
      default:
        throw new RuntimeException("invalid category " + current.getCategory());
    }
    return prev;
  }
}