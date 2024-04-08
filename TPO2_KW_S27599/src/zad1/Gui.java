package zad1;

import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Gui extends JFrame {
    private JTextField cityName;
    private JTextField countryname;
    private JButton submitButton;
    private JPanel forecast;
    private JLabel pressure;
    private JLabel humidity;
    private JLabel tempValue;
    private JLabel pressureValue;
    private JLabel humidityValue;
    private JPanel mainPanel;
    private JTextField notNBPCountry;
    private JLabel notNBP;
    private JLabel NBP;
    private JPanel webPanel;
    private JLabel temp;
    private JPanel ratesPanel;
    private Service service;
    private JFrame mainFrame;
    private JFXPanel jfxPanel;

    public Gui(Service service) throws HeadlessException {
        this.service = service;
        this.mainFrame = this;
        jfxPanel = new JFXPanel();
        this.webPanel.add(jfxPanel);

        submitButton.addActionListener(e -> {
            String cityNameText = cityName.getText();
            String countryNameText = countryname.getText();
            String notNBPCountryText = notNBPCountry.getText();
            service.setCountry(countryNameText);
            String json = service.getWeather(cityNameText);
            Weather weather = new Gson().fromJson(json, Weather.class);

            tempValue.setText(String.valueOf(weather.main.temp));
            pressureValue.setText(String.valueOf(weather.main.pressure));
            humidityValue.setText(String.valueOf(weather.main.humidity));
            notNBP.setText(String.valueOf(service.getRateFor(notNBPCountryText)));
            NBP.setText(String.valueOf(service.getNBPRate()));


            Platform.runLater(() -> {
                createJFXContent(cityNameText);
                mainFrame.pack();
            });


        });

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
        this.pack();
    }

    private void createJFXContent(String cityNameText) {
        WebView webView = new WebView();
        webView.getEngine().load("https://en.wikipedia.org/wiki/" + cityNameText);
        Scene scene = new Scene(webView);
        jfxPanel.setScene(scene);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        cityName = new JTextField();
        cityName.setText("Warszawa");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(cityName, gbc);
        countryname = new JTextField();
        countryname.setText("Poland");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(countryname, gbc);
        submitButton = new JButton();
        submitButton.setText("Submit");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(submitButton, gbc);
        forecast = new JPanel();
        forecast.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(forecast, gbc);
        temp = new JLabel();
        temp.setText("Temperature");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        forecast.add(temp, gbc);
        tempValue = new JLabel();
        tempValue.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        forecast.add(tempValue, gbc);
        pressure = new JLabel();
        pressure.setText("Pressure");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        forecast.add(pressure, gbc);
        pressureValue = new JLabel();
        pressureValue.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        forecast.add(pressureValue, gbc);
        humidity = new JLabel();
        humidity.setText("Humidity");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        forecast.add(humidity, gbc);
        humidityValue = new JLabel();
        humidityValue.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        forecast.add(humidityValue, gbc);
        ratesPanel = new JPanel();
        ratesPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        forecast.add(ratesPanel, gbc);
        ratesPanel.setBorder(BorderFactory.createTitledBorder(null, "Rates:", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JLabel label1 = new JLabel();
        label1.setText("not NBP");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        ratesPanel.add(label1, gbc);
        notNBP = new JLabel();
        notNBP.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        ratesPanel.add(notNBP, gbc);
        NBP = new JLabel();
        NBP.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        ratesPanel.add(NBP, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("NBP");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        ratesPanel.add(label2, gbc);
        notNBPCountry = new JTextField();
        notNBPCountry.setText("USD");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        ratesPanel.add(notNBPCountry, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("not NBP for: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        ratesPanel.add(label3, gbc);
        webPanel = new JPanel();
        webPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(webPanel, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
