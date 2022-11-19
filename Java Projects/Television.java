// The purpose of this class is to model a television
// David Weng 4/7/2020

public class Television
{
   // Defining attributes
    	 private String MANUFACTURER; // The television manufacturer
    	 private int SCREEN_SIZE;     // The television screen
    	 private boolean powerOn;     // The television power on/off
    	 private int channel;         // The television channel
    	 private int volume;          // The television volume


		// Constructor method assigns values to the corresponding fields
   		public Television(String brand, int size)
   {
   
         MANUFACTURER = brand;
         SCREEN_SIZE = size;
   		powerOn = false;
   		volume = 20;
   		channel= 2;

    }
	// Methods
	// Sets a value for channel
	public void setChannel(int c)
	{
		channel = c;
	}
	// Gets channnel and returns it
	public int getChannel()
	{
		return channel;
	}
	// Sets a value for volume
	public void setVolume(int v)
	{
		volume = v;
	}
	// Gets volume and returns it
	public int getVolume()
	{
		return volume;
	}
	// Gets manufacturer and returns it
	public String getManufacturer()
	{
			return MANUFACTURER;
	}
	// Gets screen size and return it
	public int getScreenSize()
	{
		return SCREEN_SIZE;
	}
	// Increasing volume by one
	public void increaseVolume()
	{
			volume+=1;
	}
	// Decreasing volume by one
	public void decreaseVolume()
	{
		volume-=1;
	}
	// Turns power on into false
	public void power()
	{
		powerOn = !powerOn;
	}

}