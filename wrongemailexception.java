
public class wrongemailexception extends Exception
{
    public wrongemailexception()
    {
        super("Wrong Email Entered");
    }
    public wrongemailexception(String m)
    {
        super(m);
    }
}
