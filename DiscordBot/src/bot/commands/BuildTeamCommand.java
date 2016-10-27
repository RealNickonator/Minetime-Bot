package bot.commands;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import bot.Command;

public class BuildTeamCommand implements Command
{
	private final String HELP_ = "USAGE: ~!btapply";
	

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) 
	{
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) 
	{
		event.getMessage().deleteMessage();
		event.getAuthor().getPrivateChannel().sendMessage("https://www.minetime.com/threads/minetime-build-team.30589/");
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