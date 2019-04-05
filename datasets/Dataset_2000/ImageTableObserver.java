public class ImageTableObserver extends ContentObserver {
    private static final String TAG = "ImageTableObserver";
    
    private MiltonPhotoUploader application;
    
    private ExecutorService queue;
    
    public ImageTableObserver( Handler handler, MiltonPhotoUploader application, ExecutorService queue ) {
        super( handler );
        this.application = application;
        this.queue = queue;
    }
    
    @Override
    public void onChange( boolean selfChange ) {
        Log.i(TAG, "onChange");
                ImageLatest latestImage = new ImageLatest( application );
        int imageId = latestImage.getId();
                if( imageId == -1 ) {
            return;
        }
                ImageItem item = latestImage.getLatestItem();
                if( item == null ) {
            return;
        }
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences( application.getBaseContext() );
                if( !CheckInternet.getInstance().canConnect( application.getBaseContext(), prefs ) ) {
            Log.v(TAG, "cant connect to internet");
            return;
        }
                if( !albumExists( ) ) {
            Log.i(TAG, "onChange");
            return;
        }
                Log.i(TAG, "add to queue: " + item.imagePath);
        queue.execute( new MiltonPutUploader( application.getBaseContext(), queue, item, application.getConfig(), 0 ) );
    }
    
    private boolean albumExists( ) {
        return new AlbumExists( application.getConfig() ).hasAlbum();
    }
}