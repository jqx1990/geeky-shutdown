
/**
 * @author Lee
 * This program is used to pick up a trigger (e.g. CheckIP) and implement another action (e.g. Shutdown PC)
 * based on certain condition (e.g. There exists an IP 192.168.1.13).
 */
public class ControlPanel extends Thread
{
	// Instance fields
	long time_delay; // How long do you want to wait until the action executes.
	String procedure; // The name of the procedure one wants to perform.
	long time_gap; // How often do you want to check the condition (in seconds).
	String target; // The word you want to search. If certain procedure does not need it, override the constructor.
	long evacuation_time; // Time before shutdown when shutdown operation has been determined.
	
	boolean hasExecuted; // Indicates if this.execution has run.
	boolean shutdownThisControlPanel; // A flag used to safely stop this thread.
	
	ShutdownByConnections instance_shutdown_by_connections; // Note, if you want to add more condition to this
	// program, you need to make sure that the condition is declared here.
	
	// Constructors
	public ControlPanel(String para_procedure, String para_target, long para_time_gap, long para_time_delay, long para_evacuation_time)
	{
		procedure = para_procedure;
		target = para_target;
		time_delay = para_time_delay;
		evacuation_time = para_evacuation_time;
		time_gap = para_time_gap;
		
		hasExecuted = false;
		shutdownThisControlPanel = false;
	}
	
	// Methods
	// Runs different sub-program by the name of procedure specified.
	public void execution()
	{
		if(procedure.equals("Specific IP connected"))
		{
			instance_shutdown_by_connections = new ShutdownByConnections(target, time_gap, time_delay, evacuation_time);
			instance_shutdown_by_connections.start();
			//System.out.println(instance_shutdown_by_connections);
		}
		
	}

	@Override
	public void run()
	{
		while(shutdownThisControlPanel == false)
		{
			if(!hasExecuted)
			{
				this.execution();
				hasExecuted = true;
			}
		}
	}
	
	public void stopThread()
	{
		if(instance_shutdown_by_connections != null)
		{
			instance_shutdown_by_connections.stopThisThread();
		}
		shutdownThisControlPanel = true;
		System.out.println("The task has been stopped.");
	}
}
