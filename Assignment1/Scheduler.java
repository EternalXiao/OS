package assignment1;

import java.util.LinkedList;

public abstract class Scheduler {
	
	/**
	 * Relevant data structure and variables common to all schedulers.
	 */
	int n;
	protected Process[] p;
	protected LinkedList<Process> readyQueue, terminatedProcesses;
	protected Process activeProcess;
	
	/**
	 * Each class extending Scheduler should make a call to this super constructor from their own constructors.
	 * @param pArray
	 */
	public Scheduler(Process [] pArray) {
		readyQueue = new LinkedList<Process>();
		terminatedProcesses = new LinkedList<Process>();
		p = pArray;
		n = p.length;
	}
	
	/**
	 * This method is specific to a given scheduler.
	 * (Hint: each scheduler will have a slightly different way of running)
	 */
	abstract void runScheduler();
	
	/**
	 * This method is specific to a given scheduler.
	 * (Hint: this has common elements, but will differ slightly for some scheduling algorithms)
	 */
	abstract void checkForArrivingProcesses(int t);
	
	/**
	 * Calculates the average waiting time of all processes
	 * (Hint: this is common to all schedulers)
	 * @return
	 */
	public double calculateAverageWaitTime() {
		double avgWT = 0.0;
		for(Process process:this.p) {
			avgWT +=process.getWaitingTime();
		}
		avgWT/=n;
		return avgWT;
	}
	
	/**
	 * Calculates the average turnaround time of all processes
	 * (Hint: this is common to all schedulers)
	 * @return
	 */
	public double calculateAverageTurnaroundTime() {
		double avgTT = 0.0;
		for(Process process:this.p) {
			avgTT += process.getTurnaroundTime();
		}
		avgTT /=n;
		return avgTT;
	}
	
	/**
	 * Return total run time of all processes
	 * @return
	 */
	public int getRuntime() {
		int sum=0;
		for(Process process:this.p) {
			sum += process.getBurstTime();
		}
		return sum;
	}
	
	/**
	 * Calculates how busy a CPU is over a given time period (efficiency)
	 * @param minutes
	 * @return
	 */
	public double getProcessorUsage(double minutes) {
		return this.getRuntime()/(minutes*60*1000);
	}
	
	
	
}
