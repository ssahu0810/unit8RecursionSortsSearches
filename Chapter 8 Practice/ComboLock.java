public class ComboLock
{
    private boolean isOpen = false;
    private int secret1,secret2,secret3;
    private int count = 0;
    private int spins = 0;
    private boolean spin1 = false;
    private boolean spin2 = false;
    private int lastTick;
    public ComboLock(int secret1, int secret2,int secret3)
    {
        this.secret1 = secret1;
        this.secret2= secret2;
        this.secret3 = secret3;
    }
    
    public void reset()
    {
        this.count = 0;
        this.spins = 0;
        spin1= false;
        spin2= false;
    }
    
    public void turnLeft (int ticks)
    {
        this.count += ticks;
        count = count - ((count/40)*40);
        spins++;
        if (spins  == 2 && count == this.secret2 && ticks>= 40&& ticks<80 )
        {
            spin2 = true;
        }
    }
    
    public void turnRight (int ticks)
    {
        this.count -= ticks;
        count = count - ((count/40)*40) + 40;
        spins++;
        if (spins  == 1 && count == secret1)
        {
            spin1 = true;
        }
        else if (spins== 3){
            lastTick=ticks;
        }
    }
    
    public boolean open()
    {
        if (count == secret3 && lastTick<=40 && spin1 && spin2)
        {
            return true;
        }
        else 
        {
            return false;
        }
        
    }
}