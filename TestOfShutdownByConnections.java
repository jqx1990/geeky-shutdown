
public class TestOfShutdownByConnections 
{
	public static void main(String [ ] args)
	{
		ControlPanel control = new ControlPanel("Specific IP connected", "192.168.1.13", 10, 300, 2);
		control.execution();
	}
}
