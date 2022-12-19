package ss4;

public class StopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    void start() {
        this.setStartTime(System.currentTimeMillis());
    }

    void stop() {
        this.setEndTime(System.currentTimeMillis());
    }

    long getElapsedTime() {
        return this.getEndTime() - this.getStartTime();
    }


    public static void main(String[] args) {
        StopWatch ojb = new StopWatch();
        ojb.start();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ojb.stop();
        System.out.println("The Elapsed time is: " + ojb.getElapsedTime() + " milisec");
    }
}
