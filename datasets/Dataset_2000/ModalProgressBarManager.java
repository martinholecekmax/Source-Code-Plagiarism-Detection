public class ModalProgressBarManager implements ProgressDisplay {
    private ModalProgressBarDialog dialog;
    public ModalProgressBarManager(String title) {
        JFrame frame = (JFrame) Application.getMainWindow();
        dialog = new ModalProgressBarDialog(0, 100, frame, title);
        Thread thread = new Thread(dialog, "ModalProgressBar");
        thread.start();
        try {
            Thread.sleep(1);
        }
        catch (InterruptedException e) {
          Log.getLogger().log(Level.SEVERE, "Exception caught", e);
        }
    }
    public void setProgressText(String str) {
        dialog.setLabel(str);
        try {
            Thread.sleep(1);
        }
        catch (InterruptedException e) {
          Log.getLogger().log(Level.SEVERE, "Exception caught", e);
        }
    }
    public void setProgressValue(double value) {
        if (dialog.setValueRelative(value)) {
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException e) {
              Log.getLogger().log(Level.SEVERE, "Exception caught", e);
            }
        }
    }
    public void start() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                dialog.show();
            }
        });
    }
    public void stop() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ComponentUtilities.dispose(dialog);
            }
        });
    }
}