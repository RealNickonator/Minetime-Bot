package bot.commands;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import bot.Command;

public class PingCommand implements Command
{
	private final String HELP_ = "USAGE: ~!ping";
	

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) 
	{
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) 
	{
		event.getTextChannel().sendMessage("PONG");
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
