package bot.utils;

import java.util.List;

import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.ReadyEvent;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import bot.Main;
import bot.commands.GetChatCommand;
import bot.commands.MuteChatCommand;

public class ChatListener extends ListenerAdapter
{
	public static JSONObject chatJSON = new JSONObject();
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event)
	{
		if(event.getMessage().getAuthor().getId() != event.getJDA().getSelfInfo().getId())
		{	
			/* Performs the following tasks IF text chat is NOT muted. */
			if(!MuteChatCommand.isMuted)
			{
				String sender = event.getAuthor().getDiscriminator();
				String msg = event.getMessage().getContent();
				
				/* Performs the following tasks IF the sent message DOES NOT start with ~! */
				if(!msg.startsWith("~!"))
				{
					/* Checks if the message sender is in the Chat JSON. */
					if(chatJSON.isNull(sender))
					{
						/* Adds the message sender to the Chat JSON is they are not in it. */
						JSONArray array = new JSONArray();
						JSONObject obj = new JSONObject();
						obj.put("time", System.currentTimeMillis());
						obj.put("message", msg);
						obj.put("channel", event.getGuild().getName());
					    array.put(obj);
					    chatJSON.put(sender , array);
					}
					else
					{
						/* Gets the existing JSON array of the message sender. */
						JSONArray existing_array = (chatJSON.getJSONArray(sender).length() >= 25) ? new JSONArray() : chatJSON.getJSONArray(sender);
						
						/* Checks if the message is spam. */
						if(isSpamming(existing_array, System.currentTimeMillis(), msg, event))
						{
							event.getMessage().deleteMessage();
						}
						else
						{
							/* Adds the message data to the Chat JSON if it is not spam. */
							JSONObject json_obj = new JSONObject();
							json_obj.put("time", System.currentTimeMillis());
							json_obj.put("message", msg);
							json_obj.put("channel", event.getGuild().getName());
							existing_array.put(json_obj);
							chatJSON.put(sender, existing_array);
						}
					}
				}
				
				/* Iterates through all banned words/phrases. */
				for(String stuff : Main.banned_chat)
				{
					int index = stuff.indexOf("=");
					String lookfor = stuff.substring(0, index);
					String say = stuff.substring(index+1);
					
					/* Checks if the message contains banned words/phrases */
					if(event.getMessage().getContent().contains(lookfor))
					{
						event.getMessage().deleteMessage();
						event.getAuthor().getPrivateChannel().sendMessage(event.getAuthor().getUsername() + ", please do not use " + say);
					}
				}
			}
			else
			{
				/* Deletes messages from default users if chat is muted. */
				User user = event.getMessage().getAuthor();	
				if(event.getGuild().getRolesForUser(user).isEmpty())
				{
					event.getMessage().deleteMessage();
				}
			}
		}
	}
	
	/* The method that handles spam detection. */
	public boolean isSpamming(JSONArray array, long time, String msg, MessageReceivedEvent event)
	{
		List<String[]> values = GetChatCommand.getChatData(array, event);
		
		if(values.size() >= 3)
		{
			/* Calculating the elapsed time from the current message to the previous two messages.*/
			long curr_time = time;
			long prev_time1 = Long.valueOf(values.get(values.size() - 1)[1]);
			long prev_time2 = Long.valueOf(values.get(values.size() - 2)[1]);
			double delta1 = prev_time1 - prev_time2;
			double elpasedSeconds1 = delta1 / 1000.0;
			double delta2 = curr_time - prev_time1;
			double elpasedSeconds2 = delta2 / 1000.0;
			/* If both elapsed times are less than 1.2 seconds, then it will be flagged as spam. */
			if( (elpasedSeconds1 < 1.2) && (elpasedSeconds2 < 1.2) )
			{
				return true;
			}
			
			/* Creating arrays containing the words from the previous message and current message. */
			String prev_msg = values.get(values.size() - 1)[2];
			String curr_msg = msg;
			String[] prev_words = (prev_msg.contains(" ")) ? prev_msg.split(" ") : new String[]{prev_msg};
			String[] curr_words = (curr_msg.contains(" ")) ? curr_msg.split(" ") : new String[]{curr_msg};
			
			/*If the message is only one word the Bot will check for repeated letters to indicate spam.*/
			if(prev_words.length == 1 && curr_words.length == 1)
			{
				/* Creating arrays containing each letter from the previous message and current message */
				String[] prev_letters = prev_msg.split("");
				String[] curr_letters = curr_msg.split("");
				
				int matches = 0;
				
				for(int i = 0; i < prev_letters.length; i++)
				{
					for(int j = 0; j < curr_letters.length; j++)
					{
						if(curr_letters[j].equalsIgnoreCase(prev_letters[i]))
						{
							matches++;
						}
					}
				}
				/* If the word contains +80% of the letters from the previous word, then it will be flagged as spam.*/
				if((((double)curr_letters.length * 0.8) <= matches) && (((double)prev_letters.length * 0.80) <= matches))
				{
					return true;
				}
			}
			else
			{
				int matches = 0;
				
				for(int i = 0; i < prev_words.length; i++)
				{
					for(int j = 0; j < curr_words.length; j++)
					{
						if(curr_words[j].equalsIgnoreCase(prev_words[i]))
						{
							matches++;
						}
					}
				}
				/* If the message contains +80% of the words from the previous message, then it will be flagged as spam.*/
				if((((double)curr_words.length * 0.80) <= matches) && (((double)prev_words.length * 0.80) <= matches))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public void onReady(ReadyEvent event)
	{
		//Main.log("STATUS", "Logged in as: " + event.getJDA().getSelfInfo().getUsername());
	}
	
}
