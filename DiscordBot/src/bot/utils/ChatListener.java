package bot.utils;

import java.io.File;

import net.dv8tion.jda.events.ReadyEvent;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;
import bot.Main;

public class ChatListener extends ListenerAdapter
{
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event)
	{
		if(event.getMessage().getAuthor().getId() != event.getJDA().getSelfInfo().getId())
		{	
			for(String stuff : Main.banned_chat)
			{
				int index = stuff.indexOf("=");
				String lookfor = stuff.substring(0, index);
				String say = stuff.substring(index+1);
				
				if(event.getMessage().getContent().contains(lookfor))
				{
					event.getMessage().deleteMessage();
					
					//event.getTextChannel().sendMessage(event.getAuthor().getUsername() + ", please do not use " + say);
					event.getAuthor().getPrivateChannel().sendMessage(event.getAuthor().getUsername() + ", please do not use " + say);
					//event.getAuthor().getPrivateChannel().sendMessage(event.getAuthor().getUsername() + ", you have been kicked from the group");
				}
			}
			//Main.handleChat(event.getMessage().getContent().toLowerCase(), event);
		}
	}
	
	@Override
	public void onReady(ReadyEvent event)
	{
		//Main.log("STATUS", "Logged in as: " + event.getJDA().getSelfInfo().getUsername());
	}
	
}
