public final class ActiveApiOperationServiceRegistry extends AbstractOperationServiceRegistry {
      @SuppressWarnings("deprecation")
  @Inject
  public ActiveApiOperationServiceRegistry(NotifyOperationService notifyOpService) {
    super();
        register(OperationType.ROBOT_NOTIFY, notifyOpService);
    register(OperationType.ROBOT_NOTIFY_CAPABILITIES_HASH, notifyOpService);
    register(OperationType.WAVELET_ADD_PARTICIPANT_NEWSYNTAX, ParticipantServices.create());
    register(OperationType.WAVELET_APPEND_BLIP, BlipOperationServices.create());
    register(OperationType.WAVELET_REMOVE_PARTICIPANT_NEWSYNTAX, ParticipantServices.create());
    register(OperationType.BLIP_CONTINUE_THREAD, BlipOperationServices.create());
    register(OperationType.BLIP_CREATE_CHILD, BlipOperationServices.create());
    register(OperationType.BLIP_DELETE, BlipOperationServices.create());
    register(OperationType.DOCUMENT_APPEND_INLINE_BLIP, BlipOperationServices.create());
    register(OperationType.DOCUMENT_APPEND_MARKUP, BlipOperationServices.create());
    register(OperationType.DOCUMENT_INSERT_INLINE_BLIP, BlipOperationServices.create());
    register(
        OperationType.DOCUMENT_INSERT_INLINE_BLIP_AFTER_ELEMENT, BlipOperationServices.create());
    register(OperationType.ROBOT_CREATE_WAVELET, CreateWaveletService.create());
    register(OperationType.ROBOT_FETCH_WAVE, FetchWaveService.create());
    register(OperationType.DOCUMENT_MODIFY, DocumentModifyService.create());
    register(OperationType.WAVELET_SET_TITLE, WaveletSetTitleService.create());
    register(OperationType.ROBOT_FOLDER_ACTION, FolderActionService.create());
  }
}