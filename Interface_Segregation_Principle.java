
/* 
______________________________________________________________________________________________________________________________________________________
                                    Title : Demonstrating the Single Responsibility Principle (SRP) 
                                                    Student : Md. Farid Hossen Rehad
                                                     Computer Science & Engineering 
                                                             Discipline
                                                        From Khulna University 
_______________________________________________________________________________________________________________________________________________________
*/

/**
 * Represents a device that can play media.
 */
interface MediaDevice {
    /**
     * Play media.
     */
    void play();

    /**
     * Pause media.
     */
    void pause();

    /**
     * Stop media.
     */
    void stop();
}

/**
 * Represents a device that can stream media.
 */
interface StreamingDevice {
    /**
     * Stream media.
     */
    void stream();

    /**
     * Pause streaming.
     */
    void pauseStreaming();

    /**
     * Stop streaming.
     */
    void stopStreaming();
}

/**
 * Represents a smart TV that can play and stream media.
 */
class SmartTV implements MediaDevice, StreamingDevice {
    @Override
    public void play() {
        System.out.println("Playing media on Smart TV");
    }

    @Override
    public void pause() {
        System.out.println("Pausing media on Smart TV");
    }

    @Override
    public void stop() {
        System.out.println("Stopping media on Smart TV");
    }

    @Override
    public void stream() {
        System.out.println("Streaming media on Smart TV");
    }

    @Override
    public void pauseStreaming() {
        System.out.println("Pausing streaming on Smart TV");
    }

    @Override
    public void stopStreaming() {
        System.out.println("Stopping streaming on Smart TV");
    }
}

/**
 * Demonstrates the usage of a Smart TV that can play and stream media.
 */
class ISPExample {
    public static void main(String[] args) {
        // Create a Smart TV and test its media and streaming functionalities
        SmartTV smartTV = new SmartTV();
        smartTV.play();
        smartTV.pause();
        smartTV.stop();
        smartTV.stream();
        smartTV.pauseStreaming();
        smartTV.stopStreaming();
    }
}

/**
 * In the above program, the MediaDevice interface represents the responsibility
 * of playing, pausing, and stopping media, while the StreamingDevice interface
 * represents the responsibility of streaming, pausing streaming, and stopping streaming.
 * The SmartTV class implements both interfaces, adhering to the Interface Segregation
 * Principle (ISP) by implementing only the methods relevant to its specific responsibilities.
 */
