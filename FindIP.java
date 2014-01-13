
/**
 * @author Lee
 * Finds a specific IP address from the output of a cmd program.
 */
public class FindIP
{
	// Instance fields
	String target;
	String output;
	
	// Constructor
	public FindIP(String para_target, String para_output)
	{
		target = para_target;
		output = para_output;
	}
	
	// Methods
	public boolean isThere()
	{
		boolean result = false;
		
		if(output.contains(target))
		{
			result = true;
			System.out.println("It is there!");
		}
		
		return result;
	}
}
