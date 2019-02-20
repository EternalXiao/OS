package assignment1;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class FCFS extends Scheduler {

	public FCFS(Process[] pArray) {
		super(pArray);
	}

	@Override
	void runScheduler() {
		for(Process process:this.p) {
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
				process.setTurnaroundTime(process.getWaitingTime()+process.getBurstTime());
			}
			this.terminatedProcesses.add(process);
		}
	}

	@Override
	void checkForArrivingProcesses(int t) {
		System.out.println(this.terminatedProcesses.get(t-1));

	}

}
