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
		event.getAuthor().getPrivateChannel().sendMessage("```Markdown\n#INFORMATION:\n\n[Developer](RealNickonator)\n\n[Build](1.0.7)\n\n[Source](https://github.com/RealNickonator/Minetime-Bot)\n\n[Contact](nick@dreamitive.org)\n\nPS: Styles is God ```");
		event.getAuthor().getPrivateChannel().sendMessage("Source: https://github.com/RealNickonator/Minetime-Bot");
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