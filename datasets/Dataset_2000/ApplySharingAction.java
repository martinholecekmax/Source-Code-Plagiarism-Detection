class ApplySharingAction extends AbstractAction {
    private final Provider<LibrarySharingPanel> librarySharingPanel;
    private final Provider<LibrarySharingEditablePanel> librarySharingEditablePanel;
    private final Provider<LibraryNavigatorPanel> libraryNavigatorPanel;
    private final Provider<LibraryTable> libraryTable;
    @Inject
    public ApplySharingAction(Provider<LibrarySharingPanel> librarySharingPanel,
            Provider<LibrarySharingEditablePanel> librarySharingEditablePanel,
            Provider<LibraryNavigatorPanel> libraryNavigatorPanel,
            Provider<LibraryTable> libraryTable) {
        super(I18n.tr("Apply"));
        this.librarySharingPanel = librarySharingPanel;
        this.librarySharingEditablePanel = librarySharingEditablePanel;
        this.libraryNavigatorPanel = libraryNavigatorPanel;
        this.libraryTable = libraryTable;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        List<String> friends = librarySharingEditablePanel.get().getSelectedFriendIds();
        librarySharingPanel.get().setFriendIdsForSharing(friends);
        libraryNavigatorPanel.get().repaint();
        librarySharingPanel.get().showFriendListView();
        libraryTable.get().repaint();
    }
}