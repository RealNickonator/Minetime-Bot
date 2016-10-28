package bot.commands;

import bot.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

public class BleachCommand implements Command
{
	private final String HELP_ = "USAGE: ~!bleach";
	

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) 
	{
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) 
	{
		event.getTextChannel().sendMessage("http://33.media.tumblr.com/65613b4b9ea80bbf1f647c21f545dd6f/tumblr_mj4n65r2KY1rccoi6o1_500.gif");
	}

	@Override
	public String help() 
	{
		return HELP_;
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) 
	{
		return;
	}
	
	
}
