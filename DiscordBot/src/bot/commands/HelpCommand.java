package bot.commands;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import bot.Command;

public class HelpCommand implements Command
{
	private final String HELP_ = "USAGE: ~!help";
	

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) 
	{
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) 
	{
		event.getMessage().deleteMessage();
		event.getAuthor().getPrivateChannel().sendMessage(
				"===================== HELP ======================\n\n"
			+	"~!help : The Help Command\n\n" 
			+	"~!rules : Displays link to Rules & Terms\n\n"
			+	"~!staff : Displays link to staff member list\n\n"
			+	"~!btapply : Displays link to Build Team application information\n\n"
			   +"===============================================");
		
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