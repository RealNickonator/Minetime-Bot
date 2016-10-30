package bot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;

import org.json.JSONObject;

import bot.commands.AIQuestionCommand;
import bot.commands.AITalkCommand;
import bot.commands.BuildTeamCommand;
import bot.commands.GetChatCommand;
import bot.commands.HelpCommand;
import bot.commands.InfoCommand;
import bot.commands.MojangCommand;
import bot.commands.MuteChatCommand;
import bot.commands.RulesCommand;
import bot.commands.StaffCommand;
import bot.commands.StylesCommand;
import bot.utils.ChatListener;
import bot.utils.CommandParser;


public class Main 
{
	private static JDA jda;
	public static final CommandParser parser = new CommandParser();
	public static HashMap<String, Command> commands = new HashMap<String, Command>();
	public static ArrayList<String> banned_chat = new ArrayList<String>();
	public static JSONObject chatJson;
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		try
		{
			jda = new JDABuilder().addListener(new BotListener()).addListener(new ChatListener()).setBotToken("MjQxMTIzOTg2OTQ2MjYwOTky.CvNU1Q.esREKkWdkgTsFd_IuwMIO2Vv8qQ").buildBlocking();
			jda.getAccountManager().setGame("~!help for commands");
			jda.getAccountManager().setUsername("Minetime Bot");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\nick6_000\\Desktop\\Minetime Client\\jars\\BlackCat\\autostaff2.txt")))) 
		{
		    String line;
		    while ((line = br.readLine()) != null) 
		    {
		    	banned_chat.add(line);
		    }
		}
		
		commands.put("rules", new RulesCommand());
		commands.put("btapply", new BuildTeamCommand());
		commands.put("staff", new StaffCommand());
		commands.put("help", new HelpCommand());
		commands.put("togglemute", new MuteChatCommand());
		commands.put("api", new MojangCommand());
		commands.put("talk", new AITalkCommand());
		commands.put("q", new AIQuestionCommand());
		commands.put("styles", new StylesCommand());
		commands.put("info", new InfoCommand());
		commands.put("getchat", new GetChatCommand());
	}
	
	public static void handleCommand(CommandParser.CommandContainer cmd)
	{
		if(commands.containsKey(cmd.invoke))
		{
			boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);
			
			if(safe)
			{
				commands.get(cmd.invoke).action(cmd.args, cmd.event);
				commands.get(cmd.invoke).executed(safe, cmd.event);
			}
			else
			{
				commands.get(cmd.invoke).executed(safe, cmd.event);
			}
		}
	}
}
