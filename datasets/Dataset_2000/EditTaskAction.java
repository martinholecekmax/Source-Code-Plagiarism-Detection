public class EditTaskAction extends BasicAction {
    private final TaskTable table;
    public EditTaskAction(TaskTable table) {
        super("actionEditTask");
        this.table = table;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        final int index = table.getSelectedRow();
        final TaskTableModel model = table.getTaskTableModel();
        final Task task = model.getTask(index);
        final TaskDialog taskDialog = new TaskDialog();
        taskDialog.setTaskToEdit(task);
        taskDialog.setVisible(true);
        Task updatedTask = taskDialog.getResult();
        if (updatedTask != null) {
            model.insertTask(index, updatedTask);
            model.fireTableDataChanged();
        }
    }
    @Override
    public void validate() {
        setEnabled(table.getSelectedRowCount() > 0);
    }
}