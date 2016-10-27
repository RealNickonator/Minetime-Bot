package bot.commands;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import bot.Command;

public class RulesCommand implements Command
{
	private final String HELP_ = "USAGE: ~!rules";
	

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) 
	{
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) 
	{
		event.getMessage().deleteMessage();
		event.getAuthor().getPrivateChannel().sendMessage("RULES: https://www.minetime.com/threads/minetime-rules.22180/\nTERMS: https://www.minetime.com/help/terms");
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
