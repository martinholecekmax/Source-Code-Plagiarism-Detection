public class DowngradeChooser 
	extends FileChooser
{
	
	public static final String HELP_DOWNGRADE_PROPERTY = "helpDowngrade";
	
    private List<Target> targets;
    
    private JComboBox box;
    
    private JButton helpButton;
    
    private TransformsParser parser;
	
	public DowngradeChooser(JFrame owner, int dialogType, String title, 
    					String message, List<FileFilter> filters)
	{
		super(owner, dialogType, title, message, filters);
	}
	
	public void parseData(String file)
		throws Exception
	{
		addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (CANCEL_SELECTION_PROPERTY.equals(evt.getPropertyName())) {
					parser.close();
				}
			}
		});
		helpButton = new JButton();
		UIUtilities.unifiedButtonLookAndFeel(helpButton);
		helpButton.setIcon(IconManager.getInstance().getIcon(IconManager.HELP));
				helpButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				firePropertyChange(HELP_DOWNGRADE_PROPERTY,
						Boolean.valueOf(false), Boolean.valueOf(true));
			}
		});
		parser = new TransformsParser();
		parser.parse(file);
		targets = parser.getTargets();
		Collections.reverse(targets);
				Iterator<Target> i = targets.iterator();
		Object[] values = new Object[targets.size()+1];
		values[0] = parser.getCurrentSchema()+" (current)";
		int index = 1;
		while (i.hasNext()) {
			values[index] = i.next();
			index++;
		}
		box = new JComboBox(values);
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		p.add(new JLabel("Version:"));
		p.add(box);
		p.add(helpButton);
		addComponentToControls(p);
	}
	
	public Target getSelectedSchema()
	{
		if (box == null) return null;
		Object ho = box.getSelectedItem();
		if (ho instanceof Target) return (Target) ho;
		return null;
	}
}