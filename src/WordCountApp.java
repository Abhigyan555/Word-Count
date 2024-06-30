import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCountApp {
    private JFrame frame;
    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JButton countButton;

    public WordCountApp() {
        // Create the main frame
        frame = new JFrame("Word Count Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Create a text area
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450, 250));

        // Create a label for word count
        wordCountLabel = new JLabel("Word Count: 0");
        wordCountLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Create a button to count words
        countButton = new JButton("Count Words");
        countButton.setFont(new Font("Arial", Font.BOLD, 14));
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        // Layout the components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout(10, 10));
        bottomPanel.add(countButton, BorderLayout.WEST);
        bottomPanel.add(wordCountLabel, BorderLayout.CENTER);

        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Add panel to frame
        frame.add(panel);

        // Set frame visibility
        frame.setVisible(true);
    }

    private void countWords() {
        String text = textArea.getText();
        if (text.isEmpty()) {
            wordCountLabel.setText("Word Count: 0");
        } else {
            String[] words = text.split("\\s+");
            wordCountLabel.setText("Word Count: " + words.length);
        }
    }

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCountApp();
            }
        });
    }
}
