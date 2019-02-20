package assignment1;

import java.util.Collections;

public class Priority extends Scheduler {

	public Priority(Process[] pArray) {
		super(pArray);
	}

	@Override
	void runScheduler() {
		for (Process process : this.p) {
			this.readyQueue.add(process);
		}
		Collections.sort(this.readyQueue);
		while (this.readyQueue.size() != 0) {
			Process process = this.readyQueue.removeFirst();
			if (this.terminatedProcesses.size() == 0) {
				process.setWaitingTime(0);
				process.setTurnaroundTime(process.getBurstTime());
			} else {
				process.setWaitingTime(this.terminatedProcesses.getLast().getTurnaroundTime()
						+ this.terminatedProcesses.getLast().getArrivalTime() - process.getArrivalTime());
				process.setTurnaroundTime(process.getWaitingTime() + process.getBurstTime());
			}
			this.terminatedProcesses.add(process);
		}
	}

	@Override
	void checkForArrivingProcesses(int t) {
		// TODO Auto-generated method stub

	}

}
