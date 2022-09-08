package behavioral._18chainofresponsibility;

class ConsoleBasedLogger extends Logger {
    public ConsoleBasedLogger(int levels) {
        this.levels = levels;
    }

    @Override
    protected void displayLogInfo(String msg) {
        System.out.println("CONSOLE LOGGER INFO: " + msg);
    }
}

class ErrorBasedLogger extends Logger {
    public ErrorBasedLogger(int levels) {
        this.levels = levels;
    }

    @Override
    protected void displayLogInfo(String msg) {
        System.out.println("ERROR LOGGER INFO: " + msg);
    }
}// End of the ErrorBasedLogger class.

class DebugBasedLogger extends Logger {
    public DebugBasedLogger(int levels) {
        this.levels = levels;
    }

    @Override
    protected void displayLogInfo(String msg) {
        System.out.println("DEBUG LOGGER INFO: " + msg);
    }
}// End of the DebugBasedLogger class.
