public class MyActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
                PagedGrid grid=(PagedGrid)findViewById(R.id.paginador);
                grid.setAdapter(new GridAdapter(this),5,4);
    }
    
    private static class GridAdapter extends BaseAdapter{
        private Bitmap image;
        public GridAdapter(Context context){
            image= BitmapFactory.decodeResource(context.getResources(),R.drawable.adw);
        }
        @Override
        public int getCount() {
            return 87;
        }
        @Override
        public Object getItem(int i) {
            return image;
        }
        @Override
        public long getItemId(int i) {
            return i;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
                ImageView img= (ImageView) convertView.findViewById(R.id.thumb);
                img.setImageBitmap(image);
            }
            TextView title = (TextView) convertView.findViewById(R.id.title);
            title.setText("ITEM "+position);
            return convertView;
        }
    }
}