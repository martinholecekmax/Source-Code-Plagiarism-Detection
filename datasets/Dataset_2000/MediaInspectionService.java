public interface MediaInspectionService {
  
  String JOB_TYPE = "org.opencastproject.inspection";
  
  Job inspect(URI uri) throws MediaInspectionException;
  
  Job enrich(MediaPackageElement original, boolean override) throws MediaInspectionException,
          MediaPackageException;
}