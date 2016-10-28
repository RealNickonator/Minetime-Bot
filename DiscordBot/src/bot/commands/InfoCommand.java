package bot.commands;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import bot.Command;

public class InfoCommand implements Command
{
	private final String HELP_ = "USAGE: ~!info";
	

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) 
	{
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) 
	{
		event.getMessage().deleteMessage();
		event.getAuthor().getPrivateChannel().sendMessage("```#INFORMATION:\n\nDeveloper: RealNickonator\n\nBuild: 1.0.3\n\nSource: https://github.com/RealNickonator/Minetime-Bot\n\nContact: nick@dreamitive.org\n\nPS: Styles is God ```");
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