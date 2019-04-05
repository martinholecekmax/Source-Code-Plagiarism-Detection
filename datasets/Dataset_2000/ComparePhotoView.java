public class ComparePhotoView extends Activity{
	private ImageView imagePreview1;
	private TextView photoGroupName1;
	private ImageView imagePreview2;
	private TextView photoGroupName2;
	private long rowIdOne;
	private long rowIdTwo;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comparephotos);
        rowIdOne = getIntent().getLongExtra("RowIdOne", 0);
        rowIdTwo = getIntent().getLongExtra("RowIdTwo", 0);
        imagePreview1 = (ImageView) findViewById(R.id.compareView1);
        photoGroupName1 = (TextView) findViewById(R.id.textView1);
        imagePreview2 = (ImageView) findViewById(R.id.compareView2);
        photoGroupName2 = (TextView) findViewById(R.id.textView2);
    }
	
	@Override
	protected void onStart() {
		super.onStart();
		DatabaseAdapter dbHelper;
		dbHelper = new DatabaseAdapter(this);
		dbHelper.open();
		Cursor cursor;
				cursor = dbHelper.fetchPhoto(rowIdOne);
		        		byte[] photoOne = cursor.getBlob(cursor.getColumnIndex(DatabaseAdapter.PHOTO));
		Bitmap bitmapOne = BitmapFactory.decodeByteArray(photoOne, 0, photoOne.length);
		bitmapOne.setDensity(10);
        imagePreview1.setImageBitmap(bitmapOne);
                String dateOne = cursor.getString(cursor.getColumnIndex(DatabaseAdapter.DATE));
        photoGroupName1.setText(dateOne);
        cursor.close();
                cursor = dbHelper.fetchPhoto(rowIdTwo);
                		byte[] photoTwo = cursor.getBlob(cursor.getColumnIndex(DatabaseAdapter.PHOTO));
		Bitmap bitmapTwo = BitmapFactory.decodeByteArray(photoTwo, 0, photoTwo.length);
		bitmapTwo.setDensity(10);
        imagePreview2.setImageBitmap(bitmapTwo);
                String dateTwo = cursor.getString(cursor.getColumnIndex(DatabaseAdapter.DATE));
        photoGroupName2.setText(dateTwo);
        cursor.close();
        dbHelper.close();
	}
}