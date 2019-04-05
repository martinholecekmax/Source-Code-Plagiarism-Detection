public interface GetAccountTreeListener extends ResponseListener {
    
    String STATUS_LISTING_OK = "listing_ok";
    
    String STATUS_E_FOLDER_ID = "e_folder_id";
    
    void onComplete(BoxFolder targetFolder, String status);
}