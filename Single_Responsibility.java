
/* 
______________________________________________________________________________________________________________________________________________________
                                    Title : Demonstrating the Single Responsibility Principle (SRP) 
                                                    Student : Md. Farid Hossen Rehad
                                                     Computer Science & Engineering 
                                                             Discipline
                                                        From Khulna University 
_______________________________________________________________________________________________________________________________________________________

*/


import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents a Logger responsible for logging messages to a file.
 */
class Logger {
    private String logFilePath;

    /**
     * Constructs a Logger with the specified log file path.
     *
     * @param logFilePath The path to the log file.
     */
    public Logger(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    /**
     * Logs a message to the log file.
     *
     * @param message The message to log.
     */
    public void log(String message) {
        try (FileWriter writer = new FileWriter(logFilePath, true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }
}

/**
 * Represents a data processor responsible for processing data.
 */
class DataProcessor {
    /**
     * Processes the provided data.
     *
     * @param data The data to be processed.
     */
    public void processData(String data) {
        // Placeholder method for data processing
        System.out.println("Processing data: " + data);
    }
}

/**
 * This class demonstrates the usage of Logger and DataProcessor classes.
 */
class SRPExample {
    public static void main(String[] args) {
        // Create an instance of Logger
        Logger logger = new Logger("log.txt");

        // Log a message using Logger
        logger.log("Application started");

        // Create an instance of DataProcessor
        DataProcessor dataProcessor = new DataProcessor();

        // Process data using DataProcessor
        dataProcessor.processData("Sample data");

        // Log another message using Logger
        logger.log("Data processing completed");
    }
}

/**
 * In the above program, the Logger class has a single responsibility of logging messages to a file.
 * The SRPExample class demonstrates the usage of Logger and DataProcessor classes without involving
 * in the logging or data processing processes themselves, thus adhering to the Single Responsibility
 * Principle (SRP).
 */

