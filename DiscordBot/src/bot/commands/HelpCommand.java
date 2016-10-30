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
				"```Markdown\n#Minetime Bot Commands\n\n"
			+	"[~!help](The Help Command)\n\n" 
			+	"[~!info](Displays bot information)\n\n"
			+	"[~!rules](Displays link to Rules & Terms)\n\n"
			+	"[~!staff](Displays link to staff member list)\n\n"
			+	"[~!btapply](Displays link to Build Team application information)\n\n"
			+   "[~!togglemute](Enables/Disables text channel mute)\n\n"
			+	"[~!api <mc username>](Displays previous usernames and UUID of the requested user)\n\n"
			+	"[~!getchat <Discord ID#>](Displays recent chat logs from the requested user)\n\n"
			+	"[~!q <question>](Asks the AI a question)\n\n"
			+	"[~!talk](Makes the AI generate a sentence)\n\n"
			+	"[~!bleach](Displays GIF of filling a glass with bleach)\n\n"
			+	"[~!styles](ATTENTION: Styles is a God)\n\n"
			+	"```");
		
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