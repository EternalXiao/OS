package assignment1;

import java.util.Collections;

public class SJF extends Scheduler{

	public SJF(Process[] pArray) {
		super(pArray);
	}

	@Override
	void runScheduler() {
		int totalTime = this.getRuntime();
		Process currentProcess = p[0];
		for(int i=0;i<totalTime;i++) {
			if(currentProcess.getBurstRemaining()==0) {
				this.terminatedProcesses.add(currentProcess);
				currentProcess = this.readyQueue.removeFirst();
			}
			if(i<=5) {
				for(Process process:this.p) {
					if(process.getArrivalTime()==i) {
						this.readyQueue.add(process);
					}
				}
				Collections.sort(this.readyQueue);
				if(i==0) {
					currentProcess = this.readyQueue.removeFirst();
				}
				else if(this.readyQueue.size()!=0 && currentProcess.getBurstRemaining()>this.readyQueue.getFirst().getBurstRemaining()) {
					this.readyQueue.addLast(currentProcess);
					currentProcess = this.readyQueue.removeFirst();
					Collections.sort(this.readyQueue);
				}
				currentProcess.reduceBurstRemainingTime();
				currentProcess.incrementTurnaroundTime();
				for(Process p:this.readyQueue) {
					p.incrementTurnaroundTime();
					p.incrementWaitingTime();
				}
			}
			else {
				currentProcess.reduceBurstRemainingTime();
				currentProcess.incrementTurnaroundTime();
				for(Process p:this.readyQueue) {
					p.incrementTurnaroundTime();
					p.incrementWaitingTime();
				}
			}
		}
	}

	@Override
	void checkForArrivingProcesses(int t) {
		// TODO Auto-generated method stub
		
	}

}
