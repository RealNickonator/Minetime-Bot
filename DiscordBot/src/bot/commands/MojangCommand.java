package bot.commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import bot.Command;

public class MojangCommand implements Command
{
	private final String HELP_ = "USAGE: ~!api";
	public static String asdf;
	public static String aaaa;

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) 
	{
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) 
	{	
		try {
			
			URL url = new URL(("https://api.mojang.com/users/profiles/minecraft/" + args[0]));
			URLConnection conn = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
			{
				asdf = inputLine;
			}
			in.close();
			
			
			
			String str = asdf;
			str = str.substring(str.indexOf("\":\"")+3, str.indexOf("\",\""));
			
			
			
			
			event.getTextChannel().sendMessage("UUID: " + str);
			
			//https://api.mojang.com/user/profiles/9e7c969a3733436dbfe5b6c41879b961/names
			
			URL url1 = new URL(("https://api.mojang.com/user/profiles/" + str + "/names"));
			URLConnection conn1 = url1.openConnection();
			BufferedReader in1 = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
			String inputLine1;
			while ((inputLine1 = in1.readLine()) != null)
			{
				aaaa = inputLine1;
			}
			in.close();
			
			event.getTextChannel().sendMessage("Previous Names: " + aaaa);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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