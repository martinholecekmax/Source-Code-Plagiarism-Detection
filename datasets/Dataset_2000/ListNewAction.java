public class ListNewAction extends SimpleButtonAction implements ActionListener{
    
	private NoteModel model;
	
	private NoteViewManager manager;
	
	public ListNewAction( NoteViewManager manager, NoteModel model ){
		this.manager = manager;
		this.model = model;
		setText( "New note" );
		setIcon( ResourceSet.APPLICATION_ICONS.get( "list.new" ) );
		addActionListener( this );
	}
	public void actionPerformed( ActionEvent e ){
		manager.show( model.addNote() );
	}
}