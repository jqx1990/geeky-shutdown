
/**
 * @author Lee
 * This program runs to check if a specific connection is disconnected every few minutes. If so, 
 * the program will perform shutdown operation after a while.
 */
public class ShutdownByConnections extends Thread
{
	// Instance fields
	long time_delay; // How long a while do you want to wait until the action executes.
	long time_gap; // How often do you want to check the condition (in seconds).
	String target; // The word you want to search. If certain procedure does not need it, override the constructor.
	boolean ip_is_found_once;
	long time_of_execution_standBy;
	long time_to_reduce;
	long evacuation_time;
	
	CheckIP instance_check_ip;
	FindIP instance_find_ip;
	ShutdownPC instance_shutdown_pc;
	
	boolean shutdownThisThread; // A flag to indicate whether this thread needs to be closed.
	
	// Constructor
	public ShutdownByConnections(String para_target, long para_time_gap, long para_time_delay, long para_evacuation_time)
	{
		time_delay = 1000 * para_time_delay; // This is used as a backup of time_to_reduce.
		time_to_reduce = time_delay;
		time_gap = 1000 * para_time_gap;
		evacuation_time = 1000 * para_evacuation_time;
		target = para_target;
		ip_is_found_once = false;
		
		shutdownThisThread = false;
	}
	
	// Methods
	public void run() // For its thread extension.
	{
		this.standBy();
	}
	
	public void stopThisThread() // Works with the flag to safely stop the thread.
	{
		shutdownThisThread = true;
	}
	
	/**
	 *  Performs all functions of this program (shutdown by connections).
	 */
	public void standBy()
	{
		while(!shutdownThisThread)
		{
			try 
			{
				instance_check_ip = new CheckIP();
				instance_find_ip = new FindIP(target, instance_check_ip.getCmdOutput());
				instance_shutdown_pc = new ShutdownPC(evacuation_time);
				
				if(instance_find_ip.isThere() && ip_is_found_once == false)
				{
					ip_is_found_once = true;
					System.out.println("First time to find: " + target);
				}
				
				if(instance_find_ip.isThere() == false && ip_is_found_once == true)
				{
					System.out.println("Connection to " + target + " is lost.");
					time_to_reduce = time_to_reduce - 10*1000;
					System.out.println("You have " + time_to_reduce / 1000 + "s to reconnect.");
				}
				
				if(instance_find_ip.isThere() == true && ip_is_found_once == true)
				{
					time_to_reduce = time_delay;
					System.out.println("Found target again, welcome back.");
				}
				
				if(instance_find_ip.isThere() == false && time_to_reduce < 0)
				{
					instance_shutdown_pc.shutdown();
					System.out.println("I am shutting down in " + evacuation_time/1000 + " s.");
				}
				
				System.out.println("The program will wake up in " + time_gap/1000 + "s.");
				Thread.sleep(time_gap);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
