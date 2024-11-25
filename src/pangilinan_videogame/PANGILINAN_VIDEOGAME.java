/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pangilinan_videogame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PANGILINAN_VIDEOGAME extends JFrame {
    private final ArrayList<String> choices = new ArrayList<>();
    private int step = 0;

    private JPanel homePanel, gamePanel, aboutPanel;
    private JTextArea storyArea;
    private JButton button1, button2, button3;

    public PANGILINAN_VIDEOGAME() {
        // Frame setup
        setTitle("5 plus 5: A Life Choices Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new CardLayout());

        // Initialize Panels
        initializeHomeScreen();
        initializeGameScreen();
        initializeAboutScreen();

        // Add Panels to CardLayout
        add(homePanel, "Home");
        add(gamePanel, "Game");
        add(aboutPanel, "About");

        // Show Home Screen
        showPanel("Home");
    }

    private void initializeHomeScreen() {
        homePanel = new JPanel(new GridLayout(5, 1));
        homePanel.setBackground(Color.BLACK);

        JLabel titleLabel = new JLabel("5 plus 5: A Life Choices Game", JLabel.CENTER);
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 24));
        titleLabel.setForeground(Color.RED);

        JButton playButton = createButton("Play");
        JButton aboutButton = createButton("About Page");
        JButton exitButton = createButton("Exit");

        playButton.addActionListener(e -> startGame());
        aboutButton.addActionListener(e -> showPanel("About"));
        exitButton.addActionListener(e -> System.exit(0));

        homePanel.add(titleLabel);
        homePanel.add(playButton);
        homePanel.add(aboutButton);
        homePanel.add(new JLabel("")); // Spacer
        homePanel.add(exitButton);
    }

    private void initializeGameScreen() {
        gamePanel = new JPanel(new BorderLayout());
        gamePanel.setBackground(Color.BLACK);

        // Header
        JLabel header = new JLabel("❤  5 plus 5: A Life Choices Game  ❤", JLabel.CENTER);
        header.setFont(new Font("Monospaced", Font.BOLD, 24));
        header.setForeground(Color.RED);
        gamePanel.add(header, BorderLayout.NORTH);

        // Story Area
        storyArea = new JTextArea("Welcome to '5 plus 5'! Every choice you make shapes your story.");
        storyArea.setLineWrap(true);
        storyArea.setWrapStyleWord(true);
        storyArea.setEditable(false);
        storyArea.setBackground(Color.BLACK);
        storyArea.setForeground(Color.WHITE);
        storyArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
        gamePanel.add(new JScrollPane(storyArea), BorderLayout.CENTER);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.setBackground(Color.BLACK);

        button1 = createButton("Option 1");
        button2 = createButton("Option 2");
        button3 = createButton("Option 3");

        button1.addActionListener(new ButtonClickListener(1));
        button2.addActionListener(new ButtonClickListener(2));
        button3.addActionListener(new ButtonClickListener(3));

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        gamePanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void initializeAboutScreen() {
        aboutPanel = new JPanel(new BorderLayout());
        aboutPanel.setBackground(Color.BLACK);

        JLabel aboutHeader = new JLabel("About Page", JLabel.CENTER);
        aboutHeader.setFont(new Font("Monospaced", Font.BOLD, 24));
        aboutHeader.setForeground(Color.RED);
        aboutPanel.add(aboutHeader, BorderLayout.NORTH);

        JTextArea aboutText = new JTextArea(" This is my first game, and I truly appreciate you taking the time\n"
            + " to play it. It’s a simple story game about life and how the choices\n"
            + " we make shape where we end up. My hope is that this game \n"
            + " makes you laugh, reflect, or think about the decisions you’ve made\n"
            + " and whether they’re something you’re proud of. Every outcome in\n"
            + " this game has a purpose, no matter how silly the career or choices\n"
            + " may seem. It’s about accepting where you are and finding meaning\n"
            + " in it. Even if you pick all the 'worst' options, you can still end\n"
            + " up with any job or career you want. It’s a reminder that your \n"
            + " background doesn’t define your future what truly matters is \n"
            + " whether you’re willing to go after what you really want.");
        aboutText.setEditable(false);
        aboutText.setBackground(Color.BLACK);
        aboutText.setForeground(Color.WHITE);
        aboutText.setFont(new Font("Monospaced", Font.PLAIN, 18));
        aboutPanel.add(aboutText, BorderLayout.CENTER);

        JButton backButton = createButton("Back to Home");
        backButton.addActionListener(e -> showPanel("Home"));
        aboutPanel.add(backButton, BorderLayout.SOUTH);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Monospaced", Font.BOLD, 16));
        button.setFocusPainted(false);
        return button;
    }

    private void startGame() {
        step = 0;
        choices.clear();
        updateStory();
        showPanel("Game");
    }

    private void updateStory() {
        switch (step) {
            case 0:
                storyArea.setText("Your parents encourage you to join a club. What do you choose?\n"
                        + "1. Chess Club (Smart and focused)\n"
                        + "2. Music Band (Creative and balanced)\n"
                        + "3. No Club, hang out with friends (Fun-loving and carefree)");
                break;
            case 1:
                storyArea.setText("You have a big test tomorrow, but your friends invite you out. What do you do?\n"
                        + "1. Study late into the night (Diligent and determined)\n"
                        + "2. Go out but come back early (Balanced and responsible)\n"
                        + "3. Party all night (Reckless and free-spirited)");
                break;
            case 2:
                storyArea.setText("You’re deciding on a college major. What do you choose?\n"
                        + "1. Computer Science (Logical and ambitious)\n"
                        + "2. Liberal Arts (Creative and thoughtful)\n"
                        + "3. Skip College (Risk-taking and unconventional)");
                break;
            case 3:
                storyArea.setText("You’re offered a high-paying but stressful job far from home. What do you do?\n"
                        + "1. Take the job (Driven and career-focused)\n"
                        + "2. Find a local, lower-paying job (Family-oriented and balanced)\n"
                        + "3. Skip it, live off savings (Carefree and relaxed)");
                break;
            case 4:
                promptFinalJob();
                break;
        }
    }

    private void promptFinalJob() {
        // Disable buttons and add input dialog for the final job
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);

        String finalJob = JOptionPane.showInputDialog(this,
                "Based on your life choices, what job did you get? (e.g., Teacher, Programmer, Artist)");

        if (finalJob != null && !finalJob.trim().isEmpty()) {
            displayOutcome(finalJob);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid job to complete your story.");
            promptFinalJob();
        }
    }

    private void displayOutcome(String finalJob) {
        // Build a custom story based on choices
        StringBuilder story = new StringBuilder();

        story.append("As a young person, you ").append(choices.get(0)).append(", showing early signs of your personality. ");
        story.append("When balancing school and fun, you ").append(choices.get(1)).append(". ");
        story.append("For your education, you ").append(choices.get(2)).append(", shaping your future opportunities. ");
        story.append("Finally, as an adult, you ").append(choices.get(3)).append(". ");
        story.append("With these choices, you became a ").append(finalJob)
                .append(", finding fulfillment and purpose in your journey.");

        // Display result
        storyArea.setText(story.toString());

        // Add an "Exit" button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        gamePanel.add(exitButton, BorderLayout.NORTH);
        validate(); // Refresh layout to show the new button
    }

    private void showPanel(String panelName) {
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), panelName);
    }

    private class ButtonClickListener implements ActionListener {
        private final int option;

        public ButtonClickListener(int option) {
            this.option = option;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (step == 0) {
                if (option == 1) choices.add("joined the Chess Club, becoming smart and focused");
                else if (option == 2) choices.add("joined the Music Band, fostering creativity and balance");
                else if (option == 3) choices.add("chose to hang out with friends, enjoying carefree fun");
            } else if (step == 1) {
                if (option == 1) choices.add("studied hard, showing determination and diligence");
                else if (option == 2) choices.add("balanced your fun with responsibility, coming back early");
                else if (option == 3) choices.add("partied all night, living recklessly");
            } else if (step == 2) {
                if (option == 1) choices.add("chose Computer Science, demonstrating ambition and logic");
                else if (option == 2) choices.add("chose Liberal Arts, valuing creativity and thoughtfulness");
                else if (option == 3) choices.add("skipped college, embracing risk-taking and unconventional paths");
            } else if (step == 3) {
                if (option == 1) choices.add("took the high-paying job, prioritizing career and ambition");
                else if (option == 2) choices.add("took a local job, balancing family and career");
                else if (option == 3) choices.add("decided to live off savings, valuing freedom over stability");
            }

            step++;
            updateStory();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PANGILINAN_VIDEOGAME().setVisible(true));
    }
}
