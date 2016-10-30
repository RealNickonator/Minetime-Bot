package bot.commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.dv8tion.jda.events.message.MessageReceivedEvent;

import org.json.JSONArray;

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
		event.getMessage().deleteMessage();
		
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
			
			
			
			URL url1 = new URL("https://api.mojang.com/user/profiles/" + str + "/names");
			URLConnection conn1 = url1.openConnection();
			BufferedReader in1 = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
			String inputLine1;
			while ((inputLine1 = in1.readLine()) != null)
			{
				aaaa = inputLine1;
				
				JSONArray arr = new JSONArray(aaaa);
				List<String> list = new ArrayList<String>();
				List<String> time_list = new ArrayList<String>();
				
				for(int i = 0; i < arr.length(); i++)
				{
				    list.add(arr.getJSONObject(i).getString("name"));
				}
				String asdf = arr.getJSONObject(0).getString("name");
				int num1 = list.indexOf(asdf);
				list.remove(num1);
				list.add(num1, asdf);
				int num2 = list.size() - 1;
				list.remove(num2);
				list.add(num2, arr.getJSONObject(arr.length()-1).getString("name"));
				
				
				for(int ii = 1; ii < arr.length(); ii++)
				{
					String times = arr.getJSONObject(ii).toString().replace("{\"name\":\"" + arr.getJSONObject(ii).getString("name") + "\",\"changedToAt\":", "");
					times = times.replace("}", "");
					
					long time = Long.valueOf(times);
					
					Date date = new Date(time);
				    Format format = new SimpleDateFormat("MM/dd/YYYY @ HH:mm:ss");
					
					time_list.add(format.format(date).toString());
				}
				
				
				String nameList = list.toString();
				nameList = nameList.replace("[", "");
				nameList = nameList.replace("]", "");
				
				String data = "";
				
				for(int a = 0; a < list.size(); a++)
				{
					if(a > 0)
					{
						data += "\n[" + list.get(a) + "](" + time_list.get(a-1) + ")";
					}
					else
					{
						data += "\n[" + list.get(a) + "](N/A)";
					}
				}
				String print = 
						  "```Markdown\n"
						+ "#Info for " + args[0] + "\n\n"
						+ "#Previous Names:"
						+ data
						+ "\n\n[UUID](" + str + ")```";
				
				event.getAuthor().getPrivateChannel().sendMessage(print);
			}
			in.close();

			aaaa = "";
			asdf = "";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			event.getAuthor().getPrivateChannel().sendMessage("```ERROR: Could not complete request.```");
			aaaa = "";
			asdf = "";
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