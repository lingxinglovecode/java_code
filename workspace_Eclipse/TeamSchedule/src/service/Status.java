package service;

public class Status {
    private final String NAME;
    private Status(String name) {
        this.NAME = name;
    }
    public static final Status FREE = new Status("FREE");
    public static final Status VOCATION = new Status("VOCATION");
    public static final Status BUSY = new Status("BUSY");
    public String getNAME() {
        return NAME;
    }
    
    public static Status getFree() {
		return FREE;
	}

	public static Status getVocation() {
		return VOCATION;
	}

	public static Status getBusy() {
		return BUSY;
	}

	@Override
    public String toString() {
        return NAME;
    }
} 