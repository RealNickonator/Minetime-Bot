package bot;

import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.ReadyEvent;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;

public class BotListener extends ListenerAdapter
{
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event)
	{
		if(event.getMessage().getContent().startsWith("~!") && 
				event.getMessage().getAuthor().getId() != event.getJDA().getSelfInfo().getId())
		{
			event.getMessage().deleteMessage();
			User user = event.getMessage().getAuthor();
			
			if(event.getMessage().getContent().contains("togglemute"))
			{
				if(!event.getGuild().getRolesForUser(user).isEmpty())
				{
					Main.handleCommand(Main.parser.parse(event.getMessage().getContent(), event));
				}
				else
				{
					event.getMessage().deleteMessage();
				}
			}
			else
			{
				Main.handleCommand(Main.parser.parse(event.getMessage().getContent(), event));
			}
		}
	}
	
	@Override
	public void onReady(ReadyEvent event)
	{
		//Main.log("STATUS", "Logged in as: " + event.getJDA().getSelfInfo().getUsername());
	}
	
}
