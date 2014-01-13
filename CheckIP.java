import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * @author Lee
 * This program is an experimental prototype to prove that Java-based program is possible to shutdown
 *  a PC on a condition that weather a specific computer has connection to the to-be-shutdown PC.
 *  This part only deals with checking a specific IP address.
 */
public class CheckIP 
{
	// Instance fields
	String cmd_check_ip;
	StringBuilder cmd_output;
	String temp_string;
	
	Process check_ip;
	
	// Constructor
	public CheckIP()
	{
		cmd_check_ip = "netstat -n";
		cmd_output = new StringBuilder();
		try 
		{
			check_ip = Runtime.getRuntime().exec(cmd_check_ip);
			BufferedReader output = new BufferedReader(new InputStreamReader(check_ip.getInputStream()));
			while ((temp_string = output.readLine()) != null) 
			{
	            cmd_output.append(temp_string + "\n");
	        }
			output.close();
			check_ip.destroy();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Methods
	public String getCmdOutput()
	{
		String result;
		result = cmd_output.toString();
		return result;
	}
	
	// Test it.
	public static void main(String [ ] args)
	{
		CheckIP instance_shutdown_by_connections = new CheckIP();
		System.out.println(instance_shutdown_by_connections.getCmdOutput());
	}
}