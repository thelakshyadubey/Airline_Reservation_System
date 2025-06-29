package dubeyji_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.format.DateTimeParseException;
import javax.swing.table.DefaultTableModel;

public class AirlineReservationSystem extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private static Connection myobj;
    private static JTextField usernameField, nameField, ageField, genderField, aadharField, destinationField, dateField, classField;
    private static JPasswordField passwordField;
    private static JButton loginButton, registerButton, bookButton, flightInfoButton, bookingStatusButton,  cancelButton;
    private static JLabel statusLabel;
    private static JFrame mainFrame;
    private static String currentUser;

    public static void main(String[] args) {
        connectDatabase();

        mainFrame = new JFrame("Airline Reservation System");
        mainFrame.setSize(600, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(6, 1));
        
        // Load the image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\Dubeyji\\eclipse-workspace\\dubeyji_GUI\\img\\Narsee Monjee AIRLINES.jpg"); 
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new GridLayout(4, 1));

        // Set content pane to the background label
        mainFrame.setContentPane(backgroundLabel);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout());

        JLabel userLabel = new JLabel("User ID:");
        usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new AirlineReservationSystem());

        registerButton = new JButton("Register");
        registerButton.addActionListener(new AirlineReservationSystem());

        statusLabel = new JLabel("", JLabel.CENTER);

        loginPanel.add(userLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(registerButton);

        mainFrame.add(loginPanel);
        mainFrame.add(statusLabel);

        mainFrame.setVisible(true);
    }

    public static void connectDatabase() {
        try {
            myobj = DriverManager.getConnection("jdbc:mysql://localhost/ars", "root", "root");
            if (myobj != null) {
                System.out.println("\nWELCOME TO AIRLINE RESERVATION SYSTEM PROGRAM");
                System.out.println("LAKSHYA DUBEY - 70022200396");
            } else {
                System.out.println("Database Connection Problem");
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database:");
            e.printStackTrace();
        }
    }
    
    private JButton createBackButton(JFrame frame) {
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu(currentUser); // Go back to the main menu
                frame.dispose(); // Close the current frame
            }
        });
        return backButton;
    }
    
    private JButton createBackToLoginPageButton(JFrame frame, JFrame destinationFrame) {
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destinationFrame.setVisible(true); // Show the destination frame
                frame.dispose(); // Close the current frame
            }
        });
        return backButton;
    }


    public static void mainMenu(String user) {
        currentUser = user;
        mainFrame.getContentPane().removeAll();
        mainFrame.repaint();
        mainFrame.setLayout(new GridLayout(6, 1));

        bookButton = new JButton("Book a Ticket");
        bookButton.addActionListener(new AirlineReservationSystem());

        flightInfoButton = new JButton("Flight Information");
        flightInfoButton.addActionListener(new AirlineReservationSystem());

        bookingStatusButton = new JButton("Booking Status");
        bookingStatusButton.addActionListener(new AirlineReservationSystem());

       

        cancelButton = new JButton("Cancel Your Booking");
        cancelButton.addActionListener(new AirlineReservationSystem());

        JButton logoutButton = new JButton("Logout"); // Add logout button
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the current user and go back to the login page
                currentUser = null;
                mainFrame.getContentPane().removeAll();
                mainFrame.repaint();
                mainFrame.setLayout(new GridLayout(3, 1));

                JPanel loginPanel = new JPanel();
                loginPanel.setLayout(new FlowLayout());

                JLabel userLabel = new JLabel("User ID:");
                usernameField = new JTextField(20);
                JLabel passwordLabel = new JLabel("Password:");
                passwordField = new JPasswordField(20);

                loginButton = new JButton("Login");
                loginButton.addActionListener(new AirlineReservationSystem());

                registerButton = new JButton("Register");
                registerButton.addActionListener(new AirlineReservationSystem());

                statusLabel = new JLabel("", JLabel.CENTER);

                loginPanel.add(userLabel);
                loginPanel.add(usernameField);
                loginPanel.add(passwordLabel);
                loginPanel.add(passwordField);
                loginPanel.add(loginButton);
                loginPanel.add(registerButton);

                mainFrame.add(loginPanel);
                mainFrame.add(statusLabel);

                mainFrame.setVisible(true);
            }
        });

        mainFrame.add(bookButton);
        mainFrame.add(flightInfoButton);
        mainFrame.add(bookingStatusButton);
        mainFrame.add(cancelButton);
        mainFrame.add(logoutButton); // Add logout button to the main menu

        mainFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            login(); // Proceed with user login
        } else if (e.getSource() == registerButton) {
            register();
        } else if (e.getSource() == bookButton) {
            bookTicket();
        } else if (e.getSource() == flightInfoButton) {
            flightInformation();
        } else if (e.getSource() == bookingStatusButton) {
            bookingStatus();
        } 
       
        else if (e.getSource() == cancelButton) {
            cancelBooking();
        }
    }


    private void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String q1 = "select * from customer where user_id='" + username + "'";
        try {
            Statement myc = myobj.createStatement();
            ResultSet vg = myc.executeQuery(q1);

            if (!vg.next()) {
                statusLabel.setText("Invalid USER ID");
            } else if (vg.getString(2).equals(password)) {
                statusLabel.setText("You have successfully logged in !!!");
                mainMenu(username);
            } else {
                statusLabel.setText("Invalid Password");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void register() {
        JFrame registerFrame = new JFrame("Register");
        registerFrame.setSize(400, 300);
        registerFrame.setLayout(new GridLayout(7, 2)); // Increased rows for error messages

        JLabel nameLabel = new JLabel("Full Name:");
        JTextField nameField = new JTextField();
        JLabel contactLabel = new JLabel("Contact No.:");
        JTextField contactField = new JTextField();
        JLabel emailLabel = new JLabel("Email ID:");
        JTextField emailField = new JTextField();
        JLabel userIdLabel = new JLabel("User ID:");
        JTextField userIdField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton registerUserButton = new JButton("Register");
        JLabel errorLabel = new JLabel(""); // Error message label

        registerUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String contact = contactField.getText();
                String email = emailField.getText();
                String userId = userIdField.getText();
                String password = new String(passwordField.getPassword());

                // Perform validation checks
                if (name.isEmpty() || contact.isEmpty() || email.isEmpty() || userId.isEmpty() || password.isEmpty()) {
                    errorLabel.setText("All fields are mandatory.");
                    return;
                }

                if (contact.length() != 10) {
                    errorLabel.setText("Contact number should be exactly 10 digits.");
                    return;
                }

                if (!email.contains("@")) {
                    errorLabel.setText("Invalid email format.");
                    return;
                }

                String q7 = "SELECT * FROM customer WHERE user_id='" + userId + "'";
                try {
                    Statement myc = myobj.createStatement();
                    ResultSet check = myc.executeQuery(q7);
                    if (!check.next()) {
                        String q6 = "INSERT INTO customer VALUES('" + userId + "','" + password + "','" + name + "','" + contact + "','" + email + "')";
                        myc.executeUpdate(q6);
                        statusLabel.setText("User Successfully Registered");
                        registerFrame.dispose();
                    } else if (check.getString(1).equals(userId)) {
                        errorLabel.setText("Entered User ID " + userId + " is Unavailable. Please use another User ID");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton backButton = createBackToLoginPageButton(registerFrame, mainFrame); // Create back button

        registerFrame.add(nameLabel);
        registerFrame.add(nameField);
        registerFrame.add(contactLabel);
        registerFrame.add(contactField);
        registerFrame.add(emailLabel);
        registerFrame.add(emailField);
        registerFrame.add(userIdLabel);
        registerFrame.add(userIdField);
        registerFrame.add(passwordLabel);
        registerFrame.add(passwordField);
        registerFrame.add(registerUserButton);
        registerFrame.add(backButton); // Add back option
        registerFrame.add(errorLabel); // Add error message label

        registerFrame.setVisible(true);
    }
	
    
    

    private void bookTicket() {
        JFrame bookFrame = new JFrame("Book a Ticket");
        bookFrame.setSize(400, 300);
        bookFrame.setLayout(new GridLayout(10, 2)); // Increased rows for back option

        JLabel nameLabel = new JLabel("Full Name:");
        nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        JLabel genderLabel = new JLabel("Gender:");
        String[] genders = {"Male", "Female", "Other"};
        JComboBox<String> genderComboBox = new JComboBox<>(genders);
        JLabel aadharLabel = new JLabel("Aadhar Card No.:");
        aadharField = new JTextField();
        JLabel destinationLabel = new JLabel("Destination:");
        String[] destinations = {"Dubai", "New Delhi", "Mumbai", "Kolkata", "Chennai"};
        JComboBox<String> destinationComboBox = new JComboBox<>(destinations);
        JLabel departureLabel = new JLabel("Departure:");
        String[] departures = {"Indore"};
        JComboBox<String> departureComboBox = new JComboBox<>(departures);
        JLabel dateLabel = new JLabel("Date of Travel (YYYY-MM-DD):");
        dateField = new JTextField();
        JLabel classLabel = new JLabel("Seating Class (Economy/Business):");
        String[] classes = {"Economy", "Business"};
        JComboBox<String> classComboBox = new JComboBox<>(classes);

        JButton bookButton = new JButton("Book");
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String gender = (String) genderComboBox.getSelectedItem();
                String aadhar = aadharField.getText();
                String destination = (String) destinationComboBox.getSelectedItem();
                String departure = (String) departureComboBox.getSelectedItem();
                String date = dateField.getText();
                String sClass = (String) classComboBox.getSelectedItem();

                // Perform validation checks
                if (aadhar.length() != 12) {
                    JOptionPane.showMessageDialog(bookFrame, "Aadhar number should be exactly 12 digits.");
                    return; // Prevent booking if validation fails
                }

                if (!isValidGender(gender)) {
                    JOptionPane.showMessageDialog(bookFrame, "Gender should be either 'Male' or 'Female'.");
                    return; // Prevent booking if validation fails
                }

                if (!isValidDate(date)) {
                    JOptionPane.showMessageDialog(bookFrame, "Please enter a valid date in the format YYYY-MM-DD.");
                    return; // Prevent booking if validation fails
                }

                if (date.compareTo(java.time.LocalDate.now().toString()) < 0) {
                    JOptionPane.showMessageDialog(bookFrame, "Booking date cannot be before the current date.");
                    return; // Prevent booking if validation fails
                }

                // Perform booking if all validations pass
                book(currentUser, name, age, gender, aadhar, destination, date, sClass);
            }
        });

        JButton backButton = createBackButton(bookFrame); // Create back button

        // Add components to the frame
        bookFrame.add(nameLabel);
        bookFrame.add(nameField);
        bookFrame.add(ageLabel);
        bookFrame.add(ageField);
        bookFrame.add(genderLabel);
        bookFrame.add(genderComboBox);
        bookFrame.add(aadharLabel);
        bookFrame.add(aadharField);
        bookFrame.add(destinationLabel);
        bookFrame.add(destinationComboBox);
        bookFrame.add(departureLabel);
        bookFrame.add(departureComboBox);
        bookFrame.add(dateLabel);
        bookFrame.add(dateField);
        bookFrame.add(classLabel);
        bookFrame.add(classComboBox);
        bookFrame.add(bookButton);
        bookFrame.add(backButton); // Add back option

        bookFrame.setVisible(true);
    }

    // Method to validate gender
    private boolean isValidGender(String gender) {
        return gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female");
    }

    // Method to validate date format
    private boolean isValidDate(String date) {
        try {
            java.time.LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private void book(String currentUser, String name, int age, String gender, String aadhar, String destination, String date, String sClass) {
        try {
            // Prepare the SQL query to insert booking details into the database
            String query = "INSERT INTO bookings (user_id, name, age, gender, aadhar, destination, date, seating_class) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            // Create a PreparedStatement to safely insert data into the query
            PreparedStatement preparedStatement = myobj.prepareStatement(query);

            // Set the parameters for the PreparedStatement
            preparedStatement.setString(1, currentUser);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, aadhar);
            preparedStatement.setString(6, destination);
            preparedStatement.setString(7, date);
            preparedStatement.setString(8, sClass);

            // Execute the query to insert the data into the database
            preparedStatement.executeUpdate();

            // Display a message indicating successful booking
            JOptionPane.showMessageDialog(mainFrame, "Booking successful!");

        } catch (SQLException e) {
            // Handle any errors that may occur during the database operation
            JOptionPane.showMessageDialog(mainFrame, "Error occurred while booking: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void flightInformation() {
        JFrame flightFrame = new JFrame("Flight Information");
        flightFrame.setSize(600, 400);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel destinationLabel = new JLabel("Destination:");
        String[] destinations = {"Dubai", "New Delhi", "Mumbai", "Kolkata", "Chennai"};
        JComboBox<String> destinationComboBox = new JComboBox<>(destinations);
        JButton searchButton = new JButton("Search");

        String[] columnNames = {"Flight No", "Departure", "Arrival", "Departure Time", "Arrival Time", "Fare"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String destination = (String) destinationComboBox.getSelectedItem();
                try {
                    Statement statement = myobj.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM flight WHERE Arvl='" + destination + "'");
                    model.setRowCount(0);
                    while (resultSet.next()) {
                        String[] rowData = {
                                resultSet.getString("F_No"),
                                resultSet.getString("Dprt"),
                                resultSet.getString("Arvl"),
                                resultSet.getString("Dprt_time"),
                                resultSet.getString("Arvl_Time"),
                                resultSet.getString("fare")
                        };
                        model.addRow(rowData);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(flightFrame, "Error fetching flight information.");
                }
            }
        });

        JButton backButton = createBackButton(flightFrame); // Create back button

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(destinationLabel);
        topPanel.add(destinationComboBox);
        topPanel.add(searchButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        flightFrame.add(panel);
        flightFrame.add(backButton, BorderLayout.SOUTH); // Add back button to frame

        flightFrame.setVisible(true);
    }


    private void bookingStatus() {
        JFrame bookingStatusFrame = new JFrame("Booking Status");
        bookingStatusFrame.setSize(1600, 400); // Increased width to accommodate wider columns
        bookingStatusFrame.setLayout(new BorderLayout());

        JLabel userIDLabel = new JLabel("User ID:");
        JTextField userIDField = new JTextField(15); // Increased field size

        JButton searchBookingStatusButton = new JButton("Search");

        // Table model for booking status
        DefaultTableModel bookingStatusModel = new DefaultTableModel();
        JTable bookingStatusTable = new JTable(bookingStatusModel);

        // Add columns to the table
        bookingStatusModel.addColumn("User ID");
        bookingStatusModel.addColumn("Name");
        bookingStatusModel.addColumn("Age");
        bookingStatusModel.addColumn("Gender");
        bookingStatusModel.addColumn("Aadhar Card No.");
        bookingStatusModel.addColumn("Departure"); // Added Departure column
        bookingStatusModel.addColumn("Destination");
        bookingStatusModel.addColumn("Date of Travel");
        bookingStatusModel.addColumn("Seating Class");
        bookingStatusModel.addColumn("Flight No.");
        bookingStatusModel.addColumn("Departure Time");
        bookingStatusModel.addColumn("Arrival Time");
        bookingStatusModel.addColumn("Fare");

        searchBookingStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = userIDField.getText();

                try {
                    Statement statement = myobj.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM bookings WHERE user_id='" + userID + "'");

                    // Clear previous data
                    bookingStatusModel.setRowCount(0);

                    while (resultSet.next()) {
                        String destination = resultSet.getString("destination");
                        String flightNo = "";
                        String departureTime = "";
                        String arrivalTime = "";
                        double fare = 0.0;

                        // Define flight details based on destination
                        switch (destination.toLowerCase()) {
                            case "dubai":
                                flightNo = "id95";
                                departureTime = "1400";
                                arrivalTime = "2220";
                                fare = 12000.00;
                                break;
                            case "chennai":
                                flightNo = "ic94";
                                departureTime = "0530";
                                arrivalTime = "0800";
                                fare = 2000.00;
                                break;
                            case "kolkata":
                                flightNo = "ik96";
                                departureTime = "0845";
                                arrivalTime = "1315";
                                fare = 2500.00;
                                break;
                            case "mumbai":
                                flightNo = "im97";
                                departureTime = "0300";
                                arrivalTime = "0430";
                                fare = 3500.00;
                                break;
                            case "new delhi":
                                flightNo = "in98";
                                departureTime = "0445";
                                arrivalTime = "0630";
                                fare = 4000.00;
                                break;
                            default:
                                // Handle unknown destination
                                break;
                        }

                        Object[] rowData = {
                            resultSet.getString("user_id"),
                            resultSet.getString("name"),
                            resultSet.getInt("age"),
                            resultSet.getString("gender"),
                            resultSet.getString("aadhar"),
                            "Indore", // Fixed departure city
                            destination,
                            resultSet.getString("date"),
                            resultSet.getString("seating_class"),
                            flightNo,
                            departureTime,
                            arrivalTime,
                            fare
                        };

                        bookingStatusModel.addRow(rowData);
                    }

                    resultSet.close(); // Close the bookings result set
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(bookingStatusFrame, "Error fetching booking information.");
                }
            }
        });

        JButton backButton = new JButton("Back"); // Create back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookingStatusFrame.dispose(); // Close the booking status frame
            }
        });

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(userIDLabel);
        topPanel.add(userIDField);
        topPanel.add(searchBookingStatusButton);

        JScrollPane scrollPane = new JScrollPane(bookingStatusTable);

        bookingStatusFrame.add(topPanel, BorderLayout.NORTH);
        bookingStatusFrame.add(scrollPane, BorderLayout.CENTER);
        bookingStatusFrame.add(backButton, BorderLayout.SOUTH); // Add back button to frame

        bookingStatusFrame.setVisible(true);
    }




    private void editProfile() {
        JFrame editProfileFrame = new JFrame("Edit Profile");
        editProfileFrame.setSize(400, 300);
        editProfileFrame.setLayout(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel("Full Name:");
        JTextField newNameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField newAgeField = new JTextField();
        JLabel genderLabel = new JLabel("Gender:");
        JTextField newGenderField = new JTextField();
        JLabel contactLabel = new JLabel("Contact No.:");
        JTextField newContactField = new JTextField();
        JLabel emailLabel = new JLabel("Email ID:");
        JTextField newEmailField = new JTextField();

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newName = newNameField.getText();
                int newAge = Integer.parseInt(newAgeField.getText());
                String newGender = newGenderField.getText();
                String newContact = newContactField.getText();
                String newEmail = newEmailField.getText();

                try {
                    String updateQuery = "UPDATE customer SET name=?, age=?, gender=?, contact=?, email=? WHERE user_id=?";
                    PreparedStatement preparedStatement = myobj.prepareStatement(updateQuery);
                    preparedStatement.setString(1, newName);
                    preparedStatement.setInt(2, newAge);
                    preparedStatement.setString(3, newGender);
                    preparedStatement.setString(4, newContact);
                    preparedStatement.setString(5, newEmail);
                    preparedStatement.setString(6, currentUser);
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(editProfileFrame, "Profile updated successfully!");
                    editProfileFrame.dispose();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(editProfileFrame, "Error updating profile: " + ex.getMessage());
                }
            }
        });
        
        JButton backButton = createBackButton(editProfileFrame); // Create back button


        editProfileFrame.add(nameLabel);
        editProfileFrame.add(newNameField);
        editProfileFrame.add(ageLabel);
        editProfileFrame.add(newAgeField);
        editProfileFrame.add(genderLabel);
        editProfileFrame.add(newGenderField);
        editProfileFrame.add(contactLabel);
        editProfileFrame.add(newContactField);
        editProfileFrame.add(emailLabel);
        editProfileFrame.add(newEmailField);
        editProfileFrame.add(updateButton);
        editProfileFrame.add(backButton); // Add back button to frame

        editProfileFrame.setVisible(true);
    }

    private void cancelBooking() {
        JFrame cancelFrame = new JFrame("Cancel Booking");
        cancelFrame.setSize(1000, 400);
        cancelFrame.setLayout(new BorderLayout());

        JLabel userIDLabel = new JLabel("User ID:");
        JTextField userIDField = new JTextField(15);
        JButton searchBookingButton = new JButton("Search");

        // Table model for booking status
        DefaultTableModel bookingStatusModel = new DefaultTableModel() {
            // Override the getColumnClass method to specify column class
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class; // First column is Boolean (for radio buttons)
                }
                return super.getColumnClass(columnIndex);
            }

            // Override the isCellEditable method to make cells editable only for the first column
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0; // Only the first column (radio buttons) is editable
            }
        };
        JTable bookingStatusTable = new JTable(bookingStatusModel);

        // Add columns to the table
        bookingStatusModel.addColumn("Select");
        bookingStatusModel.addColumn("User ID");
        bookingStatusModel.addColumn("Name");
        bookingStatusModel.addColumn("Age");
        bookingStatusModel.addColumn("Gender");
        bookingStatusModel.addColumn("Aadhar Card No.");
        bookingStatusModel.addColumn("Destination");
        bookingStatusModel.addColumn("Date of Travel");
        bookingStatusModel.addColumn("Seating Class");

        searchBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = userIDField.getText();

                try {
                    Statement statement = myobj.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM bookings WHERE user_id='" + userID + "'");

                    // Clear previous data
                    bookingStatusModel.setRowCount(0);

                    while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        int age = resultSet.getInt("age");
                        String gender = resultSet.getString("gender");
                        String aadhar = resultSet.getString("aadhar");
                        String destination = resultSet.getString("destination");
                        String date = resultSet.getString("date");
                        String sClass = resultSet.getString("seating_class");

                        Object[] rowData = {
                            false, // Initialize all radio buttons as unchecked
                            userID,
                            name,
                            age,
                            gender,
                            aadhar,
                            destination,
                            date,
                            sClass
                        };

                        bookingStatusModel.addRow(rowData);
                    }

                    resultSet.close(); // Close the bookings result set
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(cancelFrame, "Error fetching booking information.");
                }
            }
        });

        JButton cancelBookingButton = new JButton("Cancel Booking");
        cancelBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Iterate through the table to find selected rows
                for (int i = 0; i < bookingStatusModel.getRowCount(); i++) {
                    Boolean isSelected = (Boolean) bookingStatusModel.getValueAt(i, 0);
                    if (isSelected != null && isSelected) {
                        String userID = (String) bookingStatusModel.getValueAt(i, 1);
                        try {
                            String cancelQuery = "DELETE FROM bookings WHERE user_id=?";
                            PreparedStatement preparedStatement = myobj.prepareStatement(cancelQuery);
                            preparedStatement.setString(1, userID);
                            int rowsAffected = preparedStatement.executeUpdate();
                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(cancelFrame, "Booking for User ID: " + userID + " cancelled successfully!");
                                // Refresh the table after cancellation
                                searchBookingButton.doClick(); // Simulate click to refresh the table
                            } else {
                                JOptionPane.showMessageDialog(cancelFrame, "No bookings found for User ID: " + userID);
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(cancelFrame, "Error cancelling booking: " + ex.getMessage());
                        }
                    }
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelFrame.dispose();
            }
        });

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(userIDLabel);
        topPanel.add(userIDField);
        topPanel.add(searchBookingButton);

        JScrollPane scrollPane = new JScrollPane(bookingStatusTable);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(cancelBookingButton);
        buttonPanel.add(backButton); // Add the back button to the button panel

        // Add the top panel, scroll pane, and button panel to the frame
        cancelFrame.add(topPanel, BorderLayout.NORTH);
        cancelFrame.add(scrollPane, BorderLayout.CENTER);
        cancelFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        cancelFrame.setVisible(true);
    }









}