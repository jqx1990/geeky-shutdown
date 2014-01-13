import java.io.IOException;


/**
 * @author Lee
 * This program shutdowns a PC immediately. It only works on Windows.
 */
public class ShutdownPC 
{
	// Instance fields
	Process cmd_shutdownPC;
	long evacuation_time;
	
	// Constuctor
	public ShutdownPC(long para_evacuation_time)
	{
		evacuation_time = para_evacuation_time; // in s
	}
	
	// Methods
	public void shutdown()
	{
		try 
		{
			try 
			{
				System.out.println("This computer will switch off in " + evacuation_time/1000 + "s minutes!!!");
				Thread.sleep(evacuation_time);
				cmd_shutdownPC = Runtime.getRuntime().exec("shutdown -s -t 0");
			}
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
