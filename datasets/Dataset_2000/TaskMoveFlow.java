public interface TaskMoveFlow extends Flow<Task> {
  TaskFlow toNextColumn() throws ServerCommunicationException;
  TaskFlow toPreviousColumn() throws ServerCommunicationException;
  TaskFlow to(TaskLocation location) throws ServerCommunicationException;
  TaskFlow to(Column column) throws ServerCommunicationException ;
  
  TaskFlow toIceBox() throws ServerCommunicationException, CanOnlyIceBoxTaskFromFirstColumnException;
  
  TaskFlow toArchive() throws ServerCommunicationException;
  
  TaskFlow toBoard() throws ServerCommunicationException;
  TaskFlow toLastColumn() throws ServerCommunicationException;
  TaskFlow toFirstColumn() throws ServerCommunicationException;
}