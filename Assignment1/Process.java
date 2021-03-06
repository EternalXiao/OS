package assignment1;

public class Process implements Comparable<Process> {

	private int processID, arrivalTime;
	private int burstTime;
	private int priority;
	private int waitingTime;
	private int turnaroundTime;
	private int burstRemaining;
	private int preemptedTime;
	private int preempts;
	private boolean isArrival;

	public Process(int pID, int bT, int aT, int prio) {
		processID = pID;
		burstTime = bT;
		arrivalTime = aT;
		priority = prio;
		burstRemaining = bT;
		waitingTime = 0;
		preemptedTime = aT;
		preempts = 0;
		isArrival = false;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getProcessID() {
		return processID;
	}

	public void setProcessID(int processID) {
		this.processID = processID;
	}

	public int getBurstTime() {
		return burstTime;
	}

	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}
	public void incrementWaitingTime() {
		this.waitingTime++;
	}

	public int getTurnaroundTime() {
		return turnaroundTime;
	}

	public void setTurnaroundTime(int turnaroundTime) {
		this.turnaroundTime = turnaroundTime;
	}
	public void incrementTurnaroundTime() {
		this.turnaroundTime++;
	}
	public int getPreemptedTime() {
		return preemptedTime;
	}

	public void setPreemptedTime(int preemptedTime) {
		this.preemptedTime = preemptedTime;
	}

	public int getBurstRemaining() {
		return burstRemaining;
	}
	public void setBurstRemaining(int bR) {
		this.burstRemaining = bR;
	}

	public void reduceBurstRemainingTime() {
		burstRemaining--;
	}

	public int getPreempts() {
		return preempts;
	}

	public void setPreempts(int preempts) {
		this.preempts = preempts;
	}

	public void incrementPreempts() {
		preempts++;

	}
	public boolean getIsArrival() {
		return this.isArrival;
	}
	public void setIsArrival(boolean isArrival) {
		this.isArrival= isArrival;
	}

	public String toString() {
		return "Proccess: " + processID + ", Burst Time:  " + burstTime + ", Arriv. T: " + arrivalTime + ", Priority: "
				+ priority + "\n";
	}

	@Override
	public int compareTo(Process arg) {
		if (this.getBurstRemaining() > arg.getBurstRemaining())
			return 1;
		else if (this.getBurstRemaining() == arg.getBurstRemaining()) {
			if (this.getProcessID() > arg.getProcessID())
				return 1;
			else if (this.getProcessID() == arg.getProcessID())
				return 0;
			else
				return -1;
		} else
			return -1;
	}

}
