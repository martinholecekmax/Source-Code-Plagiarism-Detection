public class ChooseFMSelectionListener implements SelectionListener {
   Logger log = Logger.getLogger(ChooseFMSelectionListener.class);
   private Composite parentComposite;
   private ViewmodelMultiPageEditor mpe;
   public ChooseFMSelectionListener(Composite composite, ViewmodelMultiPageEditor multiPageEditor) {
      this.parentComposite = composite;
      this.mpe = multiPageEditor;
   }
   
   @Override
   public void widgetSelected(SelectionEvent e) {
            browseMapping();
   }
   
   private void browseMapping() {
      List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
      ArrayList<String> extensions = FeatureMappingUtil.getMappingModelExtensions();
      GroupModel groupModel = mpe.getGroupModel();
      ViewmodelMappingFilter filter = new ViewmodelMappingFilter(extensions, groupModel);
      filters.add(filter);
      IFile[] selectedFiles =
         WorkspaceResourceDialog.openFileSelection(parentComposite.getShell(), "Choose mapping", "Please choose a mapping:", false, null,
                                                   filters);
      if (selectedFiles.length > 0) {
         String path = selectedFiles[0].getFullPath().toString();
         log.debug(path);
         URI uri = URI.createPlatformResourceURI(path, true);
         mpe.setFeatureMapping(uri);
      }
   }
   
   @Override
   public void widgetDefaultSelected(SelectionEvent e) {}
}