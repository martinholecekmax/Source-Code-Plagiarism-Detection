public class ListCategoryAdapter extends ArrayAdapter<String>{
	private final Context context;
	private final String[] values;
	public ListCategoryAdapter(Context context, String[] values) {
		super(context, R.layout.listmenucatalog, values);
		this.context = context;
		this.values = values;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.list, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.namapuskesmas);
		textView.setText(values[position]);
		return rowView;
	}
}