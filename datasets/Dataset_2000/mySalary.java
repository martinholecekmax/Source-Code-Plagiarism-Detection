public class mySalary extends JFrame {
  private DocumentListener listener = new DocumentListener() {
    public void insertUpdate(DocumentEvent p0) {
      update();
    }
    public void removeUpdate(DocumentEvent p0) {
      update();
    }
    public void changedUpdate(DocumentEvent p0) {
      update();
    }
  };
  private JTextField inputField_a = new JTextField();
  private JTextField inputField_b = new JTextField();
  private JTextField outputField_a = new JTextField();
  public mySalary() {
    setTitle("mySalary");
    setLayout(new GridLayout(0, 2));
    inputField_a.getDocument().addDocumentListener(this.listener);
    add(new JLabel("Java Hours"));
    add(inputField_a);
    inputField_b.getDocument().addDocumentListener(this.listener);
    add(new JLabel("PHP Hours"));
    add(inputField_b);
    add(new JLabel("Output"));
    add(this.outputField_a);
    update();
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setVisible(true);
  }
  public void update() {
    int i_a = 0;
    int i_b = 0;
    try {
      i_a = Integer.parseInt(inputField_a.getText());
      i_b = Integer.parseInt(inputField_b.getText());
    } catch (NumberFormatException e) {
    }
    outputField_a.setText("" + (i_a * 10 + i_b * 5));
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new mySalary();
      }
    });
  }
}