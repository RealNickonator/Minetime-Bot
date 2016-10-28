package bot.commands;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import bot.Command;

public class MuteChatCommand implements Command
{
	private final String HELP_ = "USAGE: ~!togglemute";
	public static boolean isMuted = false;

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) 
	{
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) 
	{
		isMuted = !isMuted;
		event.getMessage().deleteMessage();
		
		event.getTextChannel().sendMessage("```CHAT MUTE: " + ((isMuted) ? "ENABLED```" : "DISABLED```") );
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