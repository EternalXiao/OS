package assignment1;

public class RR extends Scheduler{

	public RR(Process[] pArray) {
		super(pArray);
	}

	@Override
	void runScheduler() {
		int timeQuantum = 20;
		int duration = 0;
		int currentTime = 0;
		this.readyQueue.add(p[0]);
		p[0].setIsArrival(true);
		while(this.readyQueue.size()!=0 ) {
			this.activeProcess = this.readyQueue.removeFirst();
			if(this.activeProcess.getBurstRemaining()<timeQuantum) {
				duration =this.activeProcess.getBurstRemaining();
				this.activeProcess.setBurstRemaining(0);
				this.activeProcess.setTurnaroundTime(this.activeProcess.getTurnaroundTime()+duration);
				this.terminatedProcesses.add(this.activeProcess);
				for(Process process:this.readyQueue) {
					process.setWaitingTime(process.getWaitingTime()+duration);
					process.setTurnaroundTime(process.getTurnaroundTime()+duration);
				}
				currentTime += duration;
				for(Process process: this.p) {
					if(process.getArrivalTime()<=currentTime && !process.getIsArrival()) {
						this.readyQueue.add(process);
						process.setIsArrival(true);
						process.setWaitingTime(currentTime-process.getArrivalTime());
						process.setTurnaroundTime(process.getWaitingTime());
					}
				}
			}
			else {
				this.activeProcess.setBurstRemaining(this.activeProcess.getBurstRemaining()-timeQuantum);
				this.activeProcess.setTurnaroundTime(this.activeProcess.getTurnaroundTime()+timeQuantum);
				for(Process process:this.readyQueue) {
					process.setWaitingTime(process.getWaitingTime()+timeQuantum);
					process.setTurnaroundTime(process.getTurnaroundTime()+timeQuantum);
				}
				
				currentTime += timeQuantum;
				for(Process process: this.p) {
					if(process.getArrivalTime()<=currentTime && !process.getIsArrival()) {
						this.readyQueue.add(process);
						process.setIsArrival(true);
						process.setWaitingTime(currentTime-process.getArrivalTime());
						process.setTurnaroundTime(process.getWaitingTime());
					}
				}
				this.readyQueue.add(this.activeProcess);
			}
		}
	}

	@Override
	void checkForArrivingProcesses(int t) {
		// TODO Auto-generated method stub
		
	}

}
